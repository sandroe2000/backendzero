package br.com.sdvs.cdr.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import br.com.sdvs.cdr.model.enumerated.Principal;

@Entity
@Table(indexes = {@Index(name="IDX_PHONE", columnList="id, phone")})
public class Phone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Principal isPrincipal;
	
	@Column(nullable = false, unique = true)
	private String phone;

	public Phone() {
		super();
	}

	public Phone(Long id, Principal isPrincipal, String phone) {
		super();
		this.id = id;
		this.isPrincipal = isPrincipal;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Principal getIsPrincipal() {
		return isPrincipal;
	}

	public void setIsPrincipal(Principal isPrincipal) {
		this.isPrincipal = isPrincipal;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", isPrincipal=" + isPrincipal + ", phone=" + phone + "]";
	}
}
