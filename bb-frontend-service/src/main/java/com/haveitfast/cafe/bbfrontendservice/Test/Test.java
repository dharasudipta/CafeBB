package com.haveitfast.cafe.bbfrontendservice.Test;

public class Test {
	
	private long userId;
	private String userName;
	private String userRole;
	
	Test(long userId, String userName, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userRole = userRole;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	

}
