package com.example.mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select count(*) from emp")
     Long count();
    @Select("select * from emp limit #{start},#{pageSize}")
     List<Emp> page(Integer start, Integer pageSize);
//    @Select("select * from emp")
    List<Emp> list(String name,Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void save(Emp emp);

    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp where id=#{id}")
    Emp getEmpById(Integer id);

    @Update("update emp set username=#{username},password=#{password},name=#{name},gender=#{gender},image=#{image},job=#{job},entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id=#{id}")
    void update(Emp emp);

    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp where username=#{username} and password=#{password}")
    Emp getUsernameAndPassword(String username, String password);

    @Delete("delete from emp where dept_id=#{id}")
    void deleteByDeptId(Integer id);
}
