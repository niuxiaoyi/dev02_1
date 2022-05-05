package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

//    @RequestMapping("get")
//    public Map<String, Object> get() {
//        Map<String, Object> map = new HashMap<>();
//
//        map.put("message":"222");
//
//        return map;
//    }
    //登录
    @PostMapping("login")
    public ResultVO login(@RequestParam String username,
                          @RequestParam String password){
        return userService.login(username,password);
    }

    //用户数据获取
    @GetMapping("getlist")//驼峰命名getList  默认第一页为起始页  默认每页三条
    public ResultVO getlist(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "3")  Integer pageSize,
                            Long id) {
        return userService.getList(pageNum, pageSize, id);
    }
    //用户数据添加
    @PostMapping("add")
    public ResultVO add(@RequestBody User user){
        return userService.add(user);
    }

    //用户数据修改
    @PostMapping("update")
    public ResultVO update(@RequestBody User user){
        return userService.update(user);
    }

    //用户数据删除
    @GetMapping("delete")
    public ResultVO delete(@RequestParam Long id){
        return userService.delete(id);
    }
}
