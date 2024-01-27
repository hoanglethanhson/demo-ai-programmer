package com.example.demoaiprogrammer.copilot.demo;

import com.example.demoaiprogrammer.copilot.demo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
