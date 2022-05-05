package com.fc.service;

import com.fc.entity.Student;

import java.util.List;

public interface AccountService {
     // 转账
     void transferMoney(Integer from, Integer to, Integer t_pwd);
}
