package com.leike.interceptors;

/**
 * @description:
 * @author: leike
 * @date: 2019-07-22 21:34
 */

import com.leike.pojo.Admin;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 会话拦截器
 */
public class SessionInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = Logger.getLogger(SessionAttributes.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object admin = request.getSession().getAttribute("SESSION_ADMIN");

        if (admin == null){
            LOGGER.warn("请不要搞事 , 请先登录");
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
        if (admin instanceof Admin){
            Admin a = (Admin) admin;
            a.setPassword(null);
            request.getSession().setAttribute("SESSION_ADMIN",a);
            LOGGER.info(a.getName()+"处于登录状态 , 可以执行操作");
            return true;
        }else {
            LOGGER.warn("请不要搞事 , 请先登录");
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
