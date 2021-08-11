package com.fisglobal.employeemanagement;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

import com.fisglobal.employeemanagement.model.Employee;
import com.fisglobal.employeemanagement.repository.EmployeeRepository;

@SpringBootApplication
@EnableEurekaClient
public class EmployeemanagementApplication {

	public static void main(String[] args) {
	 ConfigurableApplicationContext context = SpringApplication.run(EmployeemanagementApplication.class, args);
		 EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
		 
			/*
			 * Employee employee1 = new Employee("H01", "Hashirama",
			 * "Senju","first@leaf.com", 10000.0f); Employee employee2 = new Employee("H02",
			 * "Madara", "Uchiha", "second@leaf.com",7000.0f); Employee employee3 = new
			 * Employee("H03", "Itachi", "Uchiha","top@uchiha.com", 8000.0f); Employee
			 * employee4 = new Employee("H04", "Hinata", "Hyuga", "byuku@leaf.com",3000.0f);
			 * Employee employee5 = new Employee("H05", "Kushina", "Uzumaki",
			 * "kushina@leaf.com",7500.0f); Employee employee6 = new Employee("H06",
			 * "Minato", "Namikaze", "minato@leaf.com",8000.0f);
			 * 
			 * employeeRepository.save(employee1); employeeRepository.save(employee2);
			 * employeeRepository.save(employee3); employeeRepository.save(employee4);
			 * employeeRepository.save(employee5); employeeRepository.save(employee6);
			 * 
			 * List<Employee> employees = employeeRepository.findAll();
			 * employees.forEach(System.out::println);
			 * 
			 * context.close();
			 */
			 
		 
	}

}
