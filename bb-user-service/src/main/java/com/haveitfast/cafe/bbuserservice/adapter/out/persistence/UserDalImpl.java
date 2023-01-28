/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbuserservice.adapter.out.persistence;

import com.haveitfast.cafe.bbuserservice.application.ports.out.UserDal;
import com.haveitfast.cafe.bbuserservice.adapter.out.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDalImpl implements UserDal {

    private MongoTemplate mongoTemplate;

    @Autowired
    public UserDalImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    //    ToDo Custom DalException
    @Override
    public String isUserFound(String username, String password) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userName").is(username).andOperator(Criteria.where("password").is(password)));
        UserEntity user = mongoTemplate.findOne(query, UserEntity.class);
        if (user == null) {
            return null;
        }
        return user.getUserId();
    }

    @Override
    public UserEntity save(UserEntity user) {
        return mongoTemplate.save(user);
    }

    @Override
    public List<UserEntity> findAll() {
        return mongoTemplate.findAll(UserEntity.class);
    }

    @Override
    public UserEntity findByUserId(String userId) {
        return mongoTemplate.findById(userId, UserEntity.class);
    }
    


    @Override
    public void deleteUser(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        mongoTemplate.findAndRemove(query, UserEntity.class);
    }

    @Override
    public UserEntity update(String userId, UserEntity user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
//                .andOperator(Criteria.where("userName")
//                .is(user.getUserName())));//As per current understanding username cannot be modified.If neede then we can uncomment
        Update update = new Update();
        update.set("password", user.getPassword());
        update.set("fullName", user.getFullName());
        update.set("contactNumber", user.getContactNumber());
        update.set("role", user.getRole());
        update.set("storeId", user.getStoreId());
        update.set("employeeId", user.getEmployeeId());
        return mongoTemplate.findAndModify(query, update, new FindAndModifyOptions().returnNew(true), UserEntity.class);
    }
}
