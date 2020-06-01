package com.example.examplerest;

public class Customer {

	private int custNo;
    private String custName;


    public Customer() {
    }

    public Customer(int custNumber, String custName) {
        this.custNo = custNumber;
        this.custName = custName;
        
    }

    public int getCustNo() {
       return custNo;
    }

    public void setCustNo(int custNo) {
       this.custNo = custNo;
    }

    public String getCustName() {
       return custName;
    }

    public void setCustName(String custName) {
       this.custName = custName;
    }

  
}

