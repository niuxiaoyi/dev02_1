package com.fc.service.impl;

import com.fc.dao.TbNoteTypeMapper;
import com.fc.entity.TbNoteType;
import com.fc.service.TbNoteTypeService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TbNoteTypeServiceImpl implements TbNoteTypeService {
    @Autowired
    private TbNoteTypeMapper tbNoteTypeMapper;

    //扶贫政策项目获取
    @Override
    public ResultVO list(Integer pageNum, Integer pageSize, Long id) {
        // 返回给前端的结果
        ResultVO resultVO;

        // 分页相关的参数
        DataVO<TbNoteType> dataVO;

        // 结果中data对应的用户数组
        List<TbNoteType> tbNoteTypes;

        // 说明传递了id，那就是findById
        if (id != null) {
            tbNoteTypes = new ArrayList<>();

            // 查询
            TbNoteType tbNoteType = tbNoteTypeMapper.selectByPrimaryKey(id);

            // 没有查到用户的情况
            if (tbNoteType == null) {
                dataVO = new DataVO<>(0L, tbNoteTypes, pageNum, pageSize);

                resultVO = new ResultVO(4000, "没有这条扶贫政策!", false, dataVO);
            } else {
                // 如果是查询单个，那么点击量应该加1
                //click(tbNoteType.getId(), null);

                // 更新点击的次数
                //tbNoteType.setClickNum(tbNoteType.getClickNum() + 1);

                // 查到了用户扔到集合中
                tbNoteTypes.add(tbNoteType);

                dataVO = new DataVO<>(1L, tbNoteTypes, pageNum, pageSize);

                resultVO = new ResultVO(1000, "查到了该政策!", true, dataVO);
            }
        } else {
            // 开启分页
            PageHelper.startPage(pageNum, pageSize);

            tbNoteTypes = tbNoteTypeMapper.selectByExampleWithBLOBs(null);

            // 如果数据库是空的，一个人都没查到
            if (tbNoteTypes.size() == 0) {
                dataVO = new DataVO<>(0L, tbNoteTypes, pageNum, pageSize);

                resultVO = new ResultVO(4100, "没有扶贫政策!!!", false, dataVO);
                // 查到了
            } else {
                // 封装pageInfo，为了获取总数据量
                PageInfo<TbNoteType> pageInfo = new PageInfo<>(tbNoteTypes);

                dataVO = new DataVO<>(pageInfo.getTotal(), tbNoteTypes, pageNum, pageSize);

                resultVO = new ResultVO(1100, "扶贫政策查询成功！！！!", true, dataVO);

            }
        }

        return resultVO;
    }



}
