package com.ust.Employee.Repository;

//import com.ust.EmpService.entity.Employee;
import com.ust.Employee.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {
}
