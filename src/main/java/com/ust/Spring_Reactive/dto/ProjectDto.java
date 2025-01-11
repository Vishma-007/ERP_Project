package com.ust.Spring_Reactive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    public String id;
    public String name;
    public String description;
    public LocalDate startDate;
    public LocalDate endDate;
    public double budget;
    public String status;
    public String empid;
}
