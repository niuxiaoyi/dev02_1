package com.fc.service;

import com.fc.entity.User;
import com.fc.vo.ResultVO;

public interface UserService {

    //用户数据获取
    ResultVO getList(Integer pageNum, Integer pageSize, Long id);

    //用户数据添加
    ResultVO add(User user);

    //用户数据修改
    ResultVO update(User user);

    //用户数据删除
    ResultVO delete(Long id);

    //登录
    ResultVO login(String username, String password);
}
