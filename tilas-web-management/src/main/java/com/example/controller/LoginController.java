package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.Result;
import com.example.service.EmpService;
import com.example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 生成新类/接口/枚举
 *
 * @Author: 13674
 * @Description: 登录
 * @Date: 2024/10/24
 */

@Slf4j
@RestController
public class LoginController {
    @Autowired
    EmpService empService;
    @PostMapping("/login")
    public Result login(@RequestBody Emp e){
        log.info  ("登录，用户名：{}", e.getUsername());
        Emp emp= empService.login(e.getUsername(), e.getPassword());
        if (emp != null) {
            Map<String, Object> claims=new HashMap<>();
            claims.put("id",emp.getId());
            claims.put("name",emp.getName());
            claims.put("username",emp.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }

}
