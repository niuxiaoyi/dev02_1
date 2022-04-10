package com.fc.dao.impl;

import com.fc.dao.UserDao;

public class UserDaoMYSQLImpl implements UserDao {
    @Override
    public void useDateBase() {
        System.out.println("使用MYSQL连接数据库");
    }
}
