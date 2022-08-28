package com.tju.manager.service;


import com.tju.manager.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface StudentService {

    /**
     * 查询全体学生基本信息
     */
    List<Student> getAll();

    /**
     * 根据学生id查询
     */
    Student getById(String id) ;

    /**
     * 查询对应地域人数
     * @return
     */
    List<Map<String, Number>> placeMessage();

    /**
     * 查询男女比例
     * @return
     */
    List<Map<String, Number>> genderMessage();


    /**
     * 查询民族比例
     * @return
     */
    List<Map<String, Number>> nationMessage();

    /**
     * 查询记录总数量
     * @return
     */
    int sumStudent();

    /**
     * 查询记录总数量
     * @return
     */
    int sumCourse();
}
