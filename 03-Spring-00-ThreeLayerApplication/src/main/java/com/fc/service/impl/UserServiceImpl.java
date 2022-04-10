package com.fc.service.impl;

import com.fc.dao.UserDao;
import com.fc.dao.impl.UserDaoImpl;
import com.fc.dao.impl.UserDaoMYSQLImpl;
import com.fc.dao.impl.UserDaoOracleImpl;
import com.fc.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao ;

    @Override
    public void useDateBase() {
        userDao.useDateBase();
    }

    @Override
    public void setUserDao(UserDao userDao) {
        this.userDao=userDao;
    }
}
