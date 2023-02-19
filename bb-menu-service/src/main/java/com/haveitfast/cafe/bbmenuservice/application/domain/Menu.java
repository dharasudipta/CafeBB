/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbmenuservice.application.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@EqualsAndHashCode
public class Menu implements Serializable {

    @Getter
    @Setter
    private Long menuId;
    @Getter
    @Setter
    private String menuName;
    @Getter
    @Setter
    private String menuPrice;
    @Getter
    @Setter
    private boolean status;
    @Getter
    @Setter
    private String picturePath;
    @Getter
    @Setter
    private String description;
}
