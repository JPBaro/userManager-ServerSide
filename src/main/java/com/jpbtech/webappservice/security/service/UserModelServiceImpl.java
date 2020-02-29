package com.jpbtech.webappservice.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpbtech.webappservice.model.UserModel;
import com.jpbtech.webappservice.repository.UserModelRepository;

@Service
public class UserModelServiceImpl {

	@Autowired // com.jpb.displaycontrol.repositiry.ItemRepository
	UserModelRepository userRepo;

	public List<UserModel> getUsersInDB() {

		List<UserModel> usersList = userRepo.findAll();
		if (usersList.size() > 0) {
			System.out.println("aqui hay algo...  " + usersList.toString());
			return usersList; // if >single item is present JP

		} else {
			System.out.println("esto esta vacio...  " + usersList.toString());
			return new ArrayList<UserModel>(); // if empty, creates ArrayList JP
		}
	}

	public UserModel insertNewUser(UserModel entity) {

		Boolean inDB = userRepo.findById(entity.getUsername()).isPresent();
		if (inDB) {
			System.out.println(
					"Username: " + entity.getUsername() + "is in the DB");

		} else {
			System.out.println("Username: <" + entity.getUsername()
					+ ">  IS NOT!! in the DB");
			entity = userRepo.save(entity);

		}

		return null;

	}

}
