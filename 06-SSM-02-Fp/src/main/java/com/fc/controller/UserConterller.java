package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserConterller {
    @Autowired
    private UserService userService;

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
