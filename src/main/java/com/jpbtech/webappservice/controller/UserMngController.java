package com.jpbtech.webappservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.jpbtech.webappservice.resources.exceptions.ExceptionInDataBase;
import com.jpbtech.webappservice.resources.messagehandler.NewUserPostWrapper;

import com.jpbtech.webappservice.model.UsuarioInfo;
import com.jpbtech.webappservice.service.UserServiceImpl;


@RestController
public class UserMngController {

	@Autowired
	UserServiceImpl userService;
	
//-----	// GET USER(S)-------------------------------------------------------------------------------------------

	@GetMapping("/team")
	public ResponseEntity<List<UsuarioInfo>> getUsersReq() {

		List<UsuarioInfo> usersList = userService.getAllUsersInDB();
		return new ResponseEntity<List<UsuarioInfo>>(usersList, HttpStatus.OK);
	}

	// GET USER BY ID
	@GetMapping("/user/{username}")
	public ResponseEntity<UsuarioInfo> getUsersByUsername(@PathVariable("username") String userName)
							throws Exception {
		
		return new ResponseEntity<UsuarioInfo>(new UsuarioInfo(), HttpStatus.OK);

	}
//-----	// POST NEW USER ----------------------------------------------------------------------------------------
	@PostMapping(value = "/user", consumes = "applications/json")
	public HttpStatus createOrUpdateItem(@RequestBody NewUserPostWrapper userPosted)
							throws ExceptionInDataBase {

		return userService.insertNewUser(userPosted);

	}

//-----	//PUT   UPDATE USER ----------------------------------------------------------------------------------------

	@PutMapping("/main/{username}/email")
	public ResponseEntity<String> UpdateUserEmail() {
		return new ResponseEntity<String>("validation", HttpStatus.OK);
	}
	
	@PutMapping("/main/{username}/estado")
	public ResponseEntity<String> UpdateUserStatus() {
		return new ResponseEntity<String>("validation", HttpStatus.OK);
	}
	
	@PutMapping("/main/{username}/username")
	public ResponseEntity<String> UpdateUsername() {
		return new ResponseEntity<String>("validation", HttpStatus.OK);
	}
	
	@PutMapping("/main/{password}/username")
	public ResponseEntity<String> UpdatePassword() {
		return new ResponseEntity<String>("validation", HttpStatus.OK);
	}

	
	
	
}
