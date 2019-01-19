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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sdvs.cdr.model.ComboBox;
import br.com.sdvs.cdr.repository.ComboBoxRepository;

@RestController
@RequestMapping("comboboxes")
public class ComboBoxRestController {

	@Autowired
    private ComboBoxRepository repository;
        
    @RequestMapping(value = "pageable", method = RequestMethod.GET)
    public ResponseEntity<Page<ComboBox>> listSearchJpa(@RequestParam("descr") String descr, 
    		                                            @PageableDefault(page = 0, size = 5) Pageable pageable) {
    	Page<ComboBox> pageFormaDeTratamentos = repository.findPageable(descr.toUpperCase().concat("%"), pageable);
        return new ResponseEntity<>(pageFormaDeTratamentos, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ComboBox>> findAll(){
    	List<ComboBox> entitys = repository.findAll();
        return new ResponseEntity<>(entitys, HttpStatus.OK);
    }
        
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ComboBox> findOne(@PathVariable("id") Long id){
    	ComboBox entity = repository.findOne(id);
    	HttpStatus returnStatus = HttpStatus.OK;
    	if(entity == null) {
    		returnStatus = HttpStatus.NO_CONTENT;
    	}
        return new ResponseEntity<>(entity, returnStatus);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ComboBox> create(@RequestBody ComboBox entity, HttpServletRequest request){
    	ComboBox currentEntity = repository.findOneByDescr(entity.getDescr());
        if (currentEntity!=null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT); 
        }else{
            repository.save(entity);
            return new ResponseEntity<>(entity, HttpStatus.CREATED);
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ComboBox> update(HttpServletRequest request, @PathVariable("id") Long id, @RequestBody ComboBox entity) {
    	ComboBox currentEntity = repository.findOne(id);
        if (currentEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            repository.save(entity);
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ComboBox> delete(HttpServletRequest request, @PathVariable("id") Long id) {
    	ComboBox currentEntity = repository.findOne(id);
    	if (currentEntity==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            repository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}