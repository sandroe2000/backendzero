package br.com.sdvs.cdr.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sdvs.cdr.model.FormsOfAddress;

public interface FormsOfAddressRepository extends  JpaRepository<FormsOfAddress, Long> {

	public FormsOfAddress findOneByDescr(String descr);
    
	@Query("select f from  FormsOfAddress f where upper(f.descr) like ?1")
    public Page<FormsOfAddress> findPageable(String descr, Pageable page);
}