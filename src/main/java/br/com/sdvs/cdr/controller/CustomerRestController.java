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

import br.com.sdvs.cdr.model.Customer;
import br.com.sdvs.cdr.model.dto.CustomerDto;
import br.com.sdvs.cdr.repository.CustomerDao;
import br.com.sdvs.cdr.repository.CustomerRepository;
import br.com.sdvs.cdr.specification.CustomerSpecifications;
import br.com.sdvs.cdr.utils.datatable.DataTableIn;
import br.com.sdvs.cdr.utils.datatable.DataTableOut;

@RestController
@RequestMapping("customers")
public class CustomerRestController {

	@Autowired
    private CustomerRepository repository;
	
	@Autowired
	private CustomerDao dao;
	
	@Autowired
	CustomerSpecifications customerSpecifications;
    
    @Autowired
    private DataTableOut<Customer> dataTable;
        
    @RequestMapping(value = "pageable", method = RequestMethod.GET)
    public ResponseEntity<DataTableOut<Customer>> findAllPageable(HttpServletRequest request, @ModelAttribute DataTableIn data){
    	Page<Customer> page = repository.findPageable(data.getSerchValue(), data.getPageableIn());
        return new ResponseEntity<>(dataTable.getPageOut(page, data.getDraw()), HttpStatus.OK);
    }
    /*
    @RequestMapping(value = "search/", method = RequestMethod.GET)
    public ResponseEntity<Page<Customer>> listSearchJpa(@ModelAttribute CustomerDto dto,
    		                                         @PageableDefault(page = 0, size = 5) Pageable pageable){
    	Page<Customer> pageCustomers = repository.findAll(CustomerSpecifications.searchCustomer(dto), pageable);
        return new ResponseEntity<>(pageCustomers, HttpStatus.OK);
    }
    */
    
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ResponseEntity<Page<Customer>> listSearchJdbc(@ModelAttribute CustomerDto dto,
    		                                         @PageableDefault(page = 0, size = 5) Pageable pageable){
    	Page<Customer> pageCustomers = dao.getPageableCustomer(dto, pageable);
        return new ResponseEntity<>(pageCustomers, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> findAll(){
    	List<Customer> entitys = (List<Customer>) repository.findAll();
        return new ResponseEntity<>(entitys, HttpStatus.OK);
    }
        
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> findOne(@PathVariable("id") Long id){
    	Customer entity = repository.findOne(id);
    	HttpStatus returnStatus = HttpStatus.OK;
    	if(entity == null) {
    		returnStatus = HttpStatus.NO_CONTENT;
    	}
        return new ResponseEntity<>(entity, returnStatus);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> create(@RequestBody Customer entity, HttpServletRequest request){
    	Customer currentEntity = repository.findOneByName(entity.getName());
        if (currentEntity!=null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT); 
        }else{
            repository.save(entity);
            return new ResponseEntity<>(entity, HttpStatus.CREATED);
        }
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> update(HttpServletRequest request, @PathVariable("id") Long id, @RequestBody Customer entity) {
    	Customer currentEntity = repository.findOne(id);
        if (currentEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            repository.save(entity);
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> delete(HttpServletRequest request, @PathVariable("id") Long id) {
    	Customer currentEntity = repository.findOne(id);
    	if (currentEntity==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            repository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK); 
        }
    }
}
