package com.fc.controller;

import com.fc.entity.Collection;
import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/msgboard")
public class MessageBoardController {
    @Autowired
    private MessageBoardService messageBoardService;

    //留言表获取
    @GetMapping("getlist")//驼峰命名getList  默认第一页为起始页  默认每页三条
    public ResultVO getlist(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize,
                            Long id) {
        return messageBoardService.getlist(pageNum, pageSize, id);
    }

    //留言添加
    @PostMapping("add")
    public ResultVO add(@RequestBody MessageBoardWithBLOBs messageBoard) {
        return messageBoardService.add(messageBoard);
    }

    //留言删除
    @GetMapping("delete")
    public ResultVO delete(@RequestParam Long id) {
        return messageBoardService.delete(id);
    }
}
