package com.tju.manager.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface FileDao {

    @Update("update tb_user set avatar=#{avatar} where id=#{id}")
    boolean setAvatar(@Param("avatar")String avatar, @Param("id")int id);

    @Select("select avatar from tb_user where id=#{id}")
    String getAvatar(@Param("id")int id);
}
