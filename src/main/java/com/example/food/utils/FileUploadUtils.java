package com.example.food.utils;

import org.springframework.web.multipart.MultipartFile;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

public class FileUploadUtils {

    public static String upLoadPicture(MultipartFile file, String savePath, HttpServletRequest request) throws IOException {
        String serviceUrl = "http://123.207.117.247:8080/food-0.0.1-SNAPSHOT";//服务器IP
        String dir = request.getServletContext().getRealPath(savePath);
        File fileDir = new File(dir);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        String suffixName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + suffixName;
        File newFile = new File(fileDir + "/" + fileName);
        try {
            file.transferTo(newFile);
        } catch (Exception e) {
            System.out.print(e.toString());
        }
        return serviceUrl + "/" + savePath + "/" + fileName;
    }
}
