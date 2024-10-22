package com.example.javaweb1.dao.impl;

import com.example.javaweb1.dao.EmpDao;
import com.example.javaweb1.pojo.Emp;
import com.example.javaweb1.utils.XmlParserUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        System.out.println(this.getClass().getClassLoader().getResource(""));//ClassPath根下获取；
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> emps = XmlParserUtils.parse(file, Emp.class);
        return emps;
    }
}
