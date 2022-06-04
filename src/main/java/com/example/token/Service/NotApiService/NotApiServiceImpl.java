package com.example.token.Service.NotApiService;

import com.example.token.Utils.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
public class NotApiServiceImpl {

    @Resource
    HttpUtil httpUtil;

    public String getWBHotMessage(){
        HashMap hashMap=new HashMap();
        hashMap.put("cookie","SUB=1");
        String response=httpUtil.getMethod("https://s.weibo.com/top/summary?cate=realtimehot",hashMap);
        List<String> content= Arrays.asList(StringUtils.substringsBetween(response, "target=\"_blank\">", "</a>"));
//        List<String> level= Arrays.asList(StringUtils.substringsBetween(response, "<td class=\"td-01 ranktop\">", "</td>"));
        String WBhotMessage="";
        for(int i=0;i<content.size();i++){
            WBhotMessage=WBhotMessage+content.get(i)+"<br>";
        }
        return WBhotMessage;
    }
}
