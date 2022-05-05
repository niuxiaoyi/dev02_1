package com.fc.controller;

import com.fc.entity.Student;
import com.fc.service.AccountService;
import com.fc.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("transfer")
    public String transfer(Integer from, Integer to, Integer t_pwd) {
        accountService.transferMoney(from, to, t_pwd);

        return "转账成功了！！";
    }
}
