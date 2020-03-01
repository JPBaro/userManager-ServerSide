package com.jpbtech.webappservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.net.URI;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.jpbtech.webappservice.resources.exceptions.ExceptionInDataBase;
import com.jpbtech.webappservice.resources.messagehandler.NewUserPostWrapper;
import com.jpbtech.webappservice.model.PassKeyUsers;
import com.jpbtech.webappservice.model.UsuarioInfo;
import com.jpbtech.webappservice.service.UserServiceImpl;
import com.jpbtech.webappservice.repository.UsuarioInfoRepository;
import com.jpbtech.webappservice.repository.PassKeysUsersRepository;

@RestController
public class UserMngController {

	@Autowired
	UserServiceImpl userService;
	@Autowired
	UsuarioInfoRepository userRepo;
	@Autowired
	PassKeysUsersRepository usernameNpassRepo;
	
	//GET ALL USERS IN DB
	
	@GetMapping("/team")
	public ResponseEntity<List<UsuarioInfo>> getUsersReq() {
		System.out.println("GET!!");
		List<UsuarioInfo> usersList = userService.getUsersInDB();
		return new ResponseEntity<List<UsuarioInfo>>(usersList, HttpStatus.OK);
	}
	
	// GET USER BY ID 
	@GetMapping("/user/{username}")
	public ResponseEntity<List<UsuarioInfo>> getUsersReqByStatus() {
		System.out.println("GET!!");
		List<UsuarioInfo> usersList = userService.getUsersInDB();
		return new ResponseEntity<List<UsuarioInfo>>(usersList, HttpStatus.OK);

	}
	
	
	// POST NEW USER
	
	@PostMapping("/user")
	public ResponseEntity<Object> createOrUpdateItem(@RequestBody NewUserPostWrapper userPosted)
							throws ExceptionInDataBase {
		
		UsuarioInfo userInfo = userPosted.getUserInfo();
		if (userRepo.existsById(userInfo.getEmail()) || usernameNpassRepo.existsById(userInfo.getUsername()) ) {
			//throw new ExceptionInDataBase(new Date(), "Confilcto ", userInfo.getUsername() );
			return new ResponseEntity<Object>("Conflicto de datos!  ", HttpStatus.CONFLICT);
		}else {
			PassKeyUsers userVkey = new PassKeyUsers();
			userVkey.setUsername(userInfo.getUsername());
			userVkey.setPassword(userPosted.getPassword());
			usernameNpassRepo.save(userVkey);
			userRepo.save(userInfo);
			return new ResponseEntity<Object>("Aceptada!  ", HttpStatus.OK);
			}
				
	}
	
	//PUT UPDATE AN EXISTING USER

	@PutMapping("/main/{value}")
	public ResponseEntity<String> UpdateItem() {

		return new ResponseEntity<String>("validation", HttpStatus.OK);
	}

}
