package com.example.demoaiprogrammer.copilot.demo;

import com.example.demoaiprogrammer.copilot.demo.Employee;
import com.example.demoaiprogrammer.copilot.demo.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;
    public Employee getEmployee(int id) {
        return repository.findById(id).orElse(null);
    }
    public Employee addEmployee(Employee employee) {
        Employee savedEmployee = repository.save(employee);
        log.info("Employee saved !! " + savedEmployee);
        return savedEmployee;
    }
    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
        existingEmployee.setName(employee.getName());
        existingEmployee.setSalary(employee.getSalary());
        return repository.save(existingEmployee);
    }
    public String deleteEmployee(int id) {
        repository.deleteById(id);
        return "Employee removed !! " + id;
    }

    public List<Employee> addEmployees(List<Employee> employees) {
        return repository.saveAll(employees);
    }

}
