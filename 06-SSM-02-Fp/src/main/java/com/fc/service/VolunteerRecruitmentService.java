package com.fc.service;

import com.fc.entity.VolunteerRecruitment;
import com.fc.vo.ResultVO;

import java.util.Date;

public interface VolunteerRecruitmentService {
    //志愿者招聘点击
    ResultVO click(Long id, Date lastClickTime);

    //志愿者招聘数据获取
    ResultVO getList(Integer pageNum, Integer pageSize, Long id);

    //志愿者招聘数据添加
    ResultVO add(VolunteerRecruitment volunteer);

    //志愿者招聘数据修改
    ResultVO update(VolunteerRecruitment volunteer);

    //志愿者招聘数据删除
    ResultVO delete(Long id);
}
