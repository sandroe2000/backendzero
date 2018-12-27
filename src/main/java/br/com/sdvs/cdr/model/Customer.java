package br.com.sdvs.cdr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.sdvs.cdr.model.enumerated.DocumentType;
import br.com.sdvs.cdr.model.enumerated.Pfj;

@Entity
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "CORPORATE_ID")
	private Long corporateId;
	
	@Enumerated(EnumType.STRING)
	private Pfj pfj;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "BIRTHSDAY")
	private Date birthsDay;
	
	@Column(nullable = true, unique = true)
	private String email;
	
	private String cellphone;
	
	@Column(name = "COMMERCIAL_PHONE")
	private String commercialPhone;
	
	@Column(name = "CPF_CNPJ", nullable = true, unique = true)
	private String cpfCnpj;
	
	@Column(name = "RG_IE")
	private String rgIe;
	
	@Column(name = "DOCUMENT_TYPE")
	@Enumerated(EnumType.STRING)
	private DocumentType documentType;
	private String document;

	public Customer() {
		super();
	}

	public Customer(Long id, Long corporateId, Pfj pfj, String name, Date birthsDay, String email, String cellphone,
			String commercialPhone, String cpfCnpj, String rgIe, DocumentType documentType, String document) {
		super();
		this.id = id;
		this.corporateId = corporateId;
		this.pfj = pfj;
		this.name = name;
		this.birthsDay = birthsDay;
		this.email = email;
		this.cellphone = cellphone;
		this.commercialPhone = commercialPhone;
		this.cpfCnpj = cpfCnpj;
		this.rgIe = rgIe;
		this.documentType = documentType;
		this.document = document;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCorporateId() {
		return corporateId;
	}

	public void setCorporateId(Long corporateId) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getCommercialPhone() {
		return commercialPhone;
	}

	public void setCommercialPhone(String commercialPhone) {
		this.commercialPhone = commercialPhone;
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", corporateId=" + corporateId + ", pfj=" + pfj + ", name=" + name
				+ ", birthsDay=" + birthsDay + ", email=" + email + ", cellphone=" + cellphone + ", commercialPhone="
				+ commercialPhone + ", cpfCnpj=" + cpfCnpj + ", rgIe=" + rgIe + ", documentType=" + documentType + ", document="
				+ document + "]";
	}
}
