package com.practice.hello;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

public class DayofWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Calendar cal = Calendar.getInstance();
        int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
        if (dayOfWeek == 3) {
            response.getWriter().write("The website is closed on Sunday: please try acessing it" + "on any other week" +
                    " " +
                    "day!!");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("HandlerInterceptorAdapter : Spring MVC called post Handle method for " + request.getRequestURI().toString());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        System.out.println("HandlerInterceptorAdapter : Spring MVC called post Handle method for " + request.getRequestURI().toString());
    }


}
