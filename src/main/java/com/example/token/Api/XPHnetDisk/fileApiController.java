package com.example.token.Api.XPHnetDisk;

import com.example.token.Config.Interface.UserLoginToken;
import com.example.token.util.file.FileUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/XPHnetDisk")
public class fileApiController{
    @Autowired
    FileUtil fileService;

    @UserLoginToken
    @GetMapping("/getFileList")
    @ApiOperation("获取网盘文件列表")
    public List<String> getFileList(@RequestParam("url") String url) {
        return fileService.fileList(url);
    }

//    @UserLoginToken
    @GetMapping("/downloadFile")
    @ApiOperation("下载文件")
    public File downloadFile(@RequestParam("url") String url) throws IOException {
        return fileService.downloadFile(url);
    }
}
