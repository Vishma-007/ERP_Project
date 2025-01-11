package com.ust.Spring_Reactive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "project")
public class Project {
    @Id
    public String id;
    public String name;
    public String description;
    public LocalDate startDate;
    public LocalDate endDate;
    public double budget;
    public String status;
    public String empid;

}
