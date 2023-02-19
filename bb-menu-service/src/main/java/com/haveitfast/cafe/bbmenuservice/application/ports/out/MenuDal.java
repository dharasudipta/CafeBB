/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbmenuservice.application.ports.out;


import java.util.List;

import com.haveitfast.cafe.bbmenuservice.adapter.out.persistence.entity.MenuEntity;

public interface MenuDal {

    public MenuEntity save(MenuEntity menu);

    public List<MenuEntity> findAllMenu();

    public MenuEntity findByMenuId(Long menuId);

    public void deleteMenu(Long menuId);

    public MenuEntity update(Long menuId, MenuEntity menu);

}
