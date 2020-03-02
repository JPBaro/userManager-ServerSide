package com.jpbtech.webappservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jpbtech.webappservice.resources.exceptions.ExceptionInDataBase;
import com.jpbtech.webappservice.resources.messagehandler.NewUserPostWrapper;
import com.jpbtech.webappservice.model.UsuarioInfo;
import com.jpbtech.webappservice.service.UserServiceImpl;


@RestController
@RequestMapping("/manager-tool")
@Secured(value = {"ROLE_USER"})
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
		
		if (!userUpdate.getUsername().contentEquals(username))  //check id in uri vs json
			throw new ExceptionInDataBase(new Date(), "Missmatch - Conflicto");
		
		userService.updateUserBy(userUpdate);
		return new ResponseEntity<String>("validation", HttpStatus.OK);
	}			
	
	@RequestMapping(value="/logmeout", method = RequestMethod.POST)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (auth != null){
	new SecurityContextLogoutHandler().logout(request, response, auth);
	}
	return "redirect:/login";
	}
	
}
