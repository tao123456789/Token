package com.example.token.util.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface fileService {
    //上传文件，文件类型暂不做限制，根据目录保存
    String uploadFile(MultipartFile file, String fileUrl) throws IOException;
}
