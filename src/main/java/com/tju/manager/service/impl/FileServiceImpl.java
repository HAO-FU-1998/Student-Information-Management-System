package com.tju.manager.service.impl;

import com.tju.manager.dao.FileDao;
import com.tju.manager.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    FileDao fileDao;

    @Override
    public boolean setAvatar(String avatar, int id){
        return fileDao.setAvatar(avatar, id);
    }

    @Override
    public String getAvatar(int id){
        return fileDao.getAvatar(id);
    }

}
