package com.tju.manager.dao;

import com.tju.manager.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;


@Mapper
public interface StudentDao {

    @Select("select * from tb_student")
    List<Student> getAll();

    //@Select("select * from tb_student where id = #{id}")
    Student getById(@Param("id") String id);

    @Select("SELECT place, COUNT(id) as num FROM tb_student GROUP BY place")
    List<Map<String, Number>> placeMessage();

    @Select("select gender, count(id) as num from tb_student group by gender")
    List<Map<String, Number>> genderMessage();

    @Select("select nation, count(id) as num from tb_student group by nation")
    List<Map<String, Number>> nationMessage();

    @Select("select count(*) from tb_student")
    int sumStudent();

    @Select("select count(*) from tb_course")
    int sumCourse();
}
