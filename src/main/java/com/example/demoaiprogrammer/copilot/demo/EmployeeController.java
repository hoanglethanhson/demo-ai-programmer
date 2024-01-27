package com.example.demoaiprogrammer.copilot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    // Add Employee api
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    //get Employee by id api get method
    @GetMapping("/getEmployee/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return service.getEmployee(id);
    }

    //update Employee api with put method
    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return service.updateEmployee(employee);
    }

    //delete Employee api with delete method
    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }

}
