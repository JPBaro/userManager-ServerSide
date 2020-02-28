package com.jpbtech.webappservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("/main")
public class UserMngController {
	
	
	@GetMapping("/")
	public String mainPageHome() {
				//Fancy printing for checking Workflow at Console. to be removed JP
		System.out.println("######################################");
		System.out.println("  @GetMapping  getItemInStock !");
		
		return ("inthahouse");		
	}
	
	@PostMapping(value="/insert")
	public void insertUser () {
		
		
	}
	
	

}



