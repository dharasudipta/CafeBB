/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbmenuservice.assembler;

import com.haveitfast.cafe.bbmenuservice.bean.menu.Menu;
import com.haveitfast.cafe.bbmenuservice.entity.MenuEntity;

public interface MenuAssembler {
	 public MenuEntity toMenuEntity(Menu menu);

	    public Menu toMenu(MenuEntity menuEntity);

}




