/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbuserservice.dal;

import com.haveitfast.cafe.bbuserservice.entity.UserEntity;

import java.util.List;

public interface UserDal {
    public boolean isUserFound(String username, String password);

    public UserEntity save(UserEntity user);

    public List<UserEntity> findAll();

    public UserEntity findByUserId(String userId);

    public void deleteUser(String userId);

    public UserEntity update(String userId, UserEntity user);
}
