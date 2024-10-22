package com.example.service.impl;


import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    private PageBean pageBean;

    private Integer start;
    @Override
    public PageBean page(Integer page, Integer pageSize,String name,Short gender,
                         LocalDate begin,
                         LocalDate end) {
//        start=(page-1)*pageSize;
//        pageBean=new PageBean();
//        pageBean.setTotal(empMapper.count());
//        pageBean.setRows(empMapper.page(start,pageSize));
        PageHelper.startPage(page,pageSize);
        List<Emp> list=empMapper.list(name, gender, begin, end);
        Page<Emp> empPage= (Page<Emp>) list;
        pageBean=new PageBean(empPage.getTotal(),empPage.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
    empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.save(emp);
    }
}
