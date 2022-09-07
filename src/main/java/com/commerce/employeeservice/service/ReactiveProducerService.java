package com.commerce.employeeservice.service;

import com.commerce.employeeservice.models.dtos.EmployeeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReactiveProducerService {

    @Autowired
    private ReactiveKafkaProducerTemplate<Integer, EmployeeDto> ReactivekafkaTemplate;

    public void send(EmployeeDto employeeDto) {
        ReactivekafkaTemplate.send("app_updates",employeeDto.getEmp_id() ,employeeDto).subscribe();
    }
}
