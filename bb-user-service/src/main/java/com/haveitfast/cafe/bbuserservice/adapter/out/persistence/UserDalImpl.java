/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbuserservice.adapter.out.persistence;

import com.haveitfast.cafe.bbuserservice.adapter.out.persistence.entity.UserEntity;
import com.haveitfast.cafe.bbuserservice.adapter.out.persistence.repository.UserRepository;
import com.haveitfast.cafe.bbuserservice.application.ports.out.UserDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDalImpl implements UserDal {

    private UserRepository userRepository;

    @Autowired
    public UserDalImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //    ToDo Custom DalException
    @Override
    public Long isUserFound(String username, String password) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(username);
        userEntity.setPassword(password);
        Optional<UserEntity> optionalUser = userRepository.findOne(Example.of(userEntity));
        return optionalUser.orElseThrow().getUserId();
    }

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findByUserId(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }


    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserEntity update(Long userId, UserEntity user) {
        if (userRepository.exists(Example.of(user))) {
            return userRepository.saveAndFlush(user);
        }
        return null;//ToDo throw exception
    }
}
