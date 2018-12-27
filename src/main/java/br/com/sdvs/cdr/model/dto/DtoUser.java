package br.com.sdvs.cdr.model.dto;

import org.springframework.security.core.authority.AuthorityUtils;

import br.com.sdvs.cdr.model.Role;
import br.com.sdvs.cdr.model.User;

public class DtoUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;
	private User user;

    public DtoUser(User user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

	public User getUser() {
        return user;
    }

    public Long getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }

    @Override
    public String toString() {
        return "CurrentUser{" + "user=" + user + "} " + super.toString();
    }
}
