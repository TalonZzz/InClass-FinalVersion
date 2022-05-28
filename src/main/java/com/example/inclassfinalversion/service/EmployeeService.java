package com.example.inclassfinalversion.service;

import com.example.inclassfinalversion.domain.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee>   getGreaterAge(int age);
    List<List<Employee>> groupByAge();
}
