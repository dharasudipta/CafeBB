/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbmenuservice.assembler.impl;

import org.springframework.stereotype.Component;

import com.haveitfast.cafe.bbmenuservice.assembler.MenuAssembler;
import com.haveitfast.cafe.bbmenuservice.bean.menu.Menu;
import com.haveitfast.cafe.bbmenuservice.entity.MenuEntity;

@Component
public class MenuAssemblerImpl implements MenuAssembler {
    /**
     * @param user
     * @return
     */
    public MenuEntity toMenuEntity(Menu menu) {
    	MenuEntity menuEntity = new MenuEntity();
    	menuEntity.setMenuId(menu.getMenuId());
    	menuEntity.setMenuName(menu.getMenuName());
    	menuEntity.setMenuPrice(menu.getMenuPrice());
    	menuEntity.setStatus(menu.isStatus());
    	menuEntity.setPicturePath(menu.getPicturePath());
    	menuEntity.setDescription(menu.getDescription());
        return menuEntity;
    }

    /**
     * @param UserEntity
     * @return
     */
    public Menu toMenu(MenuEntity menuEntity) {
    	Menu menu = new Menu();
    	menu.setMenuId(menuEntity.getMenuId());
    	menu.setMenuName(menuEntity.getMenuName());
    	menu.setMenuPrice(menuEntity.getMenuPrice());
    	menu.setStatus(menuEntity.isStatus());
    	menu.setPicturePath(menuEntity.getPicturePath());
    	menu.setDescription(menuEntity.getDescription());
        return menu;
    }

}
