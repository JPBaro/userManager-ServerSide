package com.jpbtech.webappservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


import com.jpbtech.webappservice.ExceptionInDataBase;

import com.jpbtech.webappservice.model.NameAndPassw;
import com.jpbtech.webappservice.model.UserModel;
import com.jpbtech.webappservice.model.WraperFullUserPost;
import com.jpbtech.webappservice.repository.UserModelRepository;
import com.jpbtech.webappservice.security.service.UserServiceImpl;

@RestController
@RequestMapping("/main")
public class UserMngController {

	@Autowired
	UserServiceImpl userService;
	@Autowired 
	UserModelRepository userRepo;

	@GetMapping
	public ResponseEntity<List<UserModel>> getUsersReq() {

		List<UserModel> usersList = userService.getUsersInDB();

		// usersList.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK
		return new ResponseEntity<List<UserModel>>(usersList, HttpStatus.OK);

	}

	/**
	 * 
	 * @param userInfo Contains WraperFullUserPost object with: UserModel and NameAndPassw objects coming in as JSON  
	 * @return ResponseEntity with:  {@link UserModel} object & {@link HttpStatus.OK}
	 * @throws ExceptionInDataBase  with:  <h1>Joaquin Pampin </h1>
	 */
	@PostMapping
	public ResponseEntity<UserModel> createOrUpdateItem (
			@RequestBody WraperFullUserPost userInfo) throws ExceptionInDataBase {
		
		UserModel userPost = userInfo.getUser();
		NameAndPassw nameNpasswPost = userInfo.getCredentials();
		userPost.setUsername(nameNpasswPost.getUsername());
		
		/*
		 * if(!userRepo.existsById(nameNpasswPost.getUsername()) ) { throw new
		 * ExceptionInDataBase("Not saved : username Already in use",
		 * nameNpasswPost.getUsername()) ; }
		 */
		UserModel userSaved =  userService.insertNewUser(userPost, nameNpasswPost) ;
		
		return new ResponseEntity<UserModel>(userSaved,  HttpStatus.ACCEPTED);
	}


	@PutMapping
	public ResponseEntity<String> UpdateItem(@RequestBody UserModel userPost) {
		

		return new ResponseEntity<String>("validation", HttpStatus.OK);
	}

}
