package com.bridgelabz;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayroll = new EmployeePayrollService(employeePayrollList);
        employeePayroll.readEmployeePayrollDetails(scanner);
        employeePayroll.writeEmployeePayrollData();
    }
}