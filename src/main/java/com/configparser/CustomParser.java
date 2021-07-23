package com.configparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import com.google.gson.Gson;


class CustomParser implements Parser {

    @Override
    public String getFileName() {
        final String SAMPLE_CSV_FILE_PATH = "/Users/agustayachaturvedi/Documents/configparser/src/main/java/com/configparser/source.csv";
        return SAMPLE_CSV_FILE_PATH;
        
    }

    @Override
    public Scanner readCSVFilee(String SAMPLE_CSV_FILE_PATH) throws FileNotFoundException {
        File file = new File(SAMPLE_CSV_FILE_PATH);
        Scanner scanner = new Scanner(file);
        return scanner;
        
    }

    @Override
    public boolean validateCSVFile(Scanner scanner) {
        int flag=0;
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] values = line.split(",");
            if(values[0]==null || values[1]==null || values[2]==null || values[3]==null) {
                System.out.println("Data inconsistent");
                flag = 1;
                return false;
            } 

        }
        if(flag==0)
        return true;
        else
        return false;

        
    }

    @Override
    public void processCSVFile(Scanner scanner) {
        Gson gson = new Gson();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] values = line.split(",");
            String jsonCartList = gson.toJson(values);
            System.out.println(jsonCartList);

        }
        
        
    }

    @Override
    public Iterator<CSVUser> readCSVFile(String SAMPLE_CSV_FILE_PATH) throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean validateCSVFile(Iterator<CSVUser> csvUserIterator) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void processCSVFile(Iterator<CSVUser> csvUserIterator) {
        // TODO Auto-generated method stub
        
    }


}