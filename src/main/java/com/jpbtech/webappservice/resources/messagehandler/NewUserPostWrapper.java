package com.jpbtech.webappservice.resources.messagehandler;
import com.jpbtech.webappservice.model.UsuarioInfo;

/**
 * 
 * @implNote class which host: {@link UsuarioInfo} and {@link PasswordKey} to handle POST Body
 * 
 * @author Joaquin Pampin
 */
public class NewUserPostWrapper{
	
	UsuarioInfo userinfo;
	String password;
	
	public NewUserPostWrapper(UsuarioInfo userinfo, String password) {
		this.userinfo = userinfo;
		this.password = password;
	}

	public UsuarioInfo getUserInfo() {
		return userinfo;
	}

	public void setUserInfo(UsuarioInfo userInfo) {
		this.userinfo = userInfo;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	
	


}
