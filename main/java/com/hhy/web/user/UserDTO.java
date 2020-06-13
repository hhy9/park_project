package com.hhy.web.user;

import lombok.Data;
import org.springframework.stereotype.Component;


public class UserDTO {

    private String userName,userId,password;

    public UserDTO(String userName, String userId, String password) {
        this.userName = userName;
        this.userId = userId;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
