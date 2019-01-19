package br.com.sdvs.cdr.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="permission", indexes = {@Index(name="idx_permission", columnList="id, descr")})
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String descr;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date disabled;

    public Permission() {
    }

    public Permission(Long id, String descr, Date disabled) {
        this.id = id;
        this.descr = descr;
        this.disabled = disabled;
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

    public Date getDisabled() {
        return disabled;
    }

    public void setDisabled(Date disabled) {
        this.disabled = disabled;
    }
}
