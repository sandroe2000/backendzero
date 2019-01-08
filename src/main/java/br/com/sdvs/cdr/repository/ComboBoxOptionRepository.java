package br.com.sdvs.cdr.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sdvs.cdr.model.ComboBoxOption;

public interface ComboBoxOptionRepository extends  JpaRepository<ComboBoxOption, Long> {

	public ComboBoxOption findOneByDescr(String descr);
	
	@Query("select c from  ComboBoxOption c where fk_combo_box = ?1")
	public List<ComboBoxOption> findAllByFk(Long fk_combo_box);
    
	@Query("select c from  ComboBoxOption c where fk_combo_box = ?1 and upper(c.descr) like ?2")
    public Page<ComboBoxOption> findPageable(Long fk_combo_box, String descr, Pageable page);
}