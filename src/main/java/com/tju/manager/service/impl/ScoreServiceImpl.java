package com.tju.manager.service.impl;

import com.tju.manager.dao.ScoreDao;
import com.tju.manager.entity.Connect;
import com.tju.manager.entity.Course;
import com.tju.manager.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreDao scoreDao;
    @Override
    public List<Connect> getScore(String id, String name){

        return scoreDao.getScore(id,name);
    }

    @Override
    public  boolean chooseCourse(String studentid, int courseid){
        return scoreDao.chooseCourse(studentid,courseid);
    }
    @Override
    public boolean quitCourse (String studentid, int courseid){
        return scoreDao.quitCourse(studentid,courseid);
    }
    @Override
    public boolean enterScore ( int score, String studentid,int courseid){
        return scoreDao.enterScore(score,studentid,courseid);
    }
    @Override
    public List<Course> getAllCourse(){
        return scoreDao.getAllCourse();
    };

    @Override
    public List<Map<String, Number>> courseMessage(){
        return scoreDao.courseMessage();
    };
}
