package com.fc.service;

import com.fc.entity.Alleviation;
import com.fc.vo.ResultVO;

import java.util.Date;

public interface AlleviationService {
    //扶贫政策项目获取
    ResultVO getList(Integer pageNum, Integer pageSize, Long id);

    //扶贫政策项目添加
    ResultVO add(Alleviation alleviation);

    //扶贫政策项目修改
    ResultVO update(Alleviation alleviation);

    //扶贫政策项目删除
    ResultVO delete(Long id);

    //扶贫政策点击
    ResultVO click(Long id, Date lastClickTime);
}
