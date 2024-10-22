package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name,
                       Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {

        PageBean pageBean = empService.page(page, pageSize,name,gender,begin,end);
        log.info(pageBean.getTotal() + "" + pageBean.getRows());
        return Result.success(pageBean);
    }
    /*
     批量删除员工
     */
@DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除员工，id：{}",ids);
        empService.delete(ids);
        return Result.success();
}
@PostMapping
    public Result save(@RequestBody Emp emp){
    log.info("新增员工，员工信息：{}",emp);
    empService.save(emp);
    return Result.success();
}

}
