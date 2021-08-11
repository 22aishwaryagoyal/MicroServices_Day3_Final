package com.fisglobal.employeemanagement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisglobal.employeemanagement.exception.ResourceNotFound;
import com.fisglobal.employeemanagement.model.Employee;
import com.fisglobal.employeemanagement.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//@GETMapping : to inform that we are going to use GET method.
	//@Description: used to get all records 
	// @return : will return the data interms of json object array
	// @type : public : any one can access it.(no JWT tokens ) 
	// will help u to confirm your identity.
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllEmployees() {
		
		List<Employee> employees = employeeRepository.findAll();
		
		if(employees.size()>0) {
		return ResponseEntity.status(HttpStatus.OK).body(employees);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT)
					.body("No records found");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("id") String id) throws ResourceNotFound
	{
		Employee employee = employeeRepository.findById(id).orElseThrow(()-> 
		new ResourceNotFound("No record exists for Department having dID= " +id));
		
		return ResponseEntity.ok().body(employee);
		
//		Optional<Department> optional= departmentRepository.findById(id);
//		
//		if(optional.isPresent()) {
//			return ResponseEntity.status(HttpStatus.OK).body(optional.get());
//		}
//		else
//		{
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No record exists for Department having dID= " +id);
//		}
	}

	@PostMapping("/addDepartment")
	public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee newEmployee)
	{
		if(employeeRepository.existsById(newEmployee.getEmpId())){
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Record Exists");
		}
		Employee tempemployee = employeeRepository.save(newEmployee);
		
		System.out.println(tempemployee);
		if(tempemployee!=null) {
		 return ResponseEntity.status(HttpStatus.CREATED).body(tempemployee);
		}
		else {
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(tempemployee);
		}
	}
	

}
