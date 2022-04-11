package com.fc.service.impl;


import com.fc.dao.CollectionMapper;
import com.fc.dao.UserMapper;
import com.fc.entity.Collection;
import com.fc.entity.VolunteerRecruitment;
import com.fc.service.CollectionService;
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
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;//通过collectionMapper连接数据库

    //收藏表获取
    @Override
    public ResultVO getlist(Integer pageNum, Integer pageSize, Long id) {
        // 返回给前端的结果
        ResultVO resultVO;

        // 分页相关的参数
        DataVO<Collection> dataVO;

        // 结果中data对应的用户数组
        List<Collection> collections;

        // 说明传递了id，那就是findById
        if (id != null) {
            collections = new ArrayList<>();

            // 查询
            Collection collection = collectionMapper.selectByPrimaryKey(id);

            // 没有查到用户的情况
            if (collection == null) {
                dataVO = new DataVO<>(0L, collections, pageNum, pageSize);

                resultVO = new ResultVO(4000, "没有这条收藏信息!", false, dataVO);
            } else {


                // 查到了用户扔到集合中
                collections.add(collection);

                dataVO = new DataVO<>(1L, collections, pageNum, pageSize);

                resultVO = new ResultVO(1000, "查到了该收藏信息!", true, dataVO);
            }
        } else {
            // 开启分页
            PageHelper.startPage(pageNum, pageSize);

            collections = collectionMapper.selectByExample(null);

            // 如果数据库是空的，一个人都没查到
            if (collections.size() == 0) {
                dataVO = new DataVO<>(0L, collections, pageNum, pageSize);

                resultVO = new ResultVO(4100, "没有收藏信息!!!", false, dataVO);
                // 查到了
            } else {
                // 封装pageInfo，为了获取总数据量
                PageInfo<Collection> pageInfo = new PageInfo<>(collections);

                dataVO = new DataVO<>(pageInfo.getTotal(), collections, pageNum, pageSize);

                resultVO = new ResultVO(1100, "收藏信息查询成功！！！!", true, dataVO);

            }
        }

        return resultVO;
    }

    //添加收藏
    @Override
    public ResultVO add(Collection collection) {
        ResultVO vo;
        // 判断是否存在创建时间，没有就自己加上
        if (collection.getCreateTime() == null) {
            collection.setCreateTime(new Date());
        }

        int affectedRows = collectionMapper.insertSelective(collection);

        if (affectedRows > 0) {
            vo = new ResultVO(1000, "添加收藏成功！！", true, collection);
        } else {
            vo = new ResultVO(5000, "添加收藏失败！！", false, null);
        }

        return vo;
    }

    //修改收藏
    @Override
    public ResultVO update(Collection collection) {
        int affectedRows = collectionMapper.updateByPrimaryKeySelective(collection);

        ResultVO vo;

        if (affectedRows > 0) {
            // 修改完成之后，再重新查询一次，保证返回给前端的是最新最全的数据
            collection = collectionMapper.selectByPrimaryKey(collection.getId());

            vo = new ResultVO(1000, "修改收藏成功！！", true, collection);
        } else {
            vo = new ResultVO(5000, "修改收藏失败！！", false, null);
        }

        return vo;
    }

    //删除收藏
    @Override
    public ResultVO delete(Long id) {
        int affectedRows = collectionMapper.deleteByPrimaryKey(id);

        ResultVO vo;

        if (affectedRows > 0) {
            vo = new ResultVO(1000, "删除收藏成功！！", true, null);
        } else {
            vo = new ResultVO(5000, "删除收藏失败！！", false, null);
        }

        return vo;
    }
}
