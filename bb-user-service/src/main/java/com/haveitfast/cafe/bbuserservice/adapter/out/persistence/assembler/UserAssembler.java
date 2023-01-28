/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbuserservice.adapter.out.persistence.assembler;

import com.haveitfast.cafe.bbuserservice.application.domain.User;
import com.haveitfast.cafe.bbuserservice.adapter.out.persistence.entity.UserEntity;

public interface UserAssembler {
    public UserEntity toUserEntity(User user);

    public User toUserBean(UserEntity UserEntity);
}
