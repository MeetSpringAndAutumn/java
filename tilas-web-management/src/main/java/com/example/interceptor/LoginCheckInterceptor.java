package com.example.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Result;
import com.example.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 生成新类/接口/枚举
 *
 * @Author: shanzhengshuai
 * @Description: login
 * @Date: 2024/10/31
 */
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwt=request.getHeader("token");
        if(!StringUtils.hasLength(jwt)){
            log.info("jwt为空");
            Result err=Result.error("NOT_LOGIN");
            String notLogin= JSONObject.toJSONString(err);
            response.getWriter().write(notLogin);
            return false;
        }
        try {
            JwtUtils.parseJwt(jwt);

        }
        catch (Exception e){
            log.info("解析jwt失败");
            Result err=Result.error("NOT_LOGIN");
            String notLogin= JSON.toJSONString(err);
            response.getWriter().write(notLogin);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
