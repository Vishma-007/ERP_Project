package com.ust.Employee.service;


import com.ust.Employee.Repository.EmployeeRepository;
import com.ust.Employee.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    public Flux<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Mono<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Employee not found")));
    }

    public Mono<Employee> createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Mono<Void> deleteEmployee(String id) {
        return employeeRepository.deleteById(id);
    }
}
