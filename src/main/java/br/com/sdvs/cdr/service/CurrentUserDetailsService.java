package br.com.sdvs.cdr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.sdvs.cdr.model.User;
import br.com.sdvs.cdr.model.dto.DtoUser;
import br.com.sdvs.cdr.repository.UserRepository;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CurrentUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public DtoUser loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user = userRepository.findOneByUsernameAndDisabledIsNull(username)
    			.orElseThrow(() -> new UsernameNotFoundException(String.format("User with username=%s was not found", username)));
        return new DtoUser(user);
    }

}
