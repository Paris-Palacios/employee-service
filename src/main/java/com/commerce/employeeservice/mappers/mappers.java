package com.commerce.employeeservice.mappers;

import com.commerce.employeeservice.models.Employee;
import com.commerce.employeeservice.models.EmployeeSkills;
import com.commerce.employeeservice.models.dtos.EmployeeDto;
import reactor.core.publisher.Mono;

public interface mappers {
     Mono<Employee> employeeDtoToEmployee(EmployeeDto employeeDto);
     Mono<EmployeeSkills> employeeDtoToEmployeeSkills(EmployeeDto employeeDto);
}
