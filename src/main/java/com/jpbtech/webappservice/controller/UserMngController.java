package com.jpbtech.webappservice.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jpbtech.webappservice.exceptions.ItemNotFoundException;
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
		return new ResponseEntity<List<UserModel>>(usersList, new HttpHeaders(),
				HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserModel> createOrUpdateItem(
			@RequestBody UserModel userPost) {

		UserModel userIn = userService.insertNewUser(userPost);
		return new ResponseEntity<UserModel>(userIn, HttpStatus.OK);
	}

}
