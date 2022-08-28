package com.tju.manager.controller;

import com.tju.manager.entity.User;
import com.tju.manager.service.UserService;
import com.tju.manager.util.MD5Tools;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService ;

    @RequestMapping("register")
    @ResponseBody
    public Map<String , Boolean> register(@RequestParam("username") String name , @RequestParam("password") String pass, @RequestParam("phone") String phone, @RequestParam("email") String email) {
        User user = new User() ;
        user.setUsername(name);
        user.setUserpass(pass);
        user.setPhone(phone);
        user.setEmail(email);
        boolean r = userService.register(user) ;
        Map<String , Boolean> map = new HashMap<>() ;
        map.put("result" , r) ;
        return map ;
    }

    @RequestMapping("logincheck")
    @ResponseBody
    public User loginCheck(String username , @RequestParam("userpass") String password , HttpSession session) {
        User user = null ;
        user = userService.loginCheck(username , password) ;

        if(null != user) {
            // Session存储数据
            session.setAttribute("loginuser", user);
        }
        return user ;
    }

    @RequestMapping("iflogin")
    @ResponseBody
    public Object ifLogin(HttpSession session) {
        // Session取出数据
        Object obj = session.getAttribute("loginuser") ;
        return obj ;
    }

    @RequestMapping("exit")
    @ResponseBody
    public Boolean exit(HttpSession session) {
        // Session清空
        session.removeAttribute("loginuser");
        session.invalidate();
        return true ;
    }


    @RequestMapping("namecheck")
    @ResponseBody
    public Map<String , Boolean> nameCheck(String name) {
        boolean r = userService.isNameExists(name) ;
        Map<String , Boolean> map = new HashMap<>() ;
        map.put("valid" , !r) ;
        return map ;
    }

    @RequestMapping("pwdCheck")
    @ResponseBody
    public Map<String, Boolean> pwdCheck(@RequestParam("oldpwd") String pwd, @RequestParam("id") int id) {
        boolean r = userService.checkPass(pwd, id) ;
        Map<String , Boolean> map = new HashMap<>() ;
        map.put("valid" , r) ;
        return map ;
    }

    @RequestMapping("rePass")
    @ResponseBody
    public Boolean rePass(@RequestParam("newpwd") String pwd, @RequestParam("id") int id) {
        return userService.rePass(pwd, id);
    }

    @RequestMapping("sumUser")
    @ResponseBody
    public int sumUser(){
        return userService.sumUser();
    }

    @RequestMapping("getUserMessage")
    @ResponseBody
    public User getUserMessage(@RequestParam("id")int id){
        return userService.getUserMessage(id);
    }

}
