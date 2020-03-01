package com.jpbtech.webappservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpbtech.webappservice.model.UsernameAndPassw;

public interface UsernameAndPasswRepo extends JpaRepository<UsernameAndPassw, String>{
	

}
