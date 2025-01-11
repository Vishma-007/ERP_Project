package com.ust.Spring_Reactive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PODto {
    public String id;
    public long order_num;
    public String clientName;
    public String projectid;
    public LocalDate orderDate;
    public double totalAmount;
    public LocalDate deliveryDate;
    public String status;
}
