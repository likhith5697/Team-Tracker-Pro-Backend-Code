package com.employee.emp.Repositeries;

import com.employee.emp.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepositery extends JpaRepository<Employee,Long> {

}
