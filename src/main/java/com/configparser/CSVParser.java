package com.configparser;

import java.io.IOException;
import java.util.Scanner;

public class CSVParser {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Enter 1 for Third party parsing");
            System.out.println("Enter 2 for Custom parsing");
            System.out.println("To exit, enter value 9");

            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();

            switch(choice) {
                case 1: System.out.println("Parsing via Third party parser.\nEnter number of lines to be parsed: ");
                ThirdPartyParser tps = new ThirdPartyParser();
                tps.ThirdPartyParser(scanner.nextInt());
                break;

                case 2: System.out.println("Parsing via Custom parser.\nEnter the number of lines to be parsed: ");
                CustomParser cp = new CustomParser();
                cp.CustomParser(scanner.nextInt());
                break;

                case 9: System.out.println("Exiting the application. Thanks");
                System.exit(0);
                break;

                default: System.out.println("Invalid input. Please try again");
            }
        }
        
    }
}