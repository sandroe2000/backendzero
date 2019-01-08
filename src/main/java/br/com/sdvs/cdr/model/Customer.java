package br.com.sdvs.cdr.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.sdvs.cdr.model.enumerated.DocumentType;
import br.com.sdvs.cdr.model.enumerated.Pfj;

@Entity
@Table(indexes = {@Index(name="IDX_CUSTOMER", columnList="ID, NAME, CPF_CNPJ, RG_IE, DOCUMENT")})
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "CORPORATE_ID", nullable = true, unique = true)
	private String corporateId;
	
	@Enumerated(EnumType.STRING)
	private Pfj pfj;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "BIRTHSDAY")
	private Date birthsDay;
	
	@Column(name = "CPF_CNPJ", nullable = true, unique = true)
	private String cpfCnpj;
	
	@Column(name = "RG_IE")
	private String rgIe;
	
	@Column(name = "DOCUMENT_TYPE")
	@Enumerated(EnumType.STRING)
	private DocumentType documentType;
	private String document;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="fk_customer")
	private List<Email> emails = new ArrayList<Email>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)  
	@JoinColumn(name="fk_customer")
	private List<Phone> phones = new ArrayList<Phone>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)  
	@JoinColumn(name="fk_customer")
	private List<Address> address = new ArrayList<Address>();

	public Customer() {
		super();
	}

	public Customer(Long id, String corporateId, Pfj pfj, String name, Date birthsDay, String cpfCnpj, String rgIe,
			DocumentType documentType, String document, List<Email> emails, List<Phone> phones, List<Address> address) {
		super();
		this.id = id;
		this.corporateId = corporateId;
		this.pfj = pfj;
		this.name = name;
		this.birthsDay = birthsDay;
		this.cpfCnpj = cpfCnpj;
		this.rgIe = rgIe;
		this.documentType = documentType;
		this.document = document;
		this.emails = emails;
		this.phones = phones;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCorporateId() {
		return corporateId;
	}

	public void setCorporateId(String corporateId) {
		this.corporateId = corporateId;
	}

	public Pfj getPfj() {
		return pfj;
	}

	public void setPfj(Pfj pfj) {
		this.pfj = pfj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthsDay() {
		return birthsDay;
	}

	public void setBirthsDay(Date birthsDay) {
		this.birthsDay = birthsDay;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getRgIe() {
		return rgIe;
	}

	public void setRgIe(String rgIe) {
		this.rgIe = rgIe;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
}
