package com.bridgelabz;

import java.io.*;
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

    /*
    @desc: print the file line by line
    @params:
    @return:
     */
    public void printEmployeePayrollData(){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
            String line = bufferedReader.readLine();
            while(line != null){
                System.out.println(line);
                line = bufferedReader.readLine();
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    /*
    @desc: show number of entries in the file
     */
    public void showNumberOfEntries(){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH));
            int count = 0;
            while(bufferedReader.readLine() != null){
                count++;
            }
            System.out.println("Number of entries: " + count);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}