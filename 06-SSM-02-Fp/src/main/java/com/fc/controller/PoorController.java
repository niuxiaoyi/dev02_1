package com.fc.controller;

import com.fc.entity.Collection;
import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.MessageBoardService;
import com.fc.service.PoorService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("poor")
public class PoorController {
    @Autowired
    private PoorService poorService;

    @PostMapping("click")
    public ResultVO click(Poor poor) {
        return poorService.click(poor.getId(), poor.getLastClickTime());
    }

    //贫困户信息获取
    @GetMapping("getlist")//驼峰命名getList  默认第一页为起始页  默认每页三条
    public ResultVO getlist(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize,
                            Long id) {
        return poorService.getlist(pageNum, pageSize, id);
    }

    //贫困户信息添加
    @PostMapping("add")
    public ResultVO add(@RequestBody PoorWithBLOBs poor) {
        return poorService.add(poor);
    }

    //贫困户信息修改
    @PostMapping("update")
    public ResultVO update(@RequestBody PoorWithBLOBs poor) {
        return poorService.update(poor);
    }

    //贫困户信息删除
    @GetMapping("delete")
    public ResultVO delete(@RequestParam Long id) {
        return poorService.delete(id);
    }
}
