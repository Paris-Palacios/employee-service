package com.commerce.employeeservice.controllers;

import com.commerce.employeeservice.models.Employee;
import com.commerce.employeeservice.models.EmployeeSkills;
import com.commerce.employeeservice.models.dtos.EmployeeDto;
import com.commerce.employeeservice.models.dtos.JavaExpDto;
import com.commerce.employeeservice.repository.EmployeeRepository;
import com.commerce.employeeservice.service.EmployeeService;
import com.commerce.employeeservice.service.ReactiveProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CreateEmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/api/createEmployee")
    public Mono<Map<String,Object>> createEmployee(@Validated @RequestBody EmployeeDto employeeDto) {
        Map<String,Object> response = new HashMap<>();

      return employeeService.saveEmployeeAndSkillsIfExists(employeeDto)
                .flatMap(result -> {
                    if(result){
                        response.put("employee",employeeDto);
                        response.put("status", "Created");
                        return Mono.just(response);
                    }else{
                        response.put("employee",employeeDto);
                        response.put("status", "Already Exists");
                        return Mono.just(response);
                    }
                });

    }

    @GetMapping("/api/findEmpSkillset")
    public Flux<EmployeeDto> findEmpSkillSet(@RequestBody JavaExpDto javaExpDto) {
        return employeeService.matchingSkillset(javaExpDto);
    }

}
