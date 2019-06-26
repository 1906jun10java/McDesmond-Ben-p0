package com.revature.beans;

public abstract class UserBean {
	
	public UserBean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	private String userName;		//customer username
	private String password;		//customer password
	
	//getters and setters
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
