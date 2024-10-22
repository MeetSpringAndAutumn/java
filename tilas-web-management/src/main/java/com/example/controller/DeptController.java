package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    public Result list(){

        List<Dept> deptList=deptService.list();
        log.info("查询全部部门数据");
        return Result.success(deptList);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){

        deptService.delete(id);
        return Result.success();
    }
    @PostMapping
    public Result insert(@RequestBody Dept dept){
        deptService.insert(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Dept dept=deptService.getById(id);
        return Result.success(dept);
    }
    @PutMapping
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);
        return Result.success();
    }
}
