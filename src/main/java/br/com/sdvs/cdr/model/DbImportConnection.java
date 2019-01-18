package br.com.sdvs.cdr.model;

import br.com.sdvs.cdr.model.enumerated.JdbcDriver;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="db_import_connection", indexes = {@Index(name="idx_db_import_connection", columnList="id")})
public class DbImportConnection implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String connection;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private JdbcDriver driver;

    private String host;
    private Integer port;

    @Column(name="db_name")
    private String dbName;

    private String owner;

    @Column(name="user_name")
    private String userName;
    private String password;
    private String url;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date disabled;

    public DbImportConnection() {
    }

    public DbImportConnection(Long id, String connection, JdbcDriver driver, String host, Integer port, String dbName, String owner, String userName, String password, String url, Date disabled) {
        this.id = id;
        this.connection = connection;
        this.driver = driver;
        this.host = host;
        this.port = port;
        this.dbName = dbName;
        this.owner = owner;
        this.userName = userName;
        this.password = password;
        this.url = url;
        this.disabled = disabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public JdbcDriver getDriver() {
        return driver;
    }

    public void setDriver(JdbcDriver driver) {
        this.driver = driver;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDisabled() {
        return disabled;
    }

    public void setDisabled(Date disabled) {
        this.disabled = disabled;
    }
}
