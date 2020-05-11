package com.haveitfast.cafe.bbmenuservice.menuController;

public class menuBean {

	private String message;

	@Override
	public String toString() {
		return "menuBean [message=" + message + "]";
	}
	public menuBean(String message) {
		this.message=message;
	} 
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	

	

	
	

}
