package com.jpbtech.webappservice.resources.messagehandler;
import com.jpbtech.webappservice.model.UsuarioInfo;

/**
 * 
 * @implNote class which host: {@link UsuarioInfo} and {@link PasswordKey} to handle POST Body
 * 
 * @author Joaquin Pampin
 */
public class NewUserPostWrapper{
	
	UsuarioInfo userInfo;
	String password;
	
	public NewUserPostWrapper(UsuarioInfo userInfo, String password) {
		this.userInfo = userInfo;
		this.password = password;
	}

	public UsuarioInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UsuarioInfo userInfo) {
		this.userInfo = userInfo;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	
	


}
