package br.com.sdvs.cdr.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import br.com.sdvs.cdr.model.Customer;
import br.com.sdvs.cdr.model.dto.CustomerDto;

@Component
public class CustomerSpecifications {
	
	public static Specification<Customer> searchCustomer(final CustomerDto dto){
		return (root, query, cb) -> {
			
			List<Predicate> predicates = new ArrayList<>();
			
			if(!StringUtils.isBlank(dto.getEmail())) {
				predicates.add(cb.like(cb.lower(root.join("emails").get("email")), "%" + dto.getEmail() + "%"));
			}
			
			if(!StringUtils.isBlank(dto.getPhone())) {
				predicates.add(cb.like(cb.lower(root.join("phones").get("phone")), "%" + dto.getPhone() + "%"));
			}
			
			if(!StringUtils.isBlank(dto.getName())) {
				predicates.add(cb.like(cb.lower(root.get("name")), "%" + dto.getName().toLowerCase() + "%")); 
			}
			
			if(!StringUtils.isBlank(dto.getCpfcnpj())) {
				predicates.add(cb.equal(cb.lower(root.get("cpfCnpj")), dto.getCpfcnpj().toLowerCase()));
			}
			
			if(!StringUtils.isBlank(dto.getRgIe())) {
				predicates.add(cb.equal(cb.lower(root.get("rgIe")), dto.getRgIe().toLowerCase()));
			}
			
			if(!StringUtils.isBlank(dto.getDocument())) {
				predicates.add(cb.equal(cb.lower(root.get("document")), dto.getDocument().toLowerCase()));
			}
			
			return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		};
	}
}
