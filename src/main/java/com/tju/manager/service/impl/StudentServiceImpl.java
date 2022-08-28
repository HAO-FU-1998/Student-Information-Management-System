package com.tju.manager.service.impl;

import com.tju.manager.dao.StudentDao;
import com.tju.manager.entity.Student;
import com.tju.manager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao ;

    @Override
    public List<Student> getAll(){
        return studentDao.getAll();
    };

    @Override
    public Student getById(String id){
        return studentDao.getById(id);
    }

    @Override
    public List<Map<String, Number>> placeMessage() {
        return studentDao.placeMessage();
    }

    @Override
    public List<Map<String, Number>> genderMessage() {
        return studentDao.genderMessage();
    }

    @Override
    public List<Map<String, Number>> nationMessage() {
        return studentDao.nationMessage();
    }

    @Override
    public int sumStudent() {
        return studentDao.sumStudent();
    }

    @Override
    public int sumCourse() {
        return studentDao.sumCourse();
    }
}
