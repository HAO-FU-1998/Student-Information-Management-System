package com.tju.manager.controller;

import com.tju.manager.service.FileService;
import com.tju.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    FileService fileService;

    @RequestMapping("upload")
    @ResponseBody
    public Map<String , Boolean> fileUp(@RequestParam("userphoto") MultipartFile file , Integer id , HttpServletRequest request) {
        Map<String , Boolean> map = new HashMap<>();
        map.put("result" , false) ;
        String fname = file.getOriginalFilename() ;

        System.out.println(fname);
        // 获取上传文件的扩展名
        String extName = fname.substring(fname.lastIndexOf(".")) ;
        // 构建文件新名字 : 上传日期时间+ "_" + 用户id
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date()) + "_" + id + extName ;
        System.out.println(newFileName);
        // 设置文件保存路径
        // 获取项目所在路径，然后在该路径下映射目录 userphoto
        String savePath = request.getServletContext().getRealPath("/userphoto") + "/" ;
        System.out.println(savePath);

        File directory = new File("");
        String localpath = directory.getAbsolutePath();
        String mypath = localpath + "\\src\\main\\resources\\static\\avatar\\" + newFileName;

        // 判断路径是否存在，不存在则创建
        File f = new File(savePath) ;
        if(!f.exists()) {
            f.mkdirs() ;
        }
        if(!file.isEmpty()) {
            try {
                // 保存文件
//                file.transferTo(new File(savePath + newFileName));
                file.transferTo(new File(mypath));
                map.put("result" , true) ;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fileService.setAvatar(newFileName, id);

        return map ;
    }

    @RequestMapping("getAvatar")
    @ResponseBody
    public String getAvatar(@RequestParam("id")int id){
        return fileService.getAvatar(id);
    }

}