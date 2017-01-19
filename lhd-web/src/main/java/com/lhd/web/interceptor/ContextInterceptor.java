package com.lhd.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ContextInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

        String uri = request.getRequestURI();
        request.setAttribute("uri", uri);
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex)
            throws Exception {

    }


}