package com.fc.service.impl;

import com.fc.dao.AccountDao;
import com.fc.dao.StudentDao;
import com.fc.entity.Student;
import com.fc.service.AccountService;
import com.fc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.REPEATABLE_READ,
            readOnly = false)
    public void transferMoney(Integer from, Integer to, Integer t_pwd) {
        accountDao.decrease(from, t_pwd);



        accountDao.increase(to, t_pwd);
    }
}

