package com.leike.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-11 18:20
 */
public interface UploadService {

    String uploadFile(MultipartFile multipartFile, String uploadPath, String addr);

}
