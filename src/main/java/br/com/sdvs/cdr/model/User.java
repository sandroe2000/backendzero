package br.com.sdvs.cdr.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "USER")
public class User implements Serializable {
	
	/*
	mysql> desc user;
	+----------+--------------+------+-----+---------+----------------+
	| Field    | Type         | Null | Key | Default | Extra          |
	+----------+--------------+------+-----+---------+----------------+
	| user_id  | bigint(20)   | NO   | PRI | NULL    | auto_increment |
	| disabled | datetime     | YES  |     | NULL    |                |
	| password | varchar(255) | NO   |     | NULL    |                |
	| username | varchar(255) | NO   | UNI | NULL    |                |
	| role     | varchar(255) | NO   | UNI | NULL    |                |
	+----------+--------------+------+-----+---------+----------------+
	*/

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	private String password;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date disabled;
	
	@Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name = "fk_user")
    private Set<Access> access = new HashSet<Access>();
	
	public User() {
		super();
	}

	public User(Long id, String username, String password, Date disabled, Role role, Set<Access> access) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.disabled = disabled;
		this.role = role;
		this.access = access;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDisabled() {
		return disabled;
	}

	public void setDisabled(Date disabled) {
		this.disabled = disabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Access> getAccess() {
		return access;
	}

	public void setAccess(Set<Access> access) {
		this.access = access;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", disabled=" + disabled
				+ ", role=" + role + ", access=" + access + "]";
	}
}