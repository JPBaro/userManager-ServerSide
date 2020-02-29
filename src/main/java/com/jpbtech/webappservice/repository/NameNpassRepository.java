package com.jpbtech.webappservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpbtech.webappservice.model.NameAndPassw;

public interface NameNpassRepository extends JpaRepository<NameAndPassw, String>{
	

}
