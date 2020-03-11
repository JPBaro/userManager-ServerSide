package com.jpbtech.webappservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jpbtech.webappservice.exceptions.ExceptionInDataBase;
import com.jpbtech.webappservice.model.UsuarioInfo;
import com.jpbtech.webappservice.model.messagehandler.NewUserPostWrapper;
import com.jpbtech.webappservice.security.clients.ApiClient;
import com.jpbtech.webappservice.service.UserServiceImpl;

@CrossOrigin(origins = "192.168.1.148:4200") 
@RestController
@RequestMapping("/manager-tool")
public class UsuariosServiceController {

	@Autowired
	UserServiceImpl userService;
	
	
	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		return "{greeting: 'ERES UN CRAK Y LO SABES'}";
	}
	
	////////     TEST FOR ANGULAR LOGIN AUTHENTIC - REVISAR
	@GetMapping(produces = "application/json")
	@RequestMapping({"/validateLogin"})
	public ApiClient validateLogin() {
		return new ApiClient ("Api client succesfully authenticated");
	}

	//  VALIDO!!!!  11.03.3030 - incluyo MediaType
	@GetMapping( path = "/users", produces = { MediaType.APPLICATION_JSON_VALUE,  MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<UsuarioInfo> listAllUsers() {
		
		List<UsuarioInfo> usersList = userService.getAllUsersInDB();
		return usersList;
	}	
	
//  VALIDO!!!!  11.03.3030
	@PostMapping(path="/users",produces = { MediaType.APPLICATION_JSON_VALUE,  MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<Object> createUser(@RequestBody NewUserPostWrapper userPosted) throws ExceptionInDataBase {
		
		userService.insertNewUser(userPosted);
		return new ResponseEntity<Object>("Usuarion "+userPosted.getUserInfo().getUsername()+" guardado.", HttpStatus.OK);
	}
	
//--- PROVISIONAL !! 11.03.2020	
	@PostMapping(path="/usersnpsw",produces = { MediaType.APPLICATION_JSON_VALUE,  MediaType.APPLICATION_XML_VALUE })  // provisional para recibir post desde app2 angular
	@ResponseBody
	public ResponseEntity<Object> createUserNopsw(@RequestBody UsuarioInfo usuario) throws ExceptionInDataBase {

		userService.insertNewUserNopsw(usuario);
		return new ResponseEntity<Object>("Usuario guardado.", HttpStatus.OK);
	}
	//----------	
		
//  VALIDO!!!!  11.03.3030
	@GetMapping(path="/users/{username}", produces = { MediaType.APPLICATION_JSON_VALUE,  MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Optional<UsuarioInfo> listUsersByUsername(
							@PathVariable("username") String username) throws ExceptionInDataBase {
				
		Optional<UsuarioInfo> userinfo = userService.getUsersByUsername(username);
		return userinfo;
	}
	
//  VALIDO!!!!  11.03.3030
	@DeleteMapping(path="/users/{username}", produces = { MediaType.APPLICATION_JSON_VALUE,  MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<Object> removeUserByUsername(@PathVariable("username") String userName) throws ExceptionInDataBase {

		userService.deleteUser(userName);
		return new ResponseEntity<Object>("Usuario eliminado: "+userName , HttpStatus.OK);
	}
	
//  VALIDO!!!!  11.03.3030
	@PutMapping(path="/users/{username}", produces = { MediaType.APPLICATION_JSON_VALUE,  MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<String> UpdateUserFieldsBy(@PathVariable String username, @RequestBody UsuarioInfo userUpdate)
							throws ExceptionInDataBase {

		if (!userUpdate.getUsername().contentEquals(username)) // check {username} vs "username" json
			throw new ExceptionInDataBase("Missmatch - Conflicto solicitud" + username);

		userService.updateUserBy(userUpdate);
		return new ResponseEntity<String>("Usuario actualizado: "+username , HttpStatus.OK);
	}

	
//  REVISAR!!!!  11.03.3030
	  @RequestMapping(value = "/logmeout", method = RequestMethod.POST) // PROVISIONAL
	  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (auth != null) new SecurityContextLogoutHandler().logout(request,
	  response, auth);
	  
	  return "redirect:/login"; }
	 

}
