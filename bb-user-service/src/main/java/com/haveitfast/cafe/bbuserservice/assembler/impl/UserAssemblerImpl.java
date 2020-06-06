/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbuserservice.assembler.impl;

import com.haveitfast.cafe.bbuserservice.assembler.UserAssembler;
import com.haveitfast.cafe.bbuserservice.bean.user.User;
import com.haveitfast.cafe.bbuserservice.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserAssemblerImpl implements UserAssembler {
    /**
     * @param user
     * @return
     */
    public UserEntity toUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setContactNumber(user.getContactNumber());
        userEntity.setEmployeeId(user.getEmployeeId());
        userEntity.setFullName(user.getFullName());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(user.getRole());
        userEntity.setStoreId(user.getStoreId());
        userEntity.setUserId(user.getUserId());
        userEntity.setUserName(user.getUserName());
        return userEntity;
    }

    /**
     * @param UserEntity
     * @return
     */
    public User toUser(UserEntity UserEntity) {
        User user = new User();
        user.setContactNumber(UserEntity.getContactNumber());
        user.setEmployeeId(UserEntity.getEmployeeId());
        user.setFullName(UserEntity.getFullName());
        user.setPassword(UserEntity.getPassword());
        user.setRole(UserEntity.getRole());
        user.setStoreId(UserEntity.getStoreId());
        user.setUserId(UserEntity.getUserId());
        user.setUserName(UserEntity.getUserName());
        return user;
    }
}
