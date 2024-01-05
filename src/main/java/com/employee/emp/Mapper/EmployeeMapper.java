package com.employee.emp.Mapper;

import com.employee.emp.Dto.EmployeeDto;
import com.employee.emp.Entities.Employee;

public class EmployeeMapper {
    //maps employee entity to employee DTO entity
    public static EmployeeDto mapToEmployeeDto (Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getFirstName() ,
                employeeDto.getEmail()
        );
    }
}
