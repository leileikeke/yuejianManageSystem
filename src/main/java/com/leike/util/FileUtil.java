package com.leike.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 文件相关工具类
 *
 * @description:
 * @author: leike
 * @date: 2019-08-09 18:59
 */
public class FileUtil {


    /**
     * 上传文件
     * @param multipartFile
     * @param uploadPath
     * @return
     */
    public static String uploadPic(MultipartFile multipartFile, String uploadPath,String type) {
        //1.获取原始的文件名
        String originalFilename1 = multipartFile.getOriginalFilename();
        //2. 先截取源文件的文件名前缀 , 不带后缀
        String fileNamePrefix = originalFilename1.substring(0, originalFilename1.lastIndexOf("."));
        //3. 加工处理文件名 , 将原文件名+时间戳
        String newfileNamePrefix = fileNamePrefix + new Date().getTime();
        System.out.println(new Date().getTime());
        //4. 得到新文件名
        String newFilename = newfileNamePrefix + originalFilename1.substring(originalFilename1.lastIndexOf('.'));
        //5. 构建文件对象
        String fileName = type + newFilename;
        File file = new File(uploadPath + fileName);
        System.out.println(file.getPath());
        //6.上传
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }

    /**
     * 删除文件
     * @param uploadPath
     * @param pic
     */
    public static void deleteFile(String uploadPath, String pic) {

        File file = new File(uploadPath+pic);
        System.out.println(file.getPath());
        if (file.isFile() && file.exists()) {
            file.delete();
        }
    }
}
