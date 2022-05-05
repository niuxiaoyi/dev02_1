package com.fc.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountDao {
    // 加钱
    void increase(@Param("t_id") Integer t_id, @Param("t_pwd") Integer t_pwd);

    // 减钱
    void decrease(@Param("t_id") Integer t_id, @Param("t_pwd") Integer t_pwd);
}