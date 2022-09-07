package com.commerce.employeeservice.repository;

import com.commerce.employeeservice.models.Employee;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends ReactiveCassandraRepository<Employee,Integer>  {

}
