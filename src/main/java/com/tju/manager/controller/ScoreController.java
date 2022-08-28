package com.tju.manager.controller;


import com.tju.manager.entity.Connect;
import com.tju.manager.entity.Course;
import com.tju.manager.service.ScoreService;
import com.tju.manager.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/score")
public class ScoreController {

    @Autowired
    ScoreService scoreService;

    @RequestMapping("getScore")
    @ResponseBody
    public List<Connect> getScore(@RequestParam("id") String id, @RequestParam("name") String name){
        String idObj = null ,nameObj = null;
        if(! StringUtil.isEmpty(id)){
            try {
                idObj = id ;
            } catch (NumberFormatException e) {
                idObj = null ;
            }
        }
        if(! StringUtil.isEmpty(name)){
            try {
                nameObj = name ;
            } catch (NumberFormatException e) {
                nameObj = null ;
            }
        }
        //System.out.println(idObj+nameObj);
        return scoreService.getScore(idObj,nameObj);

    }

    @RequestMapping("chooseCourse")
    @ResponseBody
    public boolean chooseCourse (@RequestParam("studentid") String studentid, @RequestParam("courseid") int courseid){
        return scoreService.chooseCourse(studentid,courseid);
    }

    @RequestMapping("quitCourse")
    @ResponseBody
    boolean quitCourse (@RequestParam("studentid") String studentid, @RequestParam("courseid") int courseid){
        return scoreService.quitCourse(studentid,courseid);
    }

    @RequestMapping("enterScore")
    @ResponseBody
    boolean enterScore (@RequestParam("score") int score,@RequestParam("studentid") String studentid, @RequestParam("courseid") int courseid){
        return scoreService.enterScore(score,studentid,courseid);
    }

    @RequestMapping("getAllCourse")
    @ResponseBody
    List<Course> getAllCourse(){
        return scoreService.getAllCourse();
    };

    @RequestMapping("courseMessage")
    @ResponseBody
    List<Map<String, Number>> courseMessage(){
        return scoreService.courseMessage();
    };
}
