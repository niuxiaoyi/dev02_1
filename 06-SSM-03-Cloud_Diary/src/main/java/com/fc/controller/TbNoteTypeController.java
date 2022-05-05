package com.fc.controller;

import com.fc.service.TbNoteTypeService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("type")
public class TbNoteTypeController {
    @Autowired
    private TbNoteTypeService tbNoteTypeService;

    @GetMapping("list")
    public ResultVO list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "3")  Integer pageSize,
                            Long id) {
        return tbNoteTypeService.list(pageNum, pageSize, id);
    }
}
