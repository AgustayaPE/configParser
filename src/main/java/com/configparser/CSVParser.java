package com.configparser;
import java.io.IOException;
import java.util.Scanner;



public class CSVParser {
    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("Enter 1 for Third party parsing");
            System.out.println("Enter 2 for Custom parsing");
            System.out.println("To exit, enter value 9");

            System.out.println("Enter your choice: ");
            int choice = new Scanner(System.in).nextInt();

            

            switch (choice) {
                case 1:
                    System.out.println("Parsing via Third party parser.\nData output in simple format:  ");
                    String str="ParserThirdParty";
                    ParserWrapper parserwrapper = new ParserWrapper(str);
                    parserwrapper.choice();
                    break;

                case 2:
                    System.out.println("Parsing via Custom parser.\nData output in JSON format: ");
                    String strr="ParserCustom";
                    ParserWrapper parserwrapperr = new ParserWrapper(strr);
                    parserwrapperr.choice();
                    break;

                case 9:
                    String strrr="ParserExit";
                    ParserWrapper parserwrapperrr = new ParserWrapper(strrr);
                    parserwrapperrr.choice();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid input. Please try again");
            }
        }

    }
}