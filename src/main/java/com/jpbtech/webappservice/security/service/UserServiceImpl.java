package com.jpbtech.webappservice.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.jpbtech.webappservice.exceptions.ExceptionInDataBase;
import com.jpbtech.webappservice.model.UsernameAndPassw;

import com.jpbtech.webappservice.model.UsuarioInfo;

import com.jpbtech.webappservice.repository.UsernameAndPasswRepo;
import com.jpbtech.webappservice.repository.UsarioInfoRepo;
import com.jpbtech.webappservice.resources.exceptions.ExceptionInDataBase;
import com.jpbtech.webappservice.resources.exceptions.ExceptionUserConflict;

@Service
public class UserServiceImpl {

	@Autowired // com.jpb.displaycontrol.repositiry.ItemRepository
	UsarioInfoRepo userRepo;

	@Autowired
	UsernameAndPasswRepo nameNpassRepo;

	public List<UsuarioInfo> getUsersInDB() {

		List<UsuarioInfo> usersList = userRepo.findAll();
		
		if (usersList.size() > 0) {
			return usersList; // if >single item is present JP
		} else {
			return new ArrayList<UsuarioInfo>(); // if empty, creates ArrayList JP
		}
	}

	/*
	 * public String insertNewUser(UsuarioInfo userInfo) {
	 * 
	 * 
	 * return "saved!!!";
	 * 
	 * }
	 */

	public String updateUser(UsuarioInfo entity) {
		
		return null;

	}

}
