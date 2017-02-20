package com.wqstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Thinkpad on 2017/1/10.
 */
public class LoginInteceptor implements HandlerInterceptor {

    @Override public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                       Object o) throws Exception {

        HttpSession session = httpServletRequest.getSession();
        String loginUser = (String) session.getAttribute("username");
        String url = httpServletRequest.getRequestURI();  
        if(url.indexOf("login.do")>=0){  
            return true;  
        }  
        if (loginUser == null) {
            httpServletResponse.sendRedirect("/wqStore/admin/login.do");
            return false;
        }
        return true;
    }

    @Override public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                     Object o, ModelAndView modelAndView) throws Exception {


    }

    @Override public void afterCompletion(HttpServletRequest httpServletRequest,
                                          HttpServletResponse httpServletResponse, Object o, Exception e)
            throws Exception {

    }

}
