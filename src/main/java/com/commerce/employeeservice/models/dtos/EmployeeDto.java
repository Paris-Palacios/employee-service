package com.commerce.employeeservice.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    @JsonProperty("emp_id")
    private int emp_id;
    @JsonProperty("emp_name")
    private String emp_name;
    @JsonProperty("emp_city")
    private String emp_city;
    @JsonProperty("emp_phone")
    private String emp_phone;
    @JsonProperty("java_exp")
    private Double java_exp;
    @JsonProperty("spring_exp")
    private Double spring_exp;
}
