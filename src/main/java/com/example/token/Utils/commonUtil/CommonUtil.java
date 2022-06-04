package com.example.token.Utils.commonUtil;

import com.example.token.Entity.BO.user.UserBO;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {
    /**
     * 通过UserAgent获取登录信息
     */
    public static UserBO getLoginInfo() {
        UserBO userBO = new UserBO();
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取请求头中的User-Agent
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        userBO.setIp(request.getRemoteAddr());
        userBO.setBrower(userAgent.getBrowser().toString());
        userBO.setOs(userAgent.getOperatingSystem().toString());
        return userBO;
    }
}
