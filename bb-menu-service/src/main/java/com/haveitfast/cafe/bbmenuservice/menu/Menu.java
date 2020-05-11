package com.haveitfast.cafe.bbmenuservice.menu;

public class Menu { 
	private long id;
	private String menuName;
	private long menuPrice;
	private boolean enable;
	
	protected Menu() {
		
	}
	public Menu(long id, String menuName, long menuPrice,boolean enable) {
		super();
		this.id = id;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.enable=enable;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public long getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(long menuPrice) {
		this.menuPrice = menuPrice;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}

}
