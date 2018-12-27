package br.com.sdvs.cdr.service;

import br.com.sdvs.cdr.model.User;

public interface UserService {

	User getUserByUsernameAndDisabledIsNull(String username);

}
