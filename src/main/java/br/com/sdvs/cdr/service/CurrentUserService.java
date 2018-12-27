package br.com.sdvs.cdr.service;

import br.com.sdvs.cdr.model.dto.DtoUser;

public interface CurrentUserService {

    boolean canAccessUser(DtoUser currentUser, Long userId);

}
