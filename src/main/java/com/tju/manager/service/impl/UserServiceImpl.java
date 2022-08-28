package com.tju.manager.service.impl;

import com.tju.manager.dao.UserDao;
import com.tju.manager.entity.User;
import com.tju.manager.service.UserService;
import com.tju.manager.util.MD5Tools;
import com.tju.manager.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao ;
    @Override
    public User loginCheck(String name, String pwd) {
        if(StringUtil.isEmpty(name) || StringUtil.isEmpty(pwd)) {
            return  null ;
        }
        return userDao.loginCheck(name , MD5Tools.MD5(pwd));
    }

    @Override
    public boolean register(User user) {
        if(null == user) {
            return false ;
        }
        user.setUserpass(MD5Tools.MD5(user.getUserpass()));
        return userDao.addUser(user) > 0 ? true : false;
    }

    @Override
    public boolean isNameExists(String name) {
        if(StringUtil.isEmpty(name)) {
            return true ;
        }
        int count = userDao.nameCheck(name) ;
        return count > 0 ? true : false ;
    }

//    @Transactional
//    public boolean removeUser(int id) {
//        // 删除用户所有的打卡信息
//        // 删除用户所有的留言信息
//        // 删除用户
//        return false ;
//    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public boolean checkPass(String pwd, int id) {
        if(StringUtil.isEmpty(pwd)) {
            return true ;
        }
        int count = userDao.pwdCheck(MD5Tools.MD5(pwd), id) ;
        return count > 0 ? true : false;
    }

    @Override
    public boolean rePass(String newPwd, int id) {
        if(null == newPwd || id <= 0){
            return false;
        }
        return userDao.rePass(MD5Tools.MD5(newPwd), id);
    }

    @Override
    public int sumUser() {
        return userDao.sumUser();
    }

    @Override
    public User getUserMessage(int id) {
        return userDao.getUserMessage(id);
    }
}
