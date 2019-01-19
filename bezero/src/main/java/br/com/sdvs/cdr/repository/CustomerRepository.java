package br.com.sdvs.cdr.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import br.com.sdvs.cdr.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

	public Customer findOneByName(String name);
    
    @Query("select c from Customer c where c.name like ?1")
    public Page<Customer> findPageable(String name, Pageable page);
}
