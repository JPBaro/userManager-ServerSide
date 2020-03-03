package com.jpbtech.webappservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpbtech.webappservice.model.PassKeyUsers;

/**
 * Interface extends {@link JpaRepository},  to be able of interacting/operate  {@link PassKeyUsers}
 * @author jpb
 *
 */
public interface PassKeysUsersRepository extends JpaRepository<PassKeyUsers, String>{
	
	

}
