package com.example.demo.model;

import java.time.LocalDate;

public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private LocalDate kaishi; 
    private LocalDate shuryo; 

    public Employee() {}

    public Employee(Integer id, String name, Integer age, LocalDate kaishi, LocalDate shuryo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.kaishi = kaishi;
        this.shuryo = shuryo;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public LocalDate getKaishi() { return kaishi; }
    public void setKaishi(LocalDate kaishi) { this.kaishi = kaishi; }

    public LocalDate getShuryo() { return shuryo; }
    public void setShuryo(LocalDate shuryo) { this.shuryo = shuryo; }
}
