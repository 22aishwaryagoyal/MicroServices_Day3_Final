package com.fisglobal.employeemanagement.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// ORM : Object with tables
// fields ===> columns
// ORM : object relational mapping.
@Entity
@Table(name = "empl")
public class Employee {

	@Id
	private String empId;
	private String empFirstName;
	private String empLastName;
	
	@Email
	@NotNull
	private String email;
	
	@NotNull
	@Positive
	@Min(value = 0, message = "Salary can't be negative")
	private float empSalary;
	
}
