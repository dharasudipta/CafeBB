/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbmenuservice.bean.menu;

import java.io.Serializable;
import java.util.Objects;

public class Menu implements Serializable {
	private String menuId;
    private String menuName;
    private String menuPrice;
    private boolean status;
    private String picturePath;
    private String description ;
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(String menuPrice) {
		this.menuPrice = menuPrice;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
		result = prime * result + ((menuName == null) ? 0 : menuName.hashCode());
		result = prime * result + ((picturePath == null) ? 0 : picturePath.hashCode());
		result = prime * result + ((menuPrice == null) ? 0 : menuPrice.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		if (menuId != other.menuId)
				return false;
		return true;
	}
	@Override
	public String toString() {
		return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuPrice='" + menuPrice + '\'' +
                ", status='" + status + '\'' +
                ", picturePath='" + picturePath + '\'' +
                ", description='" + description + '\'' +
                '}';
	}
	
	
	
	
	
    
}
