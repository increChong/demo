package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer>{

    //按年龄查询
    List<Student> findByAge(Integer age);
}
