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
public class POEntity {
    @Id
    public String id;
    public long order_num;
    public String clientName;
    public String projectid;
    public LocalDate orderDate;
    public double totalAmount;
    public LocalDate deliveryDate;
    public String status;

}
