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

	public UserModel insertNewUser(WraperFullUserPost userInfo)
			throws ExceptionInDataBase {

		NameAndPassw nameNpasswPost = userInfo.getCredentials();
		String usernamePost = nameNpasswPost.getUsername();

		UserModel userPost = userInfo.getUser();
		userPost.setUsername(usernamePost);

		if (userRepo.findById(usernamePost).isPresent()
				|| nameNpassRepo.findById(usernamePost).isPresent()) {

			throw new ExceptionInDataBase("Username ya en uso: ",
					userPost.getUsername());
		} else {

			try {
				UserModel entitySaved = userRepo.save(userPost);
				nameNpassRepo.save(nameNpasswPost);
				return entitySaved;

			} catch (ExceptionInDataBase e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return userPost;
			}

		}

	}

	public String updateUser(UserModel entity) {
		Boolean inDB = userRepo.existsById(entity.getUsername());
		if (inDB) {
			return "Usuario modificado!  <" + entity.getUsername() + ">";
		} else {
		}

		return null;

	}

}
