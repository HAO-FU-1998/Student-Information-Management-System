package com.tju.manager.controller;


import com.tju.manager.entity.Student;
import com.tju.manager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("getAll")
    @ResponseBody
    List<Student> getAll(){
        return studentService.getAll();
    }

    @RequestMapping("getById")
    @ResponseBody
    Student getById (@RequestParam("id")String id){
        return studentService.getById(id);
    }

    @RequestMapping("placeMessage")
    @ResponseBody
    public List<Map<String, Number>> placeMessage(){
        return studentService.placeMessage();
    }

    @RequestMapping("genderMessage")
    @ResponseBody
    public List<Map<String, Number>> genderMessage(){
        return studentService.genderMessage();
    }

    @RequestMapping("nationMessage")
    @ResponseBody
    public List<Map<String, Number>> nationMessage(){
        return studentService.nationMessage();
    }

    @RequestMapping("sumStudent")
    @ResponseBody
    public int sumStudent(){
        return studentService.sumStudent();
    };

    @RequestMapping("sumCourse")
    @ResponseBody
    public int sumCourse(){
        return studentService.sumCourse();
    };
}
