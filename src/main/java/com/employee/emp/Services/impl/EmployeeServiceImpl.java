package com.employee.emp.Services.impl;

import com.employee.emp.Dto.EmployeeDto;
import com.employee.emp.Entities.Employee;
import com.employee.emp.Exceptions.ResourceNotFoundException;
import com.employee.emp.Mapper.EmployeeMapper;
import com.employee.emp.Repositeries.EmployeeRepositery;
import com.employee.emp.Services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


//This annotation tells Spring to create a spring bean for this class
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepositery employeeRepositery;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepositery.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

       Employee employee =   employeeRepositery.findById(employeeId).orElseThrow( ()-> new ResourceNotFoundException("Employee does not exist with that Id"));
       return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee employee = employeeRepositery.findById(employeeId).orElseThrow( ()-> new ResourceNotFoundException("Employee with this Id doesn't exist"));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employeeRepositery.save(employee);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepositery.findAll();
        return employees.stream().map((employee) ->  EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepositery.findById(employeeId).orElseThrow( () -> new ResourceNotFoundException("Employee witht this id does not exist") );
        employeeRepositery.deleteById(employeeId);
    }
}
