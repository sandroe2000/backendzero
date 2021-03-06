package br.com.sdvs.cdr.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "app_access")
public class Access implements Serializable {

	/*
	mysql> desc access;
	+---------+--------------+------+-----+---------+----------------+
	| Field   | Type         | Null | Key | Default | Extra          |
	+---------+--------------+------+-----+---------+----------------+
	| id      | bigint(20)   | NO   | PRI | NULL    | auto_increment |
	| descr   | varchar(255) | YES  |     | NULL    |                |
	| value   | varchar(255) | YES  |     | NULL    |                |
	| fk_user | bigint(20)   | YES  | MUL | NULL    |                |
	+---------+--------------+------+-----+---------+----------------+
	*/
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	private String descr;
	private String value;
	
	public Access() {
		super();
	}

	public Access(Long id, String descr, String value) {
		super();
		this.id = id;
		this.descr = descr;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
