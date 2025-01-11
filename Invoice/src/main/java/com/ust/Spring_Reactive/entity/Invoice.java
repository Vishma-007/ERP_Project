package com.ust.Spring_Reactive.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "project")
public class Invoice {
    @Id
    public String id;
    public String ponum;
    public String companyName;
    public String companyAddress;
    public String clientName;
    public String clientAddress;
    public List<Bank> bankDetails;
    public List<Item> itemDetails;
    public LocalDate invoiceDate;
    public LocalDate dueDate;
    public double totalAmount;
    public String status;


}
