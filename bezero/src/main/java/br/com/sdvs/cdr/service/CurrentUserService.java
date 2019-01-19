package br.com.sdvs.cdr.service;

import org.springframework.stereotype.Service;

import br.com.sdvs.cdr.model.dto.DtoUser;

@Service
public interface CurrentUserService {

    boolean canAccessUser(DtoUser currentUser, Long userId);

}
