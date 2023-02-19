/*
 * Copyright (C) 2020 The HaveItFast Systems Incorporated
 * Unauthorized copying of any of the intellectual property by HaveItFast Systems Incorporated is punishable offence under Indian IT act.
 */

package com.haveitfast.cafe.bbmenuservice.adapter.out.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity(name = "menu_details")
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "MENU_ID")
    private Long menuId;
    @NotNull
    @Getter
    @Setter
    @Column(name = "MENU_NAME")
    private String menuName;
    @NotNull
    @Getter
    @Setter
    @Column(name = "PRICE")
    private String menuPrice;
    @NotNull
    @Getter
    @Setter
    @Column(name = "STATUS")
    private boolean status;
//    @NotNull
    @Getter
    @Setter
    @Column(name = "PICTURE_PATH")
    private String picturePath;
    @NotNull
    @Getter
    @Setter
    @Column(name = "DESCRIPTION")
    private String description;

}
