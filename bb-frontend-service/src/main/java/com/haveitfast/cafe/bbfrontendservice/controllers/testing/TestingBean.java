package com.haveitfast.cafe.bbfrontendservice.controllers.testing;

public class TestingBean {
	private String s;

	public TestingBean(String s) {
		super();
		this.s = s;
	}

	@Override
	public String toString() {
		return "TestingBean [s=" + s + "]";
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	
}
