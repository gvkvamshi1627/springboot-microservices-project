package info.inetsolv.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.inetsolv.entity.Employee;
import info.inetsolv.service.EmployeeService;

@RestController
@RequestMapping("/adp")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployeeData(@RequestBody Employee adpEmployee) {
		Employee employee = employeeService.addEmployeeData(adpEmployee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);

	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<String>> getAllEmployeesList(){
		List<String> employeesData = employeeService.retriveAllEmployeesData();
		return new ResponseEntity<List<String>>(employeesData,HttpStatus.OK);
	}
	
}
