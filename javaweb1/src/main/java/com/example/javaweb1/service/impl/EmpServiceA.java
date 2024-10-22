package com.example.javaweb1.service.impl;

import com.example.javaweb1.dao.EmpDao;
import com.example.javaweb1.pojo.Emp;
import com.example.javaweb1.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceA implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        List<Emp> emps = empDao.listEmp();
        for (Emp emp :
                emps) {
            if (emp.getGender().equals("1")) {
                emp.setGender("男");
            } else if (emp.getGender().equals("2")) {
                emp.setGender("女");
            }

            if (emp.getJob().equals("1")) {
                emp.setJob("讲师");
            } else if (emp.getJob().equals("2")) {
                emp.setJob("主任");
            } else if (emp.getJob().equals("3")) {
                emp.setJob("就业指导");
            }
        }
        return emps;
    }
}
