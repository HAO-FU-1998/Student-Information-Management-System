package com.tju.manager.dao;

import com.tju.manager.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {

    @Select("select * from tb_user where username=#{name} and userpass=#{pass}")
    User loginCheck(@Param("name") String name , @Param("pass") String pass) ;


    @Select("select count(*) from tb_user where username=#{name}")
    int nameCheck(@Param("name")String name) ;

//    @Insert("insert into tb_user(username,userpass) values(#{user.username}, #{user.userpass})")
//    int addUser(@Param("user")User user);
    @Insert("insert into tb_user(username,userpass,phone,email) values(#{user.username}, #{user.userpass}, #{user.phone}, #{user.email})")
    int addUser(@Param("user")User user);

    @Select("select * from tb_user where id=#{id}")
    User getUserMessage(@Param("id")int id);

    @Select("select count(*) from tb_user where id=#{id} and userpass=#{pwd}")
    int pwdCheck(@Param("pwd")String pwd, @Param("id")int id);

    @Update("update tb_user set userpass=#{pwd} where id=#{id}")
    boolean rePass(@Param("pwd")String pwd, @Param("id")int id);

    @Select("select count(*) from tb_user")
    int sumUser();

}
