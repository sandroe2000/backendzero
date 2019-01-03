package br.com.sdvs.cdr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sdvs.cdr.model.FormsOfAddress;
import br.com.sdvs.cdr.repository.FormsOfAddressRepository;

@RestController
@RequestMapping("formsofaddress")
public class FormsOfAddressRestController {

	@Autowired
    private FormsOfAddressRepository repository;
        
    @RequestMapping(value = "pageable", method = RequestMethod.GET)
    public ResponseEntity<Page<FormsOfAddress>> listSearchJpa(@ModelAttribute FormsOfAddress formaDeTratamento, @PageableDefault(page = 0, size = 5) Pageable pageable) {
    	String descr = formaDeTratamento.getDescr().trim();
    	if(descr==null) descr = "";
    	Page<FormsOfAddress> pageFormaDeTratamentos = repository.findPageable(descr.toUpperCase().concat("%"), pageable);
        return new ResponseEntity<>(pageFormaDeTratamentos, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<FormsOfAddress>> findAll(){
    	List<FormsOfAddress> entitys = repository.findAll();
        return new ResponseEntity<>(entitys, HttpStatus.OK);
    }
        
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<FormsOfAddress> findOne(@PathVariable("id") Long id){
    	FormsOfAddress entity = repository.findOne(id);
    	HttpStatus returnStatus = HttpStatus.OK;
    	if(entity == null) {
    		returnStatus = HttpStatus.NO_CONTENT;
    	}
        return new ResponseEntity<>(entity, returnStatus);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormsOfAddress> create(@RequestBody FormsOfAddress entity, HttpServletRequest request){
    	FormsOfAddress currentEntity = repository.findOneByDescr(entity.getDescr());
        if (currentEntity!=null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT); 
        }else{
            repository.save(entity);
            return new ResponseEntity<>(entity, HttpStatus.CREATED);
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FormsOfAddress> update(HttpServletRequest request, @PathVariable("id") Long id, @RequestBody FormsOfAddress entity) {
    	FormsOfAddress currentEntity = repository.findOne(id);
        if (currentEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            repository.save(entity);
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<FormsOfAddress> delete(HttpServletRequest request, @PathVariable("id") Long id) {
    	FormsOfAddress currentEntity = repository.findOne(id);
    	if (currentEntity==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            repository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}