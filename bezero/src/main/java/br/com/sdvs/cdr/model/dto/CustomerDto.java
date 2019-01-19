package br.com.sdvs.cdr.model.dto;

import java.io.Serializable;

public class CustomerDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String email;
	private String phone;
	private String cpfcnpj;
	private String rgIe;
	private String document;
	
	public CustomerDto() {
		super();
	}

	public CustomerDto(String name, String email, String phone, String cpfcnpj, String rgIe, String document) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.cpfcnpj = cpfcnpj;
		this.rgIe = rgIe;
		this.document = document;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public String getRgIe() {
		return rgIe;
	}

	public void setRgIe(String rgIe) {
		this.rgIe = rgIe;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}
}
