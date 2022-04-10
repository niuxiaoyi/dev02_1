package com.fc.test;

import com.fc.dao.AccountDao;
import com.fc.entity.Account;
import com.fc.entity.TAccount;
import com.fc.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class ORMTest {
//    驼峰映射
    @Test
    public void testCamelCase() {
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);

        List<TAccount> accounts = accountDao.findAllByCamelCase();

        for (TAccount account : accounts) {
            System.out.println(account);
        }

        MyBatisUtil.commit();
    }

//使用结果映射（resultMap）
    @Test
    public  void testMap(){
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);

        Account account = accountDao.findById(1);

        System.out.println(account);

        MyBatisUtil.commit();
    }

//    起别名
    @Test
    public void testAlias(){
        AccountDao accountDao = MyBatisUtil.getMapper(AccountDao.class);

        List<Account> accounts = accountDao.findAll();

        for (Account account:accounts) {
            System.out.println(account);
        }
        MyBatisUtil.commit();
    }
}
