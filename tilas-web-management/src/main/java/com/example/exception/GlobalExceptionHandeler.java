package com.example.exception;

import com.example.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 生成新类/接口/枚举
 *
 * @Author: shanzhengshuai
 * @Description: 全局异常处理
 * @Date: 2024/10/31
 */

@RestControllerAdvice
public class GlobalExceptionHandeler {
    @ExceptionHandler
    public Result error(Exception e){
        e.printStackTrace();
        return Result.error("操作失败，请联系管理员");
    }
}
