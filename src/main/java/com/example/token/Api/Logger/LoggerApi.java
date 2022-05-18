package com.example.token.Api.Logger;

import com.example.token.Config.Interface.UserLoginToken;
import com.example.token.Entity.BO.aspectlog.AspectLogBO;
import com.example.token.Mapper.AspectLogMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/logger")
@Api(tags = "日志信息")
public class LoggerApi {
    @Resource
    AspectLogMapper aspectLogMapper;

    @UserLoginToken
    @GetMapping("/getLog")
    @ResponseBody
    @ApiOperation("获取日志信息")
    public String getLog() throws IOException {
        File file=new File("/jar/Token.log");
        ArrayList<String> log=new ArrayList<>();
        if(!file.exists()){
            System.out.println("日志文件不存在");
            return "日志文件不存在";
        }
        FileInputStream fis=new FileInputStream("/jar/Token.log");
        InputStreamReader is=new InputStreamReader(fis,"UTF-8");
        BufferedReader br=new BufferedReader(is);
        String line="";
        while ((line = br.readLine())!=null){
            log.add(line);
        }
        System.out.println("获取日志文件成功，日志大小为："+log.size());
        return log.toString();
    }

    @UserLoginToken
    @GetMapping("/getAspectLog")
    @ResponseBody
    @ApiOperation("获取切面日志信息")
    public List<AspectLogBO> getAspectLogList(){
        return aspectLogMapper.getAspectLogList();
    }
}
