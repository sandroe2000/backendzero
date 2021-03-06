package br.com.sdvs.cdr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="combo_box_option", indexes = {@Index(name="idx_comboboxoption", columnList="id, fk_combo_box"), @Index(name="idx_comboboxoption_descr", columnList="descr")})
public class ComboBoxOption implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fk_combo_box", nullable = false)
	private Long fkComboBox;

	@Column(name = "corporate_id", nullable = true, unique = true)
	private String corporateId;
	
	@Column(nullable = false, unique = true)
	private String descr;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date disabled;
	
	public ComboBoxOption() {
		super();
	}

	public ComboBoxOption(Long id, Long fkComboBox, String corporateId, String descr, Date disabled) {
		this.id = id;
		this.fkComboBox = fkComboBox;
		this.corporateId = corporateId;
		this.descr = descr;
		this.disabled = disabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFkComboBox() {
		return fkComboBox;
	}

	public void setFkComboBox(Long fkComboBox) {
		this.fkComboBox = fkComboBox;
	}

	public String getCorporateId() {
		return corporateId;
	}

	public void setCorporateId(String corporateId) {
		this.corporateId = corporateId;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Date getDisabled() {
		return disabled;
	}

	public void setDisabled(Date disabled) {
		this.disabled = disabled;
	}
}
