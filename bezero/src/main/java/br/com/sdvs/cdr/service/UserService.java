package br.com.sdvs.cdr.service;

import org.springframework.stereotype.Service;

import br.com.sdvs.cdr.model.User;

@Service
public interface UserService {

	User getUserByUsernameAndDisabledIsNull(String username);

}
