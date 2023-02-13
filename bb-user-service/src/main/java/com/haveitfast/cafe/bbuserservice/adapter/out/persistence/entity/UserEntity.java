/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbuserservice.adapter.out.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "user_details")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "USER_ID")
    private Long userId;
    @Getter
    @Setter
    @Column(name = "FULL_NAME")
    private String fullName;
    @Getter
    @Setter
    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;
    @Getter
    @Setter
    @NotEmpty
    @Column(name = "USER_NAME")
    private String userName;
    @Getter
    @Setter
    @NotEmpty
    @Column(name = "PASSWORD")
    private String password;
    @Getter
    @Setter
    @Column(name = "ROLE")
    private String role;
    @Getter
    @Setter
    @Column(name = "STORE_ID")
    private String storeId; //OneTo-May
    @Getter
    @Setter
    @Column(name = "EMPLOYEE_ID")
    private String employeeId; //One-To_one
    //userId, fullName, contactNumber, username, password, role, storeId, employeeId

}
