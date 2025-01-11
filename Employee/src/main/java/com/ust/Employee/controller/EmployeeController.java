package com.ust.Employee.controller;


import com.ust.Employee.entity.Employee;
import com.ust.Employee.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")
//@RequiredArgsConstructor
public class EmployeeController {
    @Autowired
    EmployeeServices employeeService;

    @GetMapping
    public Flux<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Employee>> getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Employee> createEmployee(@Validated @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteEmployee(@PathVariable String id) {
        return employeeService.deleteEmployee(id);
    }
}
