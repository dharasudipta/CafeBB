/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbuserservice.application.domain;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User implements Serializable {
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String fullName;
    @Getter
    @Setter
    private String contactNumber;
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String role;
    @Getter
    @Setter
    private String storeId; //OneTo-May //for stationery store, for online it is only one static id
    @Getter
    @Setter
    private String employeeId; //One-To_one
//	private String assetId;//ToDo

    public Boolean isRoleEntitled() {
        //ToDo
        return Boolean.TRUE;
    }

    public Boolean isAuthorized() {
        //ToDo
        return Boolean.TRUE;
    }

    public Boolean isSessionAlive() {
        //ToDo
        return Boolean.TRUE;
    }

    public Boolean isActive() {
        //ToDo
        return Boolean.TRUE;
    }

    public Boolean isNewsLetterSubscriber() {
        //ToDo
        return Boolean.TRUE;
    }

    public Boolean isTCAccepted() {
        //ToDo
        return Boolean.TRUE;
    }
}
