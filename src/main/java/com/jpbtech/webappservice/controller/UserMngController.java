package com.jpbtech.webappservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
@RequestMapping("/manager-tool")
public class UserMngController {

	@Autowired
	UserServiceImpl userService;

//#############################################################################################################	
//TEAM// GET USER(S)-------------------------------------------------------------------------------------------

	@GetMapping("/users")
	public ResponseEntity<List<UsuarioInfo>> getUserAll() {

		List<UsuarioInfo> usersList = userService.getAllUsersInDB();
		return new ResponseEntity<List<UsuarioInfo>>(usersList, HttpStatus.OK);
	}
	
//#############################################################################################################
// GET USER BY ID
	
	@GetMapping("/users/{username}")
	public ResponseEntity<Optional<UsuarioInfo>> getUserByUsername(
							@PathVariable("username") String userName
							
							)throws ExceptionInDataBase  {
		
		Optional<UsuarioInfo> userinfo = userService.getUsersByUsername(userName);
		
		return  new ResponseEntity<Optional<UsuarioInfo>>(userinfo,HttpStatus.OK);								
	}
	
// POST NEW USER ----------------------------------------------------------------------------------------
	
	@PostMapping("/users")
	public HttpStatus createUser(@RequestBody NewUserPostWrapper userPosted) throws ExceptionInDataBase{

		return userService.insertNewUser(userPosted);
	}
	
// DELETE USER (by Username)------------------------------------------------------------------------------
	@DeleteMapping("/users/{username}")
	public HttpStatus removeUserByUsername(@PathVariable("username") String userName)throws ExceptionInDataBase {

		userService.deleteUser(userName) ;
		return HttpStatus.OK;
	}	
	
//#############################################################################################################
//-----	//PUT   UPDATE USER -------------------------------------------------------------------------

	@PutMapping("/users/{username}")
	public ResponseEntity<String> UpdateUserBy(@PathVariable String username,@RequestBody UsuarioInfo userUpdate) throws ExceptionInDataBase {
		
		if (username!= userUpdate.getUsername())
			throw new ExceptionInDataBase(new Date(), "Missmatch - Conflicto");
		
		userService.updateUserBy(userUpdate);
		return new ResponseEntity<String>("validation", HttpStatus.OK);
	}
	
		
	
}
