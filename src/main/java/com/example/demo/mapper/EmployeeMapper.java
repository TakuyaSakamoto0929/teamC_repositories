package com.example.demo.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.Employee;

@Mapper
public interface EmployeeMapper {

    @Select("SELECT DISTINCT * FROM java WHERE "
            + " (id = #{id} OR #{id} IS NULL) "
            + " AND (name LIKE CONCAT('%', #{name}, '%') OR #{name} IS NULL) "
            + " AND (age BETWEEN #{ageMin} AND #{ageMax} OR #{ageMin} IS NULL OR #{ageMax} IS NULL) "
            + " AND (kaishi BETWEEN #{kaishiMin} AND #{kaishiMax} OR #{kaishiMin} IS NULL OR #{kaishiMax} IS NULL) "
            + " AND (shuryo BETWEEN #{shuryoMin} AND #{shuryoMax} OR #{shuryoMin} IS NULL OR #{shuryoMax} IS NULL)")
    List<Employee> searchEmployees(@Param("id") Integer id, 
                                   @Param("name") String name, 
                                   @Param("ageMin") Integer ageMin, 
                                   @Param("ageMax") Integer ageMax, 
                                   @Param("kaishiMin") LocalDate kaishiMin, 
                                   @Param("kaishiMax") LocalDate kaishiMax, 
                                   @Param("shuryoMin") LocalDate shuryoMin, 
                                   @Param("shuryoMax") LocalDate shuryoMax);

    @Select("SELECT * FROM java")
    List<Employee> getAllEmployees();
}