package br.com.sdvs.cdr.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import br.com.sdvs.cdr.model.enumerated.Principal;
import br.com.sdvs.cdr.model.enumerated.AddressType;

@Entity
@Table(indexes = {@Index(name="IDX_ENDERECO", columnList="id, endereco, bairro, cidade, cep")})
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private Principal isPrincipal;
	@Enumerated(EnumType.STRING)
	private AddressType tipoEndereco;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String pais;
	private String cep;
	
	public Address() {
		super();
	}

	public Address(Long id, Principal isPrincipal, AddressType tipoEndereco, String endereco, String numero,
			String complemento, String bairro, String cidade, String uf, String pais, String cep) {
		super();
		this.id = id;
		this.isPrincipal = isPrincipal;
		this.tipoEndereco = tipoEndereco;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.pais = pais;
		this.cep = cep;
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

	public AddressType getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(AddressType tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", isPrincipal=" + isPrincipal + ", tipoEndereco=" + tipoEndereco + ", endereco="
				+ endereco + ", numero=" + numero + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade="
				+ cidade + ", uf=" + uf + ", pais=" + pais + ", cep=" + cep + "]";
	}
}
