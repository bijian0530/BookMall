package com.dao;

import com.pojo.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return如果返回null，则没有这个用户
     */
    public User queryUsername(String username);

    /**
     * 用户名和密码查询信息
     * @param username
     * @param password
     * @return  如果返回null，说明用户名和密码错误
     */
    public User queryByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user
     * @return  返回-1表示操作失败，其它是影响sql语句行数
     */
    public int saveUser(User user);
}
