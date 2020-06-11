package com.hhy.web.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(length = 20)
    private String userName;

    @Column(length = 50)
    private String userId;

    @Column(length = 20)
    private String password;


    public User(){}


    @Builder
    public User(String userName,String userId,String password){
        this.userName = userName;
        this.userId = userId;
        this.password = password;

    }
}
