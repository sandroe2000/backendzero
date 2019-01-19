package br.com.sdvs.cdr.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sdvs.cdr.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	//Usado em CurrentUserDetailsService
	public Optional<User> findOneByUsernameAndDisabledIsNull(String username);
	
	//Usado em UserRestController
	public User findOneByUsername(String username);
    
	//Usado em UserRestController
    @Query("select u from User u where u.username like ?1")
    public Page<User> findPageable(String username, Pageable page);
}
