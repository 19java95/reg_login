package com.imooc.domain.servlet.utils;

import java.util.UUID;

/**
 * Created by TangTian on 2018/7/26
 * 文件上传的工具类
 */
public class UploadUtils {
    public static String getUUIDFilName(String fileName){

        int idx = fileName.lastIndexOf(".");
        String extention = fileName.substring(idx);
        String uuidFileName = UUID.randomUUID().toString().replace("-","")+extention;
        return uuidFileName;

    }

}
