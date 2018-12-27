package br.com.sdvs.cdr.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import br.com.sdvs.cdr.model.Customer;

@Component
public class CustomerSpecifications {
	
	public static Specification<Customer> filterSearch(final Customer data){
		return (Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();
			if(!StringUtils.isBlank(data.getName())) {
				predicates.add(criteriaBuilder.like(root.get("name"), "%" + data.getName() + "%"));
			}
			if(!StringUtils.isBlank(data.getEmail())) {
				predicates.add(criteriaBuilder.like(root.get("email"), "%" + data.getEmail() + "%"));
			}
			if(!StringUtils.isBlank(data.getCellphone())) {
				predicates.add(criteriaBuilder.like(root.get("cellphone"), "%" + data.getCellphone() + "%"));
			}
			if(!StringUtils.isBlank(data.getCpfCnpj())) {
				predicates.add(criteriaBuilder.like(root.get("cpfCnpj"), "%" + data.getCpfCnpj() + "%"));
			}
			if(!StringUtils.isBlank(data.getRgIe())) {
				predicates.add(criteriaBuilder.like(root.get("rgIe"), "%" + data.getRgIe() + "%"));
			}
			if(!StringUtils.isBlank(data.getDocument())) {
				predicates.add(criteriaBuilder.like(root.get("document"), "%" + data.getDocument() + "%"));
			}
			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}
}
