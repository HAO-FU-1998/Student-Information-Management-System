package com.tju.manager.service;

import org.springframework.stereotype.Service;

@Service
public interface FileService {

    boolean setAvatar(String avatar, int id);

    String getAvatar(int id);
}
