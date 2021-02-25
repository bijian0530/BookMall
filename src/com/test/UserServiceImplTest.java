package com.test;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"bj123","bj123","bj123@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"111","111","111@qq.com")));
    }

    @Test
    public void existUsername() {
        if(userService.existUsername("111")){
            System.out.println("用户名已经存在了");
        }else {
            System.out.println("用户名可以使用!");
        }
    }
}