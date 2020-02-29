package com.jpbtech.webappservice.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jpbtech.webappservice.exceptions.ItemNotFoundException;
import com.jpbtech.webappservice.model.NewFullUser;
import com.jpbtech.webappservice.model.UserModel;
import com.jpbtech.webappservice.repository.UserModelRepository;
import com.jpbtech.webappservice.security.service.UserModelServiceImpl;

@RestController
@RequestMapping("/main")
public class UserMngController {

	@Autowired
	UserModelServiceImpl userService;

	@GetMapping
	public ResponseEntity<List<UserModel>> getUsersReq() {

		List<UserModel> usersList = userService.getUsersInDB();
		
		//usersList.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK 
		return new ResponseEntity<List<UserModel>>(usersList,new HttpHeaders(), HttpStatus.OK);
		
	}
		
	@PostMapping
	public ResponseEntity<String> createOrUpdateItem(@RequestBody UserModel userPost) {

		String validation = userService.insertNewUser(userPost);
		
		return new ResponseEntity<String>(validation, HttpStatus.OK);
	}
	
	/*
	 * @PutMapping public ResponseEntity<String> UpdateItem(@RequestBody
	 * UserModel userPost) {
	 * 
	 * String validation = userService.insertNewUser(userPost);
	 * 
	 * return new ResponseEntity<String>(validation, HttpStatus.OK); }
	 */

}
