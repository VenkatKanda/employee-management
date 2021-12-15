package com.venku.ems;

import com.venku.ems.service.EmployeeService;
import com.venku.ems.service.EmployeeServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsApplication.class, args);

		EmployeeService eService = new EmployeeServiceImpl();
		eService.addEmployee(new Employee(1,"venku","engineer",25000));
	}

}
