package com.configparser;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Iterator;
import java.util.Scanner;

interface Parser {
    String getFileName();

    public Iterator<CSVUser> readCSVFile(String SAMPLE_CSV_FILE_PATH) throws IOException;

    public Scanner readCSVFilee(String SAMPLE_CSV_FILE_PATH) throws FileNotFoundException;

    public boolean validateCSVFile(Iterator<CSVUser> csvUserIterator);

    boolean validateCSVFile(Scanner scanner);

    public void processCSVFile(Iterator<CSVUser> csvUserIterator);

    public void processCSVFile(Scanner scanner);
}

public class CSVParser {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1 for Third party parsing");
            System.out.println("Enter 2 for Custom parsing");
            System.out.println("To exit, enter value 9");

            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();

            CustomParser custom = new CustomParser();
            ThirdPartyParser third = new ThirdPartyParser();

            switch (choice) {
                case 1:
                    System.out.println("Parsing via Third party parser.\nData output in simple format:  ");
                    if (third.validateCSVFile(third.readCSVFile(third.getFileName())) == true);
                    third.processCSVFile(third.readCSVFile(third.getFileName()));
                    break;

                case 2:
                    System.out.println("Parsing via Custom parser.\nData output in JSON format: ");
                    if(custom.validateCSVFile(custom.readCSVFilee(custom.getFileName()))==true);
                    custom.processCSVFile(custom.readCSVFilee(custom.getFileName()));
                    break;

                case 9:
                    System.out.println("Exiting the application. Thanks");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid input. Please try again");
            }
        }

    }
}