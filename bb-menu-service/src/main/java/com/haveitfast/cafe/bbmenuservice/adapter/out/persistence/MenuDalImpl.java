/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbmenuservice.adapter.out.persistence;

import com.haveitfast.cafe.bbmenuservice.application.ports.out.MenuDal;
import com.haveitfast.cafe.bbmenuservice.adapter.out.persistence.repository.MenuRepository;
import com.haveitfast.cafe.bbmenuservice.adapter.out.persistence.entity.MenuEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuDalImpl implements MenuDal {
    private MenuRepository menuRepository;

    @Autowired
    public MenuDalImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public MenuEntity save(MenuEntity menu) {
        return menuRepository.save(menu);
    }

    @Override
    public List<MenuEntity> findAllMenu() {
        return menuRepository.findAll();
    }

    @Override
    public MenuEntity findByMenuId(Long menuId) {
        return menuRepository.findById(menuId).get();
    }

    @Override
    public void deleteMenu(Long menuId) {
        menuRepository.deleteById(menuId);
    }

    @Override
    public MenuEntity update(Long menuId, MenuEntity menu) {
        return menuRepository.saveAndFlush(menu); //ToDo Find and update
    }
}
