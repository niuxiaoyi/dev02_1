package com.fc.test;

import com.fc.dao.impl.UserDaoImpl;
import com.fc.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserTest {
    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();

        userService.setUserDao(new UserDaoImpl());

        userService.useDateBase();
    }
}
