package br.com.sdvs.cdr.repository;

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
    	String paramsSql = "FROM CUSTOMER "
				+ "LEFT JOIN PHONE ON "
				+ "		CUSTOMER.ID = PHONE.FK_CUSTOMER "
				+ "			AND PHONE.IS_PRINCIPAL = 'SIM' "
				+ "LEFT JOIN EMAIL ON "
				+ "		CUSTOMER.ID = EMAIL.FK_CUSTOMER "
				+ "			AND EMAIL.IS_PRINCIPAL = 'SIM' "
				+ "WHERE "
				+ "		1 = 1 ";
    	String[] sort = pageable.getSort().toString().split(":");
    	String paramsSort = "";
    	if(sort.length>0) {
    		paramsSort += "ORDER BY "+ sort[0] +" "+ sort[1] +" ";
    	}
    	
		if(!StringUtils.isBlank(dto.getEmail())) {
			list.add("%" + dto.getEmail() + "%");
			paramsSql += "		AND EMAIL.EMAIL LIKE ? ";
		}
		
		if(!StringUtils.isBlank(dto.getPhone())) {
			list.add("%" + dto.getPhone() + "%");
			paramsSql += "		AND PHONE.PHONE LIKE ? ";
		}
		
		if(!StringUtils.isBlank(dto.getName())) {
			list.add("%" + dto.getName().toLowerCase() + "%"); 
			paramsSql += "		AND CUSTOMER.NAME LIKE ? ";
		}
		
		if(!StringUtils.isBlank(dto.getCpfcnpj())) {
			list.add(dto.getCpfcnpj().toLowerCase());
			paramsSql += "		AND CUSTOMER.CPF_CNPJ = ? ";
		}
		
		if(!StringUtils.isBlank(dto.getRgIe())) {
			list.add(dto.getRgIe().toLowerCase());
			paramsSql += "		AND CUSTOMER.RG_IE = ? ";
		}
		
		if(!StringUtils.isBlank(dto.getDocument())) {
			list.add(dto.getDocument().toLowerCase());
			paramsSql += "		AND CUSTOMER.DOCUMENT = ? ";
		}
    	
    	String countSql  = "SELECT COUNT(1) AS ROW_COUNT "
    				+ paramsSql;
    	
    	int total = jdbcTemplate.queryForObject(countSql, list.toArray(), (rs, rowNum) -> 
    		rs.getInt(1)
    	);
    	logger.info(countSql);
    	
    	String searchSql = "SELECT "
    				+ "		CUSTOMER.ID, "
    				+ "		CUSTOMER.CORPORATE_ID, "
    				+ "		CUSTOMER.NAME, "
    				+ "		PHONE.ID AS PHONE_ID, "
    				+ "		PHONE.PHONE AS PHONES, "
    				+ "		CUSTOMER.CPF_CNPJ, "
    				+ "		CUSTOMER.RG_IE "
    				+ paramsSql
    				+ paramsSort
    				+ "LIMIT " + pageable.getPageSize() + " "
    		        + "OFFSET " + pageable.getOffset() + " ";
    	List<Customer> customers = jdbcTemplate.query(searchSql, list.toArray(), (rs, rowNum) -> {
    				Customer customer = new Customer();    				    				
    				customer.setId(rs.getLong("ID"));
    				customer.setCorporateId(rs.getString("CORPORATE_ID"));
    				customer.setName(rs.getString("NAME"));
    				customer.setCpfCnpj(rs.getString("CPF_CNPJ"));
    				customer.setRgIe(rs.getString("RG_IE"));
    				if(rs.getLong("PHONE_ID")>0) {
    					List<Phone> phones = new ArrayList<Phone>();
    					Phone phone = new Phone(rs.getLong("PHONE_ID"), Principal.SIM, rs.getString("PHONES"));
	    				phones.add(phone);
	    				customer.setPhones(phones);
    				}
    				return customer;
    			});
    	logger.info(searchSql);
    	return new PageImpl<>(customers, pageable, total);

    }
}