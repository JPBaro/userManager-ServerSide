package com.jpbtech.webappservice.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.jpbtech.webappservice.exceptions.ExceptionInDataBase;
import com.jpbtech.webappservice.model.NameAndPassw;

import com.jpbtech.webappservice.model.UserModel;
import com.jpbtech.webappservice.model.WraperFullUserPost;
import com.jpbtech.webappservice.repository.NameNpassRepository;
import com.jpbtech.webappservice.repository.UserModelRepository;
import com.jpbtech.webappservice.resources.exceptions.ExceptionInDataBase;
import com.jpbtech.webappservice.resources.exceptions.ExceptionUserConflict;

@Service
public class UserServiceImpl {

	@Autowired // com.jpb.displaycontrol.repositiry.ItemRepository
	UserModelRepository userRepo;

	@Autowired
	NameNpassRepository nameNpassRepo;

	public List<UserModel> getUsersInDB() {

		List<UserModel> usersList = userRepo.findAll();
		
		if (usersList.size() > 0) {
			return usersList; // if >single item is present JP
		} else {
			return new ArrayList<UserModel>(); // if empty, creates ArrayList JP
		}
	}

	public String insertNewUser(UserModel userInfo, NameAndPassw nameAndPassw) {
		
		userRepo.save(userInfo);
		nameNpassRepo.save(nameAndPassw);

		
		return "saved!!!";

	}

	public String updateUser(UserModel entity) {
		
		return null;

	}

}
