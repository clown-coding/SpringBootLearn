package com.clown.jpa.mapper;

import com.clown.jpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EmployeeMapper extends JpaRepository<Employee,Integer>, JpaSpecificationExecutor<Employee> {

    Employee findEmployeeByLastName(String lastName);

    List<Employee> findEmployeeByDId(Integer dId);
}
