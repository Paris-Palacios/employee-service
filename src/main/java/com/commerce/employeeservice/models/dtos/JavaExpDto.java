package com.commerce.employeeservice.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JavaExpDto {
    @JsonProperty("java_exp")
    private Double java_exp;
}
