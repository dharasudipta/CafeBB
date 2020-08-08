/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbmenuservice.service;

import com.haveitfast.cafe.bbmenuservice.bean.menu.Menu;
import java.util.List;

public interface MenuService {
	
	public List<Menu> findAllMenu();
	
	public Menu findMenuById(String menuId );
	
	//public static long findIdCounter();
	
	public Menu updateMenu(String menuId , Menu menu);
	
	public Menu createMenu(Menu menu);
	
	public Menu deleteById(String menuId);
	
	public boolean findMenuStatus(String menuId );
	

}
