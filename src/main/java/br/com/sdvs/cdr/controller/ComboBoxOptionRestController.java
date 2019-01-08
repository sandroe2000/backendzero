package br.com.sdvs.cdr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sdvs.cdr.model.ComboBoxOption;
import br.com.sdvs.cdr.repository.ComboBoxOptionRepository;

@RestController
@RequestMapping("comboboxoptions")
public class ComboBoxOptionRestController {

	@Autowired
    private ComboBoxOptionRepository repository;
        
    @GetMapping(value = "pageable")
    public ResponseEntity<Page<ComboBoxOption>> listSearchJpa(@RequestParam("fk") Long fk, 
    														  @RequestParam("descr") String descr, 
    		                                                  @PageableDefault(page = 0, size = 5) Pageable pageable) {
    	Page<ComboBoxOption> pageEntity = repository.findPageable(fk, descr.toUpperCase().concat("%"), pageable);
        return new ResponseEntity<>(pageEntity, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ComboBoxOption>> findAll(@RequestParam("fk") Long fk) {
    	List<ComboBoxOption> entity = repository.findAllByFk(fk);
    	HttpStatus returnStatus = HttpStatus.OK;
    	if(entity == null) {
    		returnStatus = HttpStatus.NO_CONTENT;
    	}
        return new ResponseEntity<>(entity, returnStatus);
    }
        
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ComboBoxOption> findOne(@PathVariable("id") Long id) {
    	ComboBoxOption entity = repository.findOne(id);
    	HttpStatus returnStatus = HttpStatus.OK;
    	if(entity == null) {
    		returnStatus = HttpStatus.NO_CONTENT;
    	}
        return new ResponseEntity<>(entity, returnStatus);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ComboBoxOption> create(@RequestBody ComboBoxOption entity) {
    	ComboBoxOption currentEntity = repository.findOneByDescr(entity.getDescr());
        if (currentEntity!=null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT); 
        }else{
            repository.save(entity);
            return new ResponseEntity<>(entity, HttpStatus.CREATED);
        }
    }
    
    @PutMapping
    @Transactional
    public ResponseEntity<ComboBoxOption> update(@RequestBody ComboBoxOption entity) {
    	ComboBoxOption currentEntity = repository.findOne(entity.getId());
        if (currentEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            repository.save(entity);
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ComboBoxOption> delete(HttpServletRequest request, @PathVariable("id") Long id) {
    	ComboBoxOption currentEntity = repository.findOne(id);
    	if (currentEntity==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            repository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}