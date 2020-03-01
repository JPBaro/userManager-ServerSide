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
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jpbtech.webappservice.resources.exceptions.ExceptionInDataBase;
import com.jpbtech.webappservice.model.NameAndPassw;
import com.jpbtech.webappservice.model.UserModel;
import com.jpbtech.webappservice.model.WraperFullUserPost;
import com.jpbtech.webappservice.repository.UserModelRepository;
import com.jpbtech.webappservice.security.service.UserServiceImpl;

@RestController
public class UserMngController {

	@Autowired
	UserServiceImpl userService;
	@Autowired
	UserModelRepository userRepo;

	@GetMapping("/main")
	public ResponseEntity<List<UserModel>> getUsersReq() {

		List<UserModel> usersList = userService.getUsersInDB();

		// usersList.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK
		return new ResponseEntity<List<UserModel>>(usersList, HttpStatus.OK);

	}

	/**
	 * 
	 * @param userInfo
	 *            Contains WraperFullUserPost object with: UserModel and
	 *            NameAndPassw objects coming in as JSON. Passes Objaect to {@link UserServiceImpl}
	 * @return ResponseEntity 
	 * 
	 * @throws ExceptionInDataBase
	 * @author jpb
	 */
	@PostMapping("/main")
	public String createOrUpdateItem(@RequestBody WraperFullUserPost userInfo) throws ExceptionInDataBase  {		

		NameAndPassw nameNpasswPost = userInfo.getCredentials();
		UserModel userPost = userInfo.getUser();
		
		String response =userService.insertNewUser(userPost, nameNpasswPost);
		
		return response;
	}

	@PutMapping("/main/email/{value}")
	public ResponseEntity<String> UpdateItem(@RequestBody UserModel userPost) {
		

		return new ResponseEntity<String>("validation", HttpStatus.OK);
	}

}
