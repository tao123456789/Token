package com.example.token.Service.AspectLogService;

import com.example.token.Entity.BO.aspectlog.AspectLogBO;
import com.example.token.Entity.VO.page.PageVo;
import com.example.token.Mapper.AspectLogMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AspectLogServiceImpl {

    @Resource
    AspectLogMapper aspectLogMapper;

    public List<AspectLogBO> getAspectLogList(int page, int size){
        int start=size*(page-1);
        int end=size*page;
        System.out.println("start:"+start+",end:"+end);
        return aspectLogMapper.getAspectLogList(start,end);
    }

    public int getAspectLogPage(PageVo pageVo){
        int page=aspectLogMapper.getAspectLogCount();
        return page;
    }
    public AspectLogBO getAspectLogInfoByUuid(String uuid){
        AspectLogBO aspectLogBO=aspectLogMapper.getAspectLogInfoByUuid(uuid);
        return aspectLogBO;
    }
}
