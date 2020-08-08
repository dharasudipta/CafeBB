/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbmenuservice.dal.impl;

import com.haveitfast.cafe.bbmenuservice.dal.MenuDal;
import com.haveitfast.cafe.bbmenuservice.entity.MenuEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDalImpl implements MenuDal {
	@Autowired
    private MongoTemplate mongoTemplate;
	
	@Override
	public MenuEntity save(MenuEntity menu) {
		return mongoTemplate.save(menu);
	}

	@Override
    public List<MenuEntity> findAllMenu(){
		return mongoTemplate.findAll(MenuEntity.class);
	}

	@Override
    public MenuEntity findByMenuId(String menuId) {
		return mongoTemplate.findById(menuId, MenuEntity.class);
	}

	@Override
    public void deleteMenu(String menuId) {
		Query query = new Query();
        query.addCriteria(Criteria.where("menuId").is(menuId));
        mongoTemplate.findAndRemove(query, MenuEntity.class);
	}

//	@Override
//    public MenuEntity update(String menuId, MenuEntity menu) {
//		Query query = new Query();
//        query.addCriteria(Criteria.where("menuId").is(menuId));
////                .andOperator(Criteria.where("userName")
////                .is(user.getUserName())));//As per current understanding username cannot be modified.If needed then we can uncomment
//        Update update = new Update();
//        update.set("menuName", menu.getMenuName());
//        update.set("menuPrice", menu.getMenuPrice());
//        update.set("status", menu.isStatus());
//        update.set("picturePath", menu.getPicturePath());
//        update.set("description", menu.getDescription());
//        return mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), MenuEntity.class);
//	}
	
	@Override
    public MenuEntity update(String menuId, MenuEntity menu) {
		Query query = new Query();
        query.addCriteria(Criteria.where("menuId").is(menuId));
//                .andOperator(Criteria.where("userName")
//                .is(user.getUserName())));//As per current understanding username cannot be modified.If needed then we can uncomment
        Update update = new Update();
        if(menu.getMenuName()!=null)
        	update.set("menuName", menu.getMenuName());
        if(menu.getMenuPrice()!=null)
        	update.set("menuPrice", menu.getMenuPrice());
        //if(menu.isStatus()!=null)
        	update.set("status", menu.isStatus());
        if(menu.getPicturePath()!=null)
        	update.set("picturePath", menu.getPicturePath());
        if(menu.getDescription()!=null)
        	update.set("description", menu.getDescription());
        return mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), MenuEntity.class);
	}
}
