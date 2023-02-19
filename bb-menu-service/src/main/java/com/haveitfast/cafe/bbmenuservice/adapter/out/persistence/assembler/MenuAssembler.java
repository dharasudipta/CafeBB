/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbmenuservice.adapter.out.persistence.assembler;

import com.haveitfast.cafe.bbmenuservice.application.domain.Menu;
import com.haveitfast.cafe.bbmenuservice.adapter.out.persistence.entity.MenuEntity;

public interface MenuAssembler {
	 public MenuEntity toMenuEntity(Menu menu);

	    public Menu toMenu(MenuEntity menuEntity);

}




