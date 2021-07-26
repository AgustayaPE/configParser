package com.configparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.google.gson.Gson;


class CustomParser implements Parser {

    private boolean flag;

    @Override
    public String getFileName() {
        final String SAMPLE_CSV_FILE_PATH = "/Users/agustayachaturvedi/Documents/configparser/src/main/java/com/configparser/source.csv";
        return SAMPLE_CSV_FILE_PATH;
        
    }

    @Override
    public boolean readCSVFile(String SAMPLE_CSV_FILE_PATH) {
        File file = new File(SAMPLE_CSV_FILE_PATH);
        if(file!=null)
        return true;
        else
        return false;

        
    }

    @Override
    public boolean validateCSVFile(String SAMPLE_CSV_FILE_PATH) throws FileNotFoundException{
        File file = new File(SAMPLE_CSV_FILE_PATH);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] values = line.split(",");
            if(values[0]==null || values[1]==null || values[2]==null || values[3]==null) {
                System.out.println("Data inconsistent");
                flag = false;
                return false;
            } 

        }
        if(flag==true)
        return true;
        else
        return false;

        
    }

    @Override
    public void processCSVFile(String SAMPLE_CSV_FILE_PATH) throws FileNotFoundException {
        File file = new File(SAMPLE_CSV_FILE_PATH);
        Scanner scanner = new Scanner(file);
        Gson gson = new Gson();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] values = line.split(",");
            String jsonCartList = gson.toJson(values);
            System.out.println(jsonCartList);

        }
        
        
    }


}