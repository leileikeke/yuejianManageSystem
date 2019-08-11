package com.leike.service.impl;

import com.leike.service.UploadService;
import com.leike.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author: leike
 * @date: 2019-08-11 18:20
 */
@Service("uploadService")
public class UploadServiceImpl implements UploadService {

    @Override
    public String uploadPic(MultipartFile multipartFile, String uploadPath, String addr) {
        String fileName = FileUtil.uploadPic(multipartFile, uploadPath, addr);
        return fileName;
    }

}
