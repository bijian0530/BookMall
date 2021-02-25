package com.test;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUsername() {
        if(userDao.queryUsername("admin") ==null){
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名已经存在了!");
        }
    }

    @Test
    public void queryByUsernameAndPassword() {
        if(userDao.queryByUsernameAndPassword("admin","admin") == null){
            System.out.println("用户名或密码错误，登陆失败!");
        }else {
            System.out.println("查询成功!");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"admin2","admin2","bijian@qq.com")));
    }
}