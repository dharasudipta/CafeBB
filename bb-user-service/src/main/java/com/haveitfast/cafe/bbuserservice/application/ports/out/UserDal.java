/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbuserservice.application.ports.out;

import com.haveitfast.cafe.bbuserservice.adapter.out.persistence.entity.UserEntity;

import java.util.List;

public interface UserDal {
    public String isUserFound(String username, String password);

    public UserEntity save(UserEntity user);

    public List<UserEntity> findAll();

    public UserEntity findByUserId(String userId);
    
    //public UserEntity findByUserName(String userName);

    public void deleteUser(String userId);

    public UserEntity update(String userId, UserEntity user);
}
