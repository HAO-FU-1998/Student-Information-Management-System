package com.tju.manager.dao;

import com.tju.manager.entity.Connect;
import com.tju.manager.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ScoreDao {

    List<Connect> getScore(@Param("id") String id, @Param("name") String name);

    boolean chooseCourse(@Param("studentid") String studentid, @Param("courseid") int courseid);

    boolean quitCourse(@Param("studentid") String studentid, @Param("courseid") int courseid);

    boolean enterScore(@Param("score") int score, @Param("studentid") String studentid, @Param("courseid") int courseid);

    @Select("select * from tb_course")
    List<Course> getAllCourse();

    @Select("SELECT courseid, COUNT(studentid) as studentnum FROM tb_score GROUP BY courseid")
    List<Map<String, Number>> courseMessage();
}

