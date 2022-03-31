package com.feng.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String nickName;
    private String address;
    public User(String username,String password,String nickName,String address){
        this.password = password;
        this.username = username;
        this.nickName = nickName;
        this.address = address;
    }
    public User(String username,String password){
        this.username = username;
        this.password = password;
    }
}
