package com.bridgelabz;

import java.io.File;
import java.io.IOException;

public class FileOperation {
    public static void main(String[] args) {
        String filePath = "src/file1.txt";
        checkIfExists(filePath);
        deleteFile(filePath);

        String folderPath = "src/directory";

        createDirectory(folderPath);
        createEmptyFile(filePath);
    }

    public static void checkIfExists(String filePath){
        try {
            File file = new File(filePath);
            if (file.exists()) {
                System.out.println("File exists.");
            } else {
                System.out.println("File does not exist.");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void deleteFile(String filePath){
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File '" + filePath + "' deleted.");
            } else {
                System.out.println("Failed to delete file " + filePath);
            }
        } else {
            System.out.println("File named " + filePath + " does not exist.");
        }
    }

    public static void createDirectory(String folderPath) {
        File directory = new File(folderPath);
        if (directory.mkdirs()) {
            System.out.println("Directory " + folderPath + " created.");
        } else {
            System.out.println("Failed to create directory " + folderPath + ".");
        }
    }

    private static void createEmptyFile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println("Empty file '" + filePath + "' created.");
            } else {
                System.out.println("Failed to create empty file '" + filePath + "'.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }
}
