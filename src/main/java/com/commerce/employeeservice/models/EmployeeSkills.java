package com.commerce.employeeservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@AllArgsConstructor
@Table(value = "emp_skill")
public class EmployeeSkills {
    @PrimaryKeyColumn(
            name = "emp_id",
            ordinal = 0,
            type = PrimaryKeyType.PARTITIONED)
    private int emp_id;
    @PrimaryKeyColumn(
            name = "java_exp",
            ordinal = 1,
            type = PrimaryKeyType.PARTITIONED)
    private Double java_exp;
    @PrimaryKeyColumn(
            name = "spring_exp",
            ordinal = 2,
            type = PrimaryKeyType.PARTITIONED)
    private Double spring_exp;
}
