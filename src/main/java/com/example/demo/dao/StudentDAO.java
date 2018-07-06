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

    @Update(value="UPDATE student SET student.flat=#{flat} WHERE student.username=#{username}")
    int updatelevel(String username, int flat);

    @Select(value="SELECT student.password FROM student WHERE student.username=#{username}")
    String search(String username);

    @Delete(value="DELETE FROM student WHERE student.username=#{username}")
    void delete(String username);

}
