package org.example.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userName;
    private String password;

    @Override
    public String toString(){
        return "LoginUser{"+
                "userName = ' " + userName + '\'' + '}';
    }

}
