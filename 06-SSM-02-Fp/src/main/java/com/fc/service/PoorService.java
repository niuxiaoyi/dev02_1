package com.fc.service;

import com.fc.entity.Collection;
import com.fc.entity.PoorWithBLOBs;
import com.fc.vo.ResultVO;

import java.util.Date;

public interface PoorService {

    //贫困户信息获取
    ResultVO getlist(Integer pageNum, Integer pageSize, Long id);

    //贫困户信息添加
    ResultVO add(PoorWithBLOBs poor);

    //贫困户信息修改
    ResultVO update(PoorWithBLOBs poor);

    //贫困户信息删除
    ResultVO delete(Long id);

    //点击量加1
    ResultVO click(Long id, Date lastClickTime);
}
