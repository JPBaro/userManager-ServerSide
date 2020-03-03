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

import com.jpbtech.webappservice.exceptions.ExceptionInDataBase;
import com.jpbtech.webappservice.model.UsuarioInfo;
import com.jpbtech.webappservice.model.messagehandler.NewUserPostWrapper;
import com.jpbtech.webappservice.service.UserServiceImpl;

@RestController
@RequestMapping("/manager-tool")
@Secured(value = {"ROLE_USER"})
public class UsuariosServiceController {

	@Autowired
	UserServiceImpl userService;

	@GetMapping("/users")
	public List<UsuarioInfo> listAllUsers() {

		List<UsuarioInfo> usersList = userService.getAllUsersInDB();
		return usersList;
	}	
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody NewUserPostWrapper userPosted) throws ExceptionInDataBase {

		userService.insertNewUser(userPosted);
		return new ResponseEntity<Object>("Usuarion "+userPosted.getUserInfo().getUsername()+" guardado.", HttpStatus.OK);
	}
	
	@GetMapping("/users/{username}")
	public Optional<UsuarioInfo> listUsersByUsername(
							@PathVariable("username") String username) throws ExceptionInDataBase {
		
		Optional<UsuarioInfo> userinfo = userService.getUsersByUsername(username);
		return userinfo;
	}

	@DeleteMapping("/users/{username}")
	public ResponseEntity<Object> removeUserByUsername(@PathVariable("username") String userName) throws ExceptionInDataBase {

		userService.deleteUser(userName);
		return new ResponseEntity<Object>("Usuario eliminado: "+userName , HttpStatus.OK);
	}

	@PutMapping("/users/{username}")
	public ResponseEntity<String> UpdateUserFieldsBy(@PathVariable String username, @RequestBody UsuarioInfo userUpdate)
							throws ExceptionInDataBase {

		if (!userUpdate.getUsername().contentEquals(username)) // check {username} vs "username" json
			throw new ExceptionInDataBase("Missmatch - Conflicto solicitud" + username);

		userService.updateUserBy(userUpdate);
		return new ResponseEntity<String>("Usuario actualizado: "+username , HttpStatus.OK);
	}

	
	@RequestMapping(value = "/logmeout", method = RequestMethod.POST)  // Pendiente de implementar -test prov
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null)
			new SecurityContextLogoutHandler().logout(request, response, auth);
		
		return "redirect:/login";
	}

}