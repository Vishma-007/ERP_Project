package com.ust.Spring_Reactive.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    public String accountNum;
    public String IFSCcode;
    public String bankName;
    public String branch;
    public double amount;
}
