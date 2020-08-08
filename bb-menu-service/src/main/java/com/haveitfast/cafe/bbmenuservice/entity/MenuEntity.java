/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbmenuservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
public class MenuEntity {
	@Id
    private String menuId;
    @NotNull
    private String menuName;
    @NotNull
    private String menuPrice;
    @NotNull
    private boolean status;
    @NotNull
    private String picturePath;
    @NotNull
    private String description;
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


}
