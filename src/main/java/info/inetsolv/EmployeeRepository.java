package info.inetsolv;

import org.springframework.data.jpa.repository.JpaRepository;

import info.inetsolv.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
