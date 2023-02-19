/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbmenuservice.application.service;

import com.haveitfast.cafe.bbmenuservice.application.ports.in.MenuService;
import com.haveitfast.cafe.bbmenuservice.application.domain.Menu;
import com.haveitfast.cafe.bbmenuservice.adapter.out.persistence.assembler.MenuAssembler;
import com.haveitfast.cafe.bbmenuservice.application.ports.out.MenuDal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
	private MenuAssembler assembler;
    private MenuDal menuDal;

    @Autowired
    public MenuServiceImpl(MenuAssembler assembler, MenuDal menuDal) {
        this.assembler = assembler;
        this.menuDal = menuDal;
    }

    /**
     * @param
     * @return
     */
	
	
	public List<Menu> findAllMenu(){
		List<Menu> menus = new ArrayList<>();
        menuDal.findAllMenu().forEach(e -> menus.add(assembler.toMenu(e)));
        return menus;
	}
	
	public Menu findMenuById(Long menuId) {
		return assembler.toMenu(menuDal.findByMenuId(menuId));
	}
	
//	public static long findIdCounter() {
//		// TODO Auto-generated method stub
//		return idCounter;
//	}
	
	public Menu updateMenu(Long menuId , Menu menu) {
		if (menuId != null && !"".equals(menuId) && menu != null) {
            return assembler.toMenu(menuDal.update(menuId, assembler.toMenuEntity(menu)));
        } else if (menuId == null && menu != null) {
            return assembler.toMenu(menuDal.update(menu.getMenuId(), assembler.toMenuEntity(menu)));
        } else if (menu == null && menuId != null) {
            return assembler.toMenu(menuDal.update(menuId, menuDal.findByMenuId(menuId)));
        } else {
            //throw new Exception();//ToDo Custom Business Exception
            return new Menu();
        }
	}
	
	public Menu createMenu(Menu newUser) {
		return assembler.toMenu(menuDal.save(assembler.toMenuEntity(newUser)));
	}
	
	public Menu deleteById(Long menuId) {
		Menu deletedMenu = findMenuById(menuId);
        menuDal.deleteMenu(menuId);
        return deletedMenu;
		
	}
	public boolean findMenuStatus(Long menuId) {
		Menu x = findMenuById(menuId);
		return x.isStatus();
		
	}
	

}
