package com.example.token.Api.XPHnetDisk;

import com.example.token.Annotation.AspectLogAnnptation;
import com.example.token.Config.Interface.UserLoginToken;
import com.example.token.Utils.file.FileUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/XPHnetDisk")
public class fileApiController{
    @Autowired
    private FileUtil fileService;

    @UserLoginToken
    @GetMapping("/getFileList")
    @ApiOperation("获取网盘文件列表")
    @AspectLogAnnptation
    public List<String> getFileList(@RequestParam("url") String url) {
        return fileService.fileList(url);
    }

    @UserLoginToken
    @GetMapping("/downloadFile")
    @ApiOperation("下载文件")
    public ResponseEntity<byte[]> downloadFile(@RequestParam("url") String url, HttpServletRequest request) throws IOException {
        File file = new File(url);
        if(!file.exists()){
            throw new IOException(url+"文件不存在");
        }
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
//        System.out.println(file.getName());
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attchement", file.getName());
//        System.out.println(headers);
        HttpStatus statusCode = HttpStatus.OK;
        log.info("文件下载目录："+url+"，文件名称："+file.getName());
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }
}
