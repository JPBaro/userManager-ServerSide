package com.jpbtech.webappservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpbtech.webappservice.model.UsuarioInfo;

/**
 * Interface extends {@link JpaRepository},  to be able of interacting/operate  {@link UsuarioInfo}
 * @author jpb
 *
 */
@Repository
public interface UsuarioInfoRepository extends JpaRepository<UsuarioInfo, String>{
	

	
	
	
    
    
    
	

}
