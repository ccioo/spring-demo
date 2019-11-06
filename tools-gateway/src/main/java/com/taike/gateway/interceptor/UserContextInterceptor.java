package com.taike.gateway.interceptor;

import com.google.gson.Gson;
import com.taike.gateway.vo.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserContextInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse respone, Object arg2) throws Exception {
        User user = getUser(request);
        if (user == null) {
            respone.setHeader("Content-Type", "application/json");
            String data = new Gson().toJson("无权限");
            respone.getWriter().write(data);
            respone.getWriter().flush();
            respone.getWriter().close();
            throw new PermissionException("无权限");
        }
        UserContextHolder.set(user);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse respone,
                           Object arg2, ModelAndView arg3) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse respone,
                                Object arg2, Exception arg3) throws Exception {
        UserContextHolder.shutdown();
    }

    private User getUser(HttpServletRequest request) {
        String userid = request.getHeader("x-user-id");
        String username = request.getHeader("x-user-name");
        User user = new User();
        user.setUserId(userid);
        user.setUserName(username);
        return user;
    }

    static class PermissionException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public PermissionException(String msg) {
            super(msg);
        }
    }
}
