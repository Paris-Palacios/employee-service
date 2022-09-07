package com.commerce.employeeservice.service;

import com.commerce.employeeservice.mappers.MappersImpl;
import com.commerce.employeeservice.models.Employee;
import com.commerce.employeeservice.models.EmployeeSkills;
import com.commerce.employeeservice.models.dtos.EmployeeDto;
import com.commerce.employeeservice.models.dtos.JavaExpDto;
import com.commerce.employeeservice.repository.EmployeeRepository;
import com.commerce.employeeservice.repository.EmployeeSkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeSkillsRepository employeeSkillsRepository;

    @Autowired
    ReactiveProducerService reactiveProducerService;
    @Autowired
    MappersImpl mappers;

    public Mono<Boolean> saveEmployeeAndSkillsIfExists(EmployeeDto employeeDto) {
        return checkIfEmployeeDtoExists(employeeDto)
                .flatMap(result -> {
                    if(!result) {
                     reactiveProducerService.send(employeeDto);
                     return mappers.employeeDtoToEmployee(employeeDto)
                                   .flatMap(employee -> saveEmployee(employee).then(
                                        mappers.employeeDtoToEmployeeSkills(employeeDto)
                                               .flatMap(employeeSkills -> saveEmployeeSkills(employeeSkills))
                                        )
                                   .then(Mono.just(true)));

                    }else {
                       return Mono.just(false);
                    }
                });
    }
    public Flux<EmployeeDto> matchingSkillset(JavaExpDto javaExpDto) {
       return employeeSkillsRepository.findAllByJava_expGreaterThan(javaExpDto.getJava_exp())
                .flatMap(employeeSkills -> employeeRepository.findById(employeeSkills.getEmp_id())
                        .map(employee ->  new EmployeeDto(employeeSkills.getEmp_id(),
                        employee.getEmp_name(),employee.getEmp_city(),employee.getEmp_phone(),
                                employeeSkills.getJava_exp(),employeeSkills.getSpring_exp())));

    }

    public Mono<Boolean> checkIfEmployeeDtoExists(EmployeeDto employeeDto) {
        return employeeRepository.existsById(employeeDto.getEmp_id());
    }

    public Mono<Employee> saveEmployee(Employee employee) {
        return  employeeRepository.save(employee);
    }

    public Mono<EmployeeSkills> saveEmployeeSkills(EmployeeSkills employee) {
        return  employeeSkillsRepository.save(employee);
    }
}
