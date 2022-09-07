package com.commerce.employeeservice.repository;

import com.commerce.employeeservice.models.EmployeeSkills;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface EmployeeSkillsRepository extends ReactiveCassandraRepository<EmployeeSkills,Integer> {
    @Query("select * from emp_skill where java_exp>:java_exp allow filtering;")
    Flux<EmployeeSkills> findAllByJava_expGreaterThan(@Param("java_exp") Double java_exp);
}
