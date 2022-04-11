package com.fc.controller;

import com.fc.entity.VolunteerRecruitment;
import com.fc.service.VolunteerRecruitmentService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("volunteer")
public class VolunteerRecruitmentController {
    @Autowired
    private VolunteerRecruitmentService volunteerRecruitmentService;

    //
    @PostMapping("click")
    public ResultVO click(VolunteerRecruitment volunteer) {
        return volunteerRecruitmentService.click(volunteer.getId(), volunteer.getLastClickTime());
    }

    //志愿者招聘数据获取
    @GetMapping("getlist")
    public ResultVO getlist(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "3")  Integer pageSize,
                            Long id) {
        return volunteerRecruitmentService.getList(pageNum, pageSize, id);
    }

    //志愿者招聘数据添加
    @PostMapping("add")
    public ResultVO add(@RequestBody VolunteerRecruitment volunteer) {
        return volunteerRecruitmentService.add(volunteer);
    }

    //志愿者招聘数据修改
    @PostMapping("update")
    public ResultVO update(@RequestBody VolunteerRecruitment volunteer){
        return volunteerRecruitmentService.update(volunteer);
    }

    //志愿者招聘数据删除
    @GetMapping("delete")
    public ResultVO delete(@RequestParam Long id) {
        return volunteerRecruitmentService.delete(id);
    }
}
