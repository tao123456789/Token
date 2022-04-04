package com.example.token.util.file.Impl;

import com.example.token.util.file.fileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Locale;

@Slf4j
@Service
public class fileServiceImpl implements fileService {

    @Override
    public String uploadFile(MultipartFile file,String fileUrl) throws IOException {
        if(fileUrl.isEmpty()||file.isEmpty()){
            log.info("文件路径或文件不能为空");
            throw new NullPointerException();
        }

        InputStream inputStream=file.getInputStream();
        log.info("转换为流文件:"+inputStream);
        byte[] bytes=new byte[3];
        inputStream.read(bytes,0,bytes.length);
        //截取文件头
        String headerType=bytesToHexString(bytes);
        //文件类型
        headerType=headerType.toUpperCase(Locale.ROOT);
        String checkType=checkType(headerType);
        //文件信息
        String fileName=file.getOriginalFilename();
        Long fileSize=file.getSize();
        //输出文件信息
        log.info("文件名称："+fileName);
        log.info("头文件是："+headerType);
        log.info("后缀名是:"+checkType);
        log.info("文件大小："+fileSize);
        log.info("文件保存路径："+fileUrl);

        //存储文件
        try {
            String pathname = fileUrl + "/" + fileName;
            File uploadFile = new File(pathname).getCanonicalFile();
            if (!uploadFile.getParentFile().exists()) {
                if (!uploadFile.getParentFile().mkdir()) {
                    log.info("创建文件目录失败！！！");
                }
            } else {
                log.info(pathname + "文件路径已存在");
            }
            //文件写入
            file.transferTo(uploadFile);
        }catch (IOException e){
            log.error("文件保存失败！！！"+e);
        }
        return "文件上传成功！！！";
    }
//截取文件头
    public static String bytesToHexString(byte[] bytes){
        StringBuilder stringBuilder=new StringBuilder();
        if(bytes==null || bytes.length <= 0){
            log.info("无法读取文件头信息");
            return null;
        }
        for (int i=0;i<bytes.length;i++){
            int v=bytes[i]&0xFF;
            String hv=Integer.toHexString(v);
            if(hv.length()<2){
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();

    }
//文件类型库，后续添加完善
    public static String checkType(String type){
        switch (type){
            case "FFD8FF":return "jpg";
            case "89504E47":return "png";
            case "47494638":return "gif";
            case "504B03":return "xlsx";
            default:return "unknown";
        }
    }
}