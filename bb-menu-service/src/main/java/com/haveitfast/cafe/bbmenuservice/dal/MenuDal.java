/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbmenuservice.dal;


import java.util.List;

import com.haveitfast.cafe.bbmenuservice.entity.MenuEntity;

public interface MenuDal {

    public MenuEntity save(MenuEntity menu);

    public List<MenuEntity> findAllMenu();

    public MenuEntity findByMenuId(String menuId);

    public void deleteMenu(String menuId);

    public MenuEntity update(String menuId, MenuEntity menu);

}
