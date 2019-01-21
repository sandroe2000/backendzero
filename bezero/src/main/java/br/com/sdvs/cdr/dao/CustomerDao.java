package br.com.sdvs.cdr.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sdvs.cdr.model.Customer;
import br.com.sdvs.cdr.model.Phone;
import br.com.sdvs.cdr.model.dto.CustomerDto;
import br.com.sdvs.cdr.model.enumerated.Principal;

@Transactional
@Repository
public class CustomerDao {
	
	static Logger logger = LoggerFactory.getLogger(CustomerDao.class);
    private final JdbcTemplate jdbcTemplate;
	
    @Autowired
	public CustomerDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    
    public Page<Customer> getPageableCustomer(CustomerDto dto, Pageable pageable){
    	
    	List<String> list = new ArrayList<String>();
    	String paramsSql = "from customer "
				+ "left join phone on "
				+ "		customer.id = phone.fk_customer "
				+ "			and phone.is_principal = 'sim' "
				+ "left join email on "
				+ "		customer.id = email.fk_customer "
				+ "			and email.is_principal = 'sim' "
				+ "where "
				+ "		1 = 1 ";
    	String[] sort = pageable.getSort().toString().split(":");
    	String paramsSort = "";
    	if(sort.length>0) {
    		paramsSort += "order by "+ sort[0] +" "+ sort[1] +" ";
    	}
    	
		if(!StringUtils.isBlank(dto.getEmail())) {
			list.add("%" + dto.getEmail() + "%");
			paramsSql += "		and email.email like ? ";
		}
		
		if(!StringUtils.isBlank(dto.getPhone())) {
			list.add("%" + dto.getPhone() + "%");
			paramsSql += "		and phone.phone like ? ";
		}
		
		if(!StringUtils.isBlank(dto.getName())) {
			list.add("%" + dto.getName().toLowerCase() + "%"); 
			paramsSql += "		and customer.name like ? ";
		}
		
		if(!StringUtils.isBlank(dto.getCpfcnpj())) {
			list.add(dto.getCpfcnpj().toLowerCase());
			paramsSql += "		and customer.cpf_cnpj = ? ";
		}
		
		if(!StringUtils.isBlank(dto.getRgIe())) {
			list.add(dto.getRgIe().toLowerCase());
			paramsSql += "		and customer.rg_ie = ? ";
		}
		
		if(!StringUtils.isBlank(dto.getDocument())) {
			list.add(dto.getDocument().toLowerCase());
			paramsSql += "		and customer.document = ? ";
		}
    	
    	String countSql  = "select count(1) as row_count "
    				+ paramsSql;
    	
    	int total = jdbcTemplate.queryForObject(countSql, list.toArray(), (rs, rowNum) -> 
    		rs.getInt(1)
    	);
    	logger.info(countSql);
    	
    	String searchSql = "select "
    				+ "		customer.id, "
    				+ "		customer.corporate_id, "
    				+ "		customer.name, "
    				+ "		phone.id as phone_id, "
    				+ "		phone.phone as phones, "
    				+ "		customer.cpf_cnpj, "
    				+ "		customer.rg_ie "
    				+ paramsSql
    				+ paramsSort
    				+ "limit " + pageable.getPageSize() + " "
    		        + "offset " + pageable.getOffset() + " ";
    	List<Customer> customers = jdbcTemplate.query(searchSql, list.toArray(), (rs, rowNum) -> {
    				Customer customer = new Customer();    				    				
    				customer.setId(rs.getLong("id"));
    				customer.setCorporateId(rs.getString("corporate_id"));
    				customer.setName(rs.getString("name"));
    				customer.setCpfCnpj(rs.getString("cpf_cnpj"));
    				customer.setRgIe(rs.getString("rg_ie"));
    				if(rs.getLong("phone_id")>0) {
    					List<Phone> phones = new ArrayList<Phone>();
    					Phone phone = new Phone(rs.getLong("phone_id"), Principal.SIM, rs.getString("phones"));
	    				phones.add(phone);
	    				customer.setPhones(phones);
    				}
    				return customer;
    			});
    	logger.info(searchSql);
    	return new PageImpl<>(customers, pageable, total);

    }
}