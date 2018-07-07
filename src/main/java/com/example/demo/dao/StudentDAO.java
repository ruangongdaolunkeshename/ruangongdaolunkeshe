package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.UUID;

/**
* @description 
* @author Tim Lin
* @create 2018-07-01 
**/
@Mapper
public interface StudentDAO {
    @Select(value="SELECT * FROM student")
    List<Student> getAllStudent();

    @Insert(value="INSERT INTO student(student.`password`,student.`username`,student.`sex`,student.`name`,student.`birthday`,student.`address`,student.`telephone`,student.`people`,student.`branch`,student.`committee`,student.`flat`)\n" + "VALUE(#{password},#{username},#{sex},#{name},#{birthday},#{address},#{telephone},#{people},#{branch},#{committee},#{flat})")
    int insert(Student student);

    @Select(value="SELECT * FROM student WHERE student.username=#{username}")
    Student search(String username);

    @Select(value="SELECT student.flat FROM student WHERE student.username=#{username}")
    Integer searchflat(String username);

    @Delete(value="DELETE FROM student WHERE student.username=#{username}")
    void delete(String username);

}
