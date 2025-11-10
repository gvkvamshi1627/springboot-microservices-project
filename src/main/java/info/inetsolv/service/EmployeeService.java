package info.inetsolv.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import info.inetsolv.EmployeeRepository;
import info.inetsolv.entity.Employee;
import info.inetsolv.exception.ResourceNotFoundException;

@Service
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public Employee addEmployeeData(Employee employee) {
		Employee adpEmployee = employeeRepository.save(employee);
		return adpEmployee;
	}

	public List<String> retriveAllEmployeesData() {
		List<Employee> empList = employeeRepository.findAll();
		List<String> listOfEmployees = empList.stream().map(e -> e.getEmployeeName().toUpperCase()).sorted()
				.collect(Collectors.toList());
		return listOfEmployees;
	}

	public Employee getEmployeeData(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with Id:"+id));
		return employee;
	}
}
