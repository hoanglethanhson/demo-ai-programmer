package com.example.demoaiprogrammer;

import com.example.demoaiprogrammer.copilot.demo.Employee;
import com.example.demoaiprogrammer.copilot.demo.EmployeeRepository;
import com.example.demoaiprogrammer.copilot.demo.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class EmployeeServiceTest {
    //generate unit test for addEmployee method in EmployeeService class
    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    @Test
    public void testAddEmployee() {
        // Create a new Employee object
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("John Doe");
        employee.setSalary(5000.0);

        // Call the addEmployee method
        service.addEmployee(employee);

        // Verify that the save method of the repository is called with the employee object
        verify(repository, times(1)).save(employee);
    }

    // generate unit test for getEmployee method in EmployeeService class
    @Test
    public void testGetEmployee() {
        // Create a new Employee object
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("John Doe");
        employee.setSalary(5000.0);

        // Mock the repository's findById method to return the employee object
        when(repository.findById(1)).thenReturn(Optional.of(employee));

        // Call the getEmployee method
        Employee result = service.getEmployee(1);

        // Verify that the findById method of the repository is called with the correct id
        verify(repository, times(1)).findById(1);

        // Verify that the returned employee object is the same as the one created
        assertEquals(employee, result);
    }

    // generate unit test for updateEmployee method in EmployeeService class

}


