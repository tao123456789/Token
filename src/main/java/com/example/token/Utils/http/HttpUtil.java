package com.example.token.Utils.http;

import com.example.token.Entity.BO.user.UserBO;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class HttpUtil {
    /**
     * 通过HttpServletRequest返回IP地址
     *
     * @param request HttpServletRequest
     * @return ip String
     * @throws Exception
     */
    public static String getIpAddr(HttpServletRequest request) {
//        System.out.println("x-forwarded-for:"+request.getHeader("x-forwarded-for"));
//        System.out.println("Proxy-Client-IP:"+request.getHeader("Proxy-Client-IP"));
//        System.out.println("WL-Proxy-Client-IP:"+request.getHeader("WL-Proxy-Client-IP"));
//        System.out.println("HTTP_CLIENT_IP:"+request.getHeader("HTTP_CLIENT_IP"));
//        System.out.println("HTTP_X_FORWARDED_FOR:"+request.getHeader("HTTP_X_FORWARDED_FOR"));
//        System.out.println("RemoteAddr:"+request.getRemoteAddr());
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if ("127.0.0.1".equals(ip) || "127.0.0.1".equals(ip)) {
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                    ip = inet.getHostAddress();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        }
        return ip;
    }
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
