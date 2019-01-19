package br.com.sdvs.cdr.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sdvs.cdr.model.ComboBox;

public interface ComboBoxRepository extends  JpaRepository<ComboBox, Long> {

	public ComboBox findOneByDescr(String descr);
    
	@Query("select c from  ComboBox c where upper(c.descr) like ?1")
    public Page<ComboBox> findPageable(String descr, Pageable page);
}