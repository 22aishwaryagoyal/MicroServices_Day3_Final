package com.fisglobal.employeemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fisglobal.employeemanagement.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
