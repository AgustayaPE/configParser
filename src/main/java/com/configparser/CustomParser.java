package com.configparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CustomParser {

    private static final String SAMPLE_CSV_FILE_PATH = "/Users/agustayachaturvedi/Documents/configparser/src/main/java/com/configparser/source.csv";

    // Custom parser
    void CustomParser(int m) {
        try {
            File file = new File(SAMPLE_CSV_FILE_PATH);

            Scanner scanner = new Scanner(file);

            int counter = 0;

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                System.out.println("Name : " + values[0]);
                System.out.println("Email : " + values[1]);
                System.out.println("PhoneNo : " + values[2]);
                System.out.println("Country : " + values[3]);
                System.out.println("-----------------------------------");
                counter += 1;
                if (counter >= m)
                    break;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found. Check path.");
            e.printStackTrace();
        }
    }
}
