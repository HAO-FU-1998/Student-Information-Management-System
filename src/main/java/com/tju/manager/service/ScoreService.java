package com.tju.manager.service;

import com.tju.manager.entity.Connect;
import com.tju.manager.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ScoreService {

    /**
     *
     * 获取成绩
     */
    List<Connect> getScore(String id, String name);

    /**
     *
     * 选课
     */
    boolean chooseCourse(String studentid, int courseid);
    /**
     * 退课
     */
    boolean quitCourse(String studentid, int courseid);
    /**
     * 更新成绩
     */
    boolean enterScore(int score, String studentid, int courseid);
    /**
     * 查询所有课程的信息
     */
    List<Course> getAllCourse();

    /**
     * 查询对应课程的选课人数
     */
    List<Map<String, Number>> courseMessage();
}
