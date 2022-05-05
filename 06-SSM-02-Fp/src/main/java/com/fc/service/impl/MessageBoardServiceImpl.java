package com.fc.service.impl;

import com.fc.dao.CollectionMapper;
import com.fc.dao.MessageBoardMapper;
import com.fc.entity.Collection;
import com.fc.entity.MessageBoard;
import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MessageBoardServiceImpl implements MessageBoardService {
    @Autowired
    private MessageBoardMapper messageBoardMapper;//通过messageBoardMapper连接数据库


    @Override
    public ResultVO getlist(Integer pageNum, Integer pageSize, Long id) {
        // 返回给前端的结果
        ResultVO resultVO;

        // 分页相关的参数
        DataVO<MessageBoardWithBLOBs> dataVO;

        // 结果中data对应的用户数组
        List<MessageBoardWithBLOBs> messageBoards;

        // 说明传递了id，那就是findById
        if (id != null) {
            messageBoards = new ArrayList<>();

            // 查询
            MessageBoardWithBLOBs messageBoard = messageBoardMapper.selectByPrimaryKey(id);

            // 没有查到用户的情况
            if (messageBoard == null) {
                dataVO = new DataVO<>(0L, messageBoards, pageNum, pageSize);

                resultVO = new ResultVO(4000, "没有这条留言信息!", false, dataVO);
            } else {


                // 查到了用户扔到集合中
                messageBoards.add(messageBoard);

                dataVO = new DataVO<>(1L, messageBoards, pageNum, pageSize);

                resultVO = new ResultVO(1000, "查到了该留言信息!", true, dataVO);
            }
        } else {
            // 开启分页
            PageHelper.startPage(pageNum, pageSize);

            messageBoards = messageBoardMapper.selectByExampleWithBLOBs(null);

            // 如果数据库是空的，一个人都没查到
            if (messageBoards.size() == 0) {
                dataVO = new DataVO<>(0L, messageBoards, pageNum, pageSize);

                resultVO = new ResultVO(4100, "没有留言信息!!!", false, dataVO);
                // 查到了
            } else {
                // 封装pageInfo，为了获取总数据量
                PageInfo<MessageBoardWithBLOBs> pageInfo = new PageInfo<>(messageBoards);

                dataVO = new DataVO<>(pageInfo.getTotal(), messageBoards, pageNum, pageSize);

                resultVO = new ResultVO(1100, "留言信息查询成功！！！!", true, dataVO);

            }
        }

        return resultVO;
    }

    @Override
    public ResultVO add(MessageBoardWithBLOBs messageBoard) {
        ResultVO vo;
        // 判断是否存在创建时间，没有就自己加上
        if (messageBoard.getCreateTime() == null) {
            messageBoard.setCreateTime(new Date());
        }

        // 新创建的扶贫政策，点击量应该是0
        //alleviation.setClickNum(0);
       // alleviation.setLastClickTime(null);

        int affectedRows = messageBoardMapper.insertSelective(messageBoard);

        if (affectedRows > 0) {
            vo = new ResultVO(1000, "添加留言成功！！", true, messageBoard);
        } else {
            vo = new ResultVO(5000, "添加留言失败！！", false, null);
        }

        return vo;
    }

    @Override
    public ResultVO delete(Long id) {
        int affectedRows = messageBoardMapper.deleteByPrimaryKey(id);

        ResultVO vo;

        if (affectedRows > 0) {
            vo = new ResultVO(1000, "删除留言成功！！", true, null);
        } else {
            vo = new ResultVO(5000, "删除留言失败！！", false, null);
        }

        return vo;
    }
}
