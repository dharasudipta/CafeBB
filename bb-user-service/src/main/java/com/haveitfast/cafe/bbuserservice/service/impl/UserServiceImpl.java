/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbuserservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.haveitfast.cafe.bbuserservice.assembler.UserAssembler;
import com.haveitfast.cafe.bbuserservice.bean.user.User;
import com.haveitfast.cafe.bbuserservice.dal.UserDal;
import com.haveitfast.cafe.bbuserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserAssembler assembler;
    private UserDal userDal;

    @Autowired
    public UserServiceImpl(UserAssembler assembler, UserDal userDal) {
        this.assembler = assembler;
        this.userDal = userDal;
    }

    /**
     * @param newUser
     * @return
     */
    public User createUser(User newUser) {
        return assembler.toUser(userDal.save(assembler.toUserEntity(newUser)));
    }

    public List<User> findAllUser() {
        List<User> users = new ArrayList<>();
        userDal.findAll().forEach(e -> users.add(assembler.toUser(e)));
        return users;
    }

    public List<User> findAllUserExceptThis(String userId) {
        return findAllUser().parallelStream().filter(e -> !e.getUserId().equals(userId)).collect(Collectors.toList());
    }


    public User findUserById(String userId) {
        return assembler.toUser(userDal.findByUserId(userId));
    }
    


    public User deleteUser(String userId) {
        User deletedUser = findUserById(userId);
        userDal.deleteUser(userId);
        return deletedUser;
    }

    public String isUserFound(String username, String password) {
        return userDal.isUserFound(username, password);
    }


//    public User findUserByPassword(String username, String password) {
//        for (User i : users) {
//            if (i.getUsername().equals(username) && i.getPassword().equals(password))
//                return i;
//        }
//        return null;
//    }

    public User updateUserDetails(String userId, User user) {
        if (userId != null && !"".equals(userId) && user != null) {
            return assembler.toUser(userDal.update(userId, assembler.toUserEntity(user)));
        } else if (userId == null && user != null) {
            return assembler.toUser(userDal.update(user.getUserId(), assembler.toUserEntity(user)));
        } else if (user == null && userId != null) {
            return assembler.toUser(userDal.update(userId, userDal.findByUserId(userId)));
        } else {
//            throw new Exception();//ToDo Custom Business Exception
            return new User();
        }
    }

}
