package com.jpbtech.webappservice.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jpbtech.webappservice.resources.exceptions.ExceptionInDataBase;
import com.jpbtech.webappservice.resources.exceptions.ExceptionUserConflict;
import com.jpbtech.webappservice.model.PasswordKey;
import com.jpbtech.webappservice.model.UsernameAndPassw;
import com.jpbtech.webappservice.model.UsuarioInfo;
import com.jpbtech.webappservice.resources.mapedmessag.WrapperRequestPost;
import com.jpbtech.webappservice.repository.UsarioInfoRepo;
import com.jpbtech.webappservice.repository.UsernameAndPasswRepo;
import com.jpbtech.webappservice.security.service.UserServiceImpl;

@RestController
public class UserMngController {

	@Autowired
	UserServiceImpl userService;
	@Autowired
	UsarioInfoRepo userRepo;
	@Autowired
	UsernameAndPasswRepo usernameNpassRepo;

	@GetMapping("/main")
	public ResponseEntity<List<UsuarioInfo>> getUsersReq() {

		List<UsuarioInfo> usersList = userService.getUsersInDB();

		return new ResponseEntity<List<UsuarioInfo>>(usersList, HttpStatus.OK);

	}


	@PostMapping("/main")
	public ResponseEntity<Object> createOrUpdateItem(@RequestBody WrapperRequestPost userPosted) throws ExceptionUserConflict  {	
		System.out.println("1");
		UsuarioInfo userInfo = userPosted.getUserInfo();
		PasswordKey password = userPosted.getPassword();
		System.out.println("1");		
		try {
			UsuarioInfo userSaved = userRepo.save(userInfo);
			System.out.println("1");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("1");
		}
		
		try {
			usernameNpassRepo.save(new UsernameAndPassw(userInfo.getUsername(),password.getPassKey()));
			System.out.println("1");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("1");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/main").buildAndExpand(userInfo.getUsername()).toUri();
		System.out.println("1");
		return ResponseEntity.created(location).build();

		
		//return ResponseEntity.created(new URI("/api/contacts/" + newContact.getId())).body(contact);
				
	}

	@PutMapping("/main/email/{value}")
	public ResponseEntity<String> UpdateItem() {
		
		
		
		return new ResponseEntity<String>("validation", HttpStatus.OK);
	}

}
