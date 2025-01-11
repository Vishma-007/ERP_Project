package com.ust.Employee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employees")
public class Employee {
    @Id
    private String id; // Changed to String for MongoDB's ObjectId
    private String name;
    private String email;
    private String position;
    private Department department;
    private Address address;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Department {

        private String id; // Changed to String for MongoDB's ObjectId
        private String name;
        private String location;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Address {

        private String id; // Changed to String for MongoDB's ObjectId
        private String street;
        private String city;
        private String zipCode;
    }
}
