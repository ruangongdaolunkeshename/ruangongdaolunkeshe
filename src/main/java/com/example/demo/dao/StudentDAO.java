package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.UUID;

/**
* @description 
* @author Tim Lin
* @create 2018-07-01 
**/
@Mapper
public interface StudentDAO {
    public static String getusername(){
        UUID uuid=UUID.randomUUID();
        return uuid.toString().replace("-","");
    }
}
