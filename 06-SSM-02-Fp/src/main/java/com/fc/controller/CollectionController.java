package com.fc.controller;

import com.fc.entity.Carousel;
import com.fc.entity.Collection;
import com.fc.service.CarouselService;
import com.fc.service.CollectionService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;

    //收藏表获取
    @GetMapping("getlist")//驼峰命名getList  默认第一页为起始页  默认每页三条
    public ResultVO getlist(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize,
                            Long id) {
        return collectionService.getlist(pageNum, pageSize, id);
    }

    //收藏添加
    @PostMapping("add")
    public ResultVO add(@RequestBody Collection collection) {
        return collectionService.add(collection);
    }

    //收藏修改
    @PostMapping("update")
    public ResultVO update(@RequestBody Collection collection) {
        return collectionService.update(collection);
    }

    //收藏删除
    @GetMapping("delete")
    public ResultVO delete(@RequestParam Long id) {
        return collectionService.delete(id);
    }
}
