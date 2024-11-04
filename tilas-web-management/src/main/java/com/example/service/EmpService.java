package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface EmpService {

    PageBean page(Integer page, Integer pageSize,String name,
                  Short gender,
                  LocalDate begin,
                   LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp getEmpById(Integer id);

    void update(Emp emp);

    Emp login(String username, String password);
}
