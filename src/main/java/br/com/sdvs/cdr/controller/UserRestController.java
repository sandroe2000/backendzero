package br.com.sdvs.cdr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sdvs.cdr.model.User;
import br.com.sdvs.cdr.repository.UserRepository;
import br.com.sdvs.cdr.utils.datatable.DataTableIn;
import br.com.sdvs.cdr.utils.datatable.DataTableOut;

@RestController
@RequestMapping("/users")
public class UserRestController {

	@Autowired
    private UserRepository repository;
    
    @Autowired
    private DataTableOut<User> dataTable;
        
    @RequestMapping(value = "/pageable", method = RequestMethod.GET)
    public ResponseEntity<DataTableOut<User>> findAllPageable(HttpServletRequest request, @ModelAttribute DataTableIn data){
    	Page<User> page = repository.findPageable(data.getSerchValue(), data.getPageableIn());
        return new ResponseEntity<>(dataTable.getPageOut(page, data.getDraw()), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
    	List<User> entitys = repository.findAll();
        return new ResponseEntity<>(entitys, HttpStatus.OK);
    }
    
    @RequestMapping(value = "perfil/{login}", method = RequestMethod.GET)
    public ResponseEntity<User> findOneByUsername(@PathVariable("login") String login){
    	User entity =  repository.findOneByUsername(login);
    	HttpStatus returnStatus = HttpStatus.OK;
    	if(entity == null) {
    		returnStatus = HttpStatus.NO_CONTENT;
    	}
    	entity.setPassword("********");
        return new ResponseEntity<>(entity, returnStatus);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> findOne(@PathVariable("id") Long id){
    	User entity = repository.findOne(id);
    	HttpStatus returnStatus = HttpStatus.OK;
    	if(entity == null) {
    		returnStatus = HttpStatus.NO_CONTENT;
    	}
        return new ResponseEntity<>(entity, returnStatus);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestBody User entity, HttpServletRequest request){
    	User currentEntity = repository.findOneByUsername(entity.getUsername());
        if (currentEntity!=null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT); 
        }else{
        	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        	entity.setPassword(passwordEncoder.encode(entity.getPassword()));
            repository.save(entity);
            return new ResponseEntity<>(entity, HttpStatus.CREATED);
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> update(HttpServletRequest request, @PathVariable("id") Long id, @RequestBody User entity) {
    	User currentEntity = repository.findOne(id);
        if (currentEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
        	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        	entity.setPassword(passwordEncoder.encode(entity.getPassword()));
            repository.save(entity);
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> delete(HttpServletRequest request, @PathVariable("id") Long id) {
    	User currentEntity = repository.findOne(id);
    	if (currentEntity==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            repository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
