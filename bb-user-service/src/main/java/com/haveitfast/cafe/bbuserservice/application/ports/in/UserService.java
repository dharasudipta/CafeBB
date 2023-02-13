/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbuserservice.application.ports.in;

import com.haveitfast.cafe.bbuserservice.application.domain.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);

    public List<User> findAllUser();

    public List<User> findAllUserExceptThis(String userId);

    public User findUserById(Long userId);

    public Long isUserFound(String username, String password);

    public User updateUserDetails(Long id, User user);

    public User deleteUser(Long id);
}
