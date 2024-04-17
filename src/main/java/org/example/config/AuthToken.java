package org.example.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthToken {
    private static final long serialVersionUID = 1L;
    private String token;
    private String email;
    private long expired;
    private Long userId;
    private String fullName;
    private int userType;
    private Long roleId;
    private String roleName;
    private boolean systemAdmin;


    public AuthToken(){

    }

    public AuthToken(String token, String email, long expired, Long userId) {
        super();
        this.token = token;
        this.email = email;
        this.expired = expired;
        this.userId = userId;
    }
}
