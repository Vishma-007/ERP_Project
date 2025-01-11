package com.ust.Spring_Reactive.dto;

import com.ust.Spring_Reactive.entity.Bank;
import com.ust.Spring_Reactive.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {
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
