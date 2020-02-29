package com.jpbtech.webappservice.security.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpbtech.webappservice.model.NameAndPassw;
import com.jpbtech.webappservice.model.NewFullUser;
import com.jpbtech.webappservice.model.UserModel;
import com.jpbtech.webappservice.repository.NameNpassRepository;
import com.jpbtech.webappservice.repository.UserModelRepository;

@Service
public class UserModelServiceImpl {

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

	/**
	 * Check what to return for unique values
	 * @param entity
	 * @return
	 */
	public String insertNewUser(UserModel entity) {
				
		////
		Boolean inDB = userRepo.existsById(entity.getUsername());
		
		
		try {
			UserModel entitySaved = userRepo.save(entity);
			//save nameNpass in diferent table
			nameNpassRepo.save(new NameAndPassw(entity.getUsername(),entity.getPassword()));
			return "Usuario salvado";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Usuario no salvado ERROR!";
		}
		

//		if (inDB) {
//			return "Atencion!  <" + entity.getUsername()+ "> is already in use";
//		} else {
//			
//			UserModel entitySaved = userRepo.save(entity);
//			
//			//save nameNpass in diferent table
//			nameNpassRepo.save(new NameAndPassw(entity.getUsername(),entity.getPassword()));
//			
//			return "Usuario salvado: " + entitySaved.getUsername();

	}
	
	
	
	public String updateUser(UserModel entity) {
		Boolean inDB = userRepo.existsById(entity.getUsername());
		
		if (inDB) {
			
			return "Usuario modificado!  <" + entity.getUsername()+ ">";
			
		}else {
			
		}
		
		return null;
			
	}

}
