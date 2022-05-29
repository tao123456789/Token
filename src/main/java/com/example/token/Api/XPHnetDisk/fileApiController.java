package com.example.token.Api.XPHnetDisk;

import com.example.token.Annotation.AspectLogAnnptation;
import com.example.token.Config.Interface.UserLoginToken;
import com.example.token.Utils.file.FileUtil;
import com.example.token.Utils.user.UserUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping("/XPHnetDisk")
public class fileApiController {
    @Autowired
    private FileUtil fileUtil;
    @Resource
    UserUtil userUtil;

    private static final String BASEPATH="/user/data/upload/";

    @UserLoginToken
    @GetMapping("/getFileList")
    @ApiOperation("获取网盘文件列表")
    @AspectLogAnnptation
    public ArrayList<Object> getFileList (String url) {
        int userid=userUtil.getCurrentUserInfo().getId();
        if(url==null){
            url=BASEPATH+userid;
        }else {
            url = BASEPATH + userid + url;
        }
        return fileUtil.getfileList(userid,url);
    }

    @PostMapping("/uploadFile")
    @ApiOperation("上传文件")
    @ResponseBody
    @AspectLogAnnptation
    public String upload(@RequestParam("file") MultipartFile file,@RequestParam("url") String url) throws Exception{
        int userid=userUtil.getCurrentUserInfo().getId();
        if(file.isEmpty()){
            return "文件不能为空";
        }
        if(url.isEmpty()){
            return "路径不能为空";
        }
        fileUtil.uploadFile(file,BASEPATH+userid+url,userid);
        return "上传成功！";
    }

    @GetMapping("/addFilePath")
    @ApiOperation("网盘路径新建")
    @ResponseBody
    @AspectLogAnnptation
    public String addFilePath(@RequestParam String currentPath,@RequestParam String name){
        int userid=userUtil.getCurrentUserInfo().getId();
        if(currentPath.isEmpty()){
            return "路径不能为空";
        }
        if(name.isEmpty()){
            return "文件名不能为空";
        }
        fileUtil.addFilePath(BASEPATH+userid+currentPath,name,userid);
        return "新建成功！";
    }

    @UserLoginToken
    @GetMapping("/downloadFile")
    @ApiOperation("下载文件")
    @AspectLogAnnptation
    public HttpServletResponse downloadFile (@RequestParam("url") String url, HttpServletResponse response) throws IOException {
        int userid=userUtil.getCurrentUserInfo().getId();
        try {
            url = "/" + userid + url;
            File file = new File(url);
            // 取得文件名。
            String filename = file.getName();
            if (!file.exists()) {
                throw new IOException(url + "文件不存在");
            }
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(url));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }
}
