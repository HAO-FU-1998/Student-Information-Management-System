package com.tju.manager.service;

import com.tju.manager.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    /**
     * 登录校验
     */
    User loginCheck(String name, String pwd) ;
    /**
     * 注册
     */
    boolean register(User user) ;

    /**
     * 查询个人主页要显示的信息
     * @param id
     * @return
     */
    User getUserMessage(int id);

    /**
     * 用户名是否可用
     */
    boolean isNameExists(String name) ;
    /**
     * 根据id查看个人信息
     */
    User getById(int id) ;
    /**
     * 密码验证
     */
    boolean checkPass(String pwd, int id) ;
    /**
     * 修改密码
     */
    boolean rePass(String newPwd, int id) ;

    /**
     * 查询记录总数量
     * @return
     */
    int sumUser();

}
