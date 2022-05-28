package com.example.inclassfinalversion.service;
import com.example.inclassfinalversion.domain.response;
import com.example.inclassfinalversion.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final RestTemplate restTemplate;
    private final String url = "http://dummy.restapiexample.com/api/v1/employees";
    @Autowired
    public EmployeeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Employee> getGreaterAge(int age) {
        List<Employee> list = restTemplate.getForObject(url,response.class).getData();
        return list.stream().filter(employee -> employee.getEmployee_age()>age).collect(Collectors.toList());
    }

    @Override
    public List<List<Employee>> groupByAge() {
        List<Employee> list = restTemplate.getForObject(url,response.class).getData();

        /*
        Map<Integer,List<Employee>> map = new HashMap<>();

        for(Employee employee : list){
            if(!map.containsKey(employee.getEmployee_age())) map.put(employee.getEmployee_age(),new ArrayList<>());
            map.get(employee.getEmployee_age()).add(employee);
        }*/

        //try to do this with steam api everytime.
        Map<Integer,List<Employee>> map = list.stream().collect(Collectors.groupingBy(Employee::getEmployee_age, Collectors.toList()));
        return map.values().stream().collect(Collectors.toList());
    }
}
