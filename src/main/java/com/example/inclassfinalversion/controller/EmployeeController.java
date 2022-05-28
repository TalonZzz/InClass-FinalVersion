package com.example.inclassfinalversion.controller;

import com.example.inclassfinalversion.domain.Employee;
import com.example.inclassfinalversion.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employees/GetGreaterAge{age}")
    public ResponseEntity<List<Employee>> getEmployeesAgeGreater(@PathVariable int age) {
        return new ResponseEntity<>(this.employeeService.getGreaterAge(age), HttpStatus.OK);
    }

    @GetMapping(value = "/employees/GroupByAge")
    public ResponseEntity<List<List<Employee>>> groupByAge() {
        return new ResponseEntity<>(this.employeeService.groupByAge(), HttpStatus.OK);
    }

}
