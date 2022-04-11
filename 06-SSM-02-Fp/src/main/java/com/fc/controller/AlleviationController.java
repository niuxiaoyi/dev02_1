package com.fc.controller;

import com.fc.entity.Alleviation;
import com.fc.service.AlleviationService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alleviation")
public class AlleviationController {
    @Autowired
    private AlleviationService alleviationService;

    //扶贫政策点击
    @PostMapping("click")
    public ResultVO click(Alleviation alleviation){
        return alleviationService.click(alleviation.getId(),alleviation.getLastClickTime());
    }

    //扶贫政策项目获取
    @GetMapping("getlist")
    public ResultVO getlist(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "3")  Integer pageSize,
                            Long id) {
        return alleviationService.getList(pageNum, pageSize, id);
    }

    //扶贫政策项目添加
    @PostMapping("add")
    public ResultVO add(@RequestBody Alleviation alleviation) {
        return alleviationService.add(alleviation);
    }

    //扶贫政策项目修改
    @PostMapping("update")
    public ResultVO update(@RequestBody Alleviation alleviation){
        return alleviationService.update(alleviation);
    }

    //扶贫政策项目删除
    @GetMapping("delete")
    public ResultVO delete(@RequestParam Long id) {
        return alleviationService.delete(id);
    }
}
