package com.commerce.employeeservice.models;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@Table(value = "emp")
public class Employee {
    @PrimaryKey
    private int emp_id;
    @NonNull
    @Column(value = "emp_name")
    private String emp_name;
    @NonNull
    @Column(value = "emp_city")
    private String emp_city;
    @NonNull
    @Column(value = "emp_phone")
    private String emp_phone;
}
