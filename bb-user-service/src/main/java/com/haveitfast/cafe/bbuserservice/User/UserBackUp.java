package com.haveitfast.cafe.bbuserservice.User;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class UserBackUp {
    @Getter
    @Setter
    private long id;
    @Getter
    @Setter
    private String fullName;
    @Getter
    @Setter
    private String mobile;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String role;

    protected UserBackUp() {
    }

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
