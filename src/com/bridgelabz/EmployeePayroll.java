package com.bridgelabz;

public class EmployeePayroll {
    private String id;
    private String name;
    private double salary;

    public EmployeePayroll(String id,String name,double salary){
        this.id =  id;
        this.name = name;
        this.salary = salary;
    }

    public void writeEmployeePayroll(){
        System.out.println(name + " of id " + id + " earns " + salary);
    }
}
