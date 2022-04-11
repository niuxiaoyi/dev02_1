package com.fc.controller;

import com.fc.entity.Carousel;
import com.fc.entity.User;
import com.fc.service.CarouselService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    //轮播图获取
    @GetMapping("getlist")//驼峰命名getList  默认第一页为起始页  默认每页三条
    public ResultVO getlist(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize,
                            Integer id) {
        return carouselService.getlist(pageNum, pageSize, id);
    }

    //轮播图添加
    @PostMapping("add")
    public ResultVO add(@RequestBody Carousel carousel) {
        return carouselService.add(carousel);
    }

    //轮播图修改
    @PostMapping("update")
    public ResultVO update(@RequestBody Carousel carousel) {
        return carouselService.update(carousel);
    }

    //轮播图删除
    @GetMapping("delete")
    public ResultVO delete(@RequestParam Integer id) {
        return carouselService.delete(id);
    }

    //轮播图状态
    @PostMapping("state")
    public ResultVO changeStatus(@RequestParam Integer id){
        return carouselService.changeStatus(id);
    }
}
