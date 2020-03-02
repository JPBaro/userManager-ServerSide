package com.jpbtech.webappservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jpbtech.webappservice.model.PassKeyUsers;
import com.jpbtech.webappservice.model.UsuarioInfo;
import com.jpbtech.webappservice.repository.PassKeysUsersRepository;
import com.jpbtech.webappservice.repository.UsuarioInfoRepository;
import com.jpbtech.webappservice.resources.exceptions.ExceptionInDataBase;
import com.jpbtech.webappservice.resources.messagehandler.NewUserPostWrapper;

@Service
public class UserServiceImpl {

	@Autowired
	UsuarioInfoRepository userRepo;

	@Autowired
	PassKeysUsersRepository passNkeyRepo;

	BCryptPasswordEncoder bCryptPass = new BCryptPasswordEncoder();

	public List<UsuarioInfo> getAllUsersInDB() {

		List<UsuarioInfo> usersList = userRepo.findAll();

		if (usersList.size() > 0)
			return usersList; // if >single item is present JP
		else
			return new ArrayList<UsuarioInfo>(); // if empty, creates ArrayList

	}

	public Optional<UsuarioInfo> getUsersByUsername(String username) throws ExceptionInDataBase {
		// ------------
		if (!processValidation(username))
			throw new ExceptionInDataBase(new Date(), username);

		Optional<UsuarioInfo> userTaken = userRepo.findById(username);
		return userTaken;
	}

	public HttpStatus insertNewUser(NewUserPostWrapper entity) throws ExceptionInDataBase {

		UsuarioInfo userPosted = entity.getUserInfo();

		// ------------
		if (processValidation(userPosted.getUsername()))
			throw new ExceptionInDataBase(new Date(), userPosted.getUsername());

		PassKeyUsers userVkey = new PassKeyUsers(userPosted.getUsername(),
								bCryptPass.encode(entity.getPassword())); // enctriptacion
																						// password

		passNkeyRepo.save(userVkey); // save "username and password" in table x
		userRepo.save(userPosted); // save "user information without password"
									// in table y

		return HttpStatus.OK;

	}

	public void deleteUser(String userRemove) throws ExceptionInDataBase {

		if (!processValidation(userRemove))
			throw new ExceptionInDataBase(new Date(), userRemove);

		userRepo.deleteById(userRemove);
		passNkeyRepo.deleteById(userRemove);
	}

	public void updateUserBy(UsuarioInfo userUpdate) throws ExceptionInDataBase {

		if (!processValidation(userUpdate.getUsername()))
			throw new ExceptionInDataBase(new Date(), userUpdate.getUsername());

		Optional<UsuarioInfo> userToUpdate = userRepo.findById(userUpdate.getUsername());

		if (!userToUpdate.isPresent())
			throw new ExceptionInDataBase(new Date(), userUpdate.getUsername());
		
		UsuarioInfo userUpadating = userToUpdate.get();
		userUpadating.setEmail(userUpdate.getEmail());
		userUpadating.setActivo(userUpdate.getActivo());
		userUpadating.setNombre(userUpdate.getNombre());
		userUpadating.setApellidos(userUpdate.getApellidos());
		userRepo.save(userUpadating);
	}

	/**
	 * Ckecks if given username is present in all tables DB linked to the
	 * entities : {@link UsuarioInfo} & {@link PassKeyUsers}
	 * 
	 * @implNote true = ( true || true ) exists in all tables ( true || false )
	 *           (*)Internal conflict in DB when is only present in one table.
	 *           false = ( false || false ) it is not present at all in DB
	 *           tables;
	 * 
	 * @param username
	 * @return boolean
	 */
	public boolean processValidation(String username) {

		boolean check = userRepo.existsById(username) || passNkeyRepo.existsById(username);
		return check;
	}
}