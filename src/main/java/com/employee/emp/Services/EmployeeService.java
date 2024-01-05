package com.employee.emp.Services;

import com.employee.emp.Dto.EmployeeDto;
import com.employee.emp.Entities.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployees();

    void deleteEmployee(Long employeeId);
}
