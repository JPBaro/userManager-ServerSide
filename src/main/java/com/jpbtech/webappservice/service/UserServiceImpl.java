package com.jpbtech.webappservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.jpbtech.webappservice.exceptions.ExceptionInDataBase;
import com.jpbtech.webappservice.model.PassKeyUsers;

import com.jpbtech.webappservice.model.UsuarioInfo;

import com.jpbtech.webappservice.repository.PassKeysUsersRepository;
import com.jpbtech.webappservice.repository.UsuarioInfoRepository;
import com.jpbtech.webappservice.resources.exceptions.ExceptionInDataBase;
import com.jpbtech.webappservice.resources.exceptions.ExceptionUserConflict;

@Service
public class UserServiceImpl {

	@Autowired // com.jpb.displaycontrol.repositiry.ItemRepository
	UsuarioInfoRepository userRepo;

	@Autowired
	PassKeysUsersRepository nameNpassRepo;

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
