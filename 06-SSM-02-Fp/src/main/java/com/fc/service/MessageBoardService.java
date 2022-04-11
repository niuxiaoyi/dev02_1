package com.fc.service;

import com.fc.entity.Collection;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.vo.ResultVO;

public interface MessageBoardService {
    ResultVO getlist(Integer pageNum, Integer pageSize, Long id);

    ResultVO add(MessageBoardWithBLOBs messageBoard);

    ResultVO delete(Long id);


}
