package com.example.javaweb1.controller;

import com.example.javaweb1.pojo.Emp;
import com.example.javaweb1.pojo.Result;
import com.example.javaweb1.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list() {

        List<Emp> emps = empService.listEmp();

        return Result.success(emps);
    }
}
