package com.service;

import com.pojo.User;

public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registerUser(User user);

    /**
     * 登陆
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 检查用户是否可用
     * @param username
     * @return
     */
    public boolean existUsername(String username);
}
