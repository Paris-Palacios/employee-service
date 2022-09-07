package com.commerce.employeeservice.mappers;

import com.commerce.employeeservice.models.Employee;
import com.commerce.employeeservice.models.EmployeeSkills;
import com.commerce.employeeservice.models.dtos.EmployeeDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MappersImpl implements mappers{
    @Override
    public Mono<Employee> employeeDtoToEmployee(EmployeeDto employeeDto) {
        return Mono.just(
               new Employee(employeeDto.getEmp_id(),employeeDto.getEmp_name(),
                       employeeDto.getEmp_city(),employeeDto.getEmp_phone()
                       )
        );
    }

    @Override
    public Mono<EmployeeSkills> employeeDtoToEmployeeSkills(EmployeeDto employeeDto) {
        return Mono.just(
               new EmployeeSkills(employeeDto.getEmp_id(),employeeDto.getJava_exp(),
                       employeeDto.getSpring_exp())
        );
    };
}
