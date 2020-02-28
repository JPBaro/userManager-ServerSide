package com.jpbtech.webappservice.controller;

import org.springframework.web.bind.annotation.GetMapping;

//import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class UserMngController {
	
	@GetMapping
	public void getItemInStock() {
				//Fancy printing for checking Workflow at Console. to be removed JP
		System.out.println("######################################");
		System.out.println("  @GetMapping  getItemInStock !");
	}

}



