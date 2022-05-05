package com.fc.service;

import com.fc.vo.ResultVO;

public interface TbNoteTypeService {
    ResultVO list(Integer pageNum, Integer pageSize, Long id);
}
