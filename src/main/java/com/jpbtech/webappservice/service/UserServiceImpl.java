package com.jpbtech.webappservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.jpbtech.webappservice.exceptions.ExceptionInDataBase;
import com.jpbtech.webappservice.model.PassKeyUsers;

import com.jpbtech.webappservice.model.UsuarioInfo;

import com.jpbtech.webappservice.repository.PassKeysUsersRepository;
import com.jpbtech.webappservice.repository.UsuarioInfoRepository;
import com.jpbtech.webappservice.resources.exceptions.ExceptionInDataBase;
import com.jpbtech.webappservice.resources.exceptions.ExceptionUserConflict;
import com.jpbtech.webappservice.resources.messagehandler.NewUserPostWrapper;

@Service
public class UserServiceImpl {

	@Autowired // com.jpb.displaycontrol.repositiry.ItemRepository
	UsuarioInfoRepository userRepo;

	@Autowired
	PassKeysUsersRepository nameNpassRepo;

	public List<UsuarioInfo> getAllUsersInDB() {

		List<UsuarioInfo> usersList = userRepo.findAll();
		
		if (usersList.size() > 0) {
			return usersList; // if >single item is present JP
		} else {
			return new ArrayList<UsuarioInfo>(); // if empty, creates ArrayList JP
		}
	}

	public UsuarioInfo getUsersByUsername(String username) throws Exception {

		Optional<UsuarioInfo> userInfo = userRepo.findById(username);
		if(!userInfo.isPresent())
			throw new Exception(username);
		return null;
		
		
	}

	public HttpStatus insertNewUser(NewUserPostWrapper entity) {
		
		UsuarioInfo userPosted = entity.getUserInfo();
		
		if (userRepo.existsById(userPosted.getUsername()) || nameNpassRepo.existsById(userPosted.getUsername()) ) {
			
			return HttpStatus.CONFLICT;
						
		}else {
			PassKeyUsers userVkey = new PassKeyUsers();
			userVkey.setUsername(userPosted.getUsername());
			userVkey.setPassword(entity.getPassword());
			nameNpassRepo.save(userVkey);
			return HttpStatus.OK;
				
	}
		}
}