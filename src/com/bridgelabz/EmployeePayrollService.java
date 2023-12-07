package com.bridgelabz;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public enum IOService{
        CONSOLE_IO,
        FILE_IO,
        DB_IO,
        REST_IO
    }

    private final String FILE_PATH = "src/employeePayroll.txt";

    private List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
        this.employeePayrollList=employeePayrollList;
    }

    public EmployeePayrollData readEmployeePayrollDetails(Scanner scanner) {
        System.out.print("Enter employee id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(id,name,salary);
        employeePayrollList.add(employeePayrollData);
        return employeePayrollData;
    }

    /*
    @desc: write in a file using fileWriter
    @params: object to e written
    @return:
     */
    public void writeEmployeePayrollData(EmployeePayrollData employeePayrollData) {
        try{
            FileWriter fileWriter = new FileWriter(FILE_PATH,true);
            fileWriter.append(String.valueOf(employeePayrollData)).append(System.lineSeparator());
            fileWriter.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("-----Writing Employee Payroll to Console---");
        System.out.println(employeePayrollList);
    }


}