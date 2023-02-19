/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbmenuservice.application.ports.in;

import com.haveitfast.cafe.bbmenuservice.application.domain.Menu;
import java.util.List;

public interface MenuService {
	
	public List<Menu> findAllMenu();
	
	public Menu findMenuById(Long menuId );
	
	//public static long findIdCounter();
	
	public Menu updateMenu(Long menuId , Menu menu);
	
	public Menu createMenu(Menu menu);
	
	public Menu deleteById(Long menuId);
	
	public boolean findMenuStatus(Long menuId );
	

}
