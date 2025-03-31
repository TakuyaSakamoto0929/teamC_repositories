package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Employee;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> searchEmployees(Integer id, String name, Integer ageMin, Integer ageMax, 
                                          LocalDate kaishiMin, LocalDate kaishiMax, 
                                          LocalDate shuryoMin, LocalDate shuryoMax) {

        // 条件が何も指定されていない場合は全件取得
        if (id == null && (name == null || name.isEmpty()) && ageMin == null && ageMax == null 
            && kaishiMin == null && kaishiMax == null 
            && shuryoMin == null && shuryoMax == null) {
            return employeeMapper.getAllEmployees();
        }

        return employeeMapper.searchEmployees(id, name, ageMin, ageMax, kaishiMin, kaishiMax, shuryoMin, shuryoMax);
    }
}