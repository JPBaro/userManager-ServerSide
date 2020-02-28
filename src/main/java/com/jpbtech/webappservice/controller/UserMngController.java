package com.jpbtech.webappservice.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.jpbtech.webappservice.model.UserModel;
import com.jpbtech.webappservice.security.service.UserModelServiceImpl;

@Controller
@RequestMapping("/main")
public class UserMngController {

	@Autowired
	UserModelServiceImpl userService;

	@GetMapping("/")
	public String mainPageHome() {

		return ("inthahouse");
	}

	@PostMapping(value = "/insert")
	public ResponseEntity<UserModel> createOrUpdateItem(@Valid @RequestBody UserModel userpost) {
		
		System.out.println("trying to POST");
		UserModel userToInsert = userService.insertNewUser(userpost);
		return new ResponseEntity<UserModel>(userToInsert, new HttpHeaders(),HttpStatus.OK);
	}

}
