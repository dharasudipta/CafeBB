/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbuserservice.adapter.in.web;

import com.haveitfast.cafe.bbuserservice.application.domain.User;
import com.haveitfast.cafe.bbuserservice.application.ports.in.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@CrossOrigin(origins = {"http://localhost:9999", "http://localhost:3000"})
@RequestMapping("/user")
public class UserResources {
    UserService userService;

    @Autowired
    public UserResources(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{username}/users/{id}")
    public List<User> getAllUser(@PathVariable String username, @PathVariable String id) {
        return userService.findAllUserExceptThis(id);
    }

    @GetMapping(path = "/users")
    public List<User> getAllUser() {
        return userService.findAllUser();
    }

    @GetMapping(path = "/getUser/{username}/{id}")
    public User getUserById(@PathVariable String username, @PathVariable Long id) {
        return userService.findUserById(id);
    }


    @DeleteMapping("/deleteUser/{username}/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username, @PathVariable Long id) {
        User userDelete = userService.deleteUser(id);
        if (userDelete != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/authUsers")
    public Long userAuthentication(@RequestBody User user) {
        return userService.isUserFound(user.getUserName(), user.getPassword());
    }

    @PutMapping("/usersUpdate/{username}/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @PathVariable Long id, @RequestBody User user) {
        User userUpdate = userService.updateUserDetails(id, user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        User userCreate = userService.createUser(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(userCreate.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
