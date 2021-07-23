package com.configparser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

class ThirdPartyParser implements Parser {

    @Override
    public String getFileName() {
        final String SAMPLE_CSV_FILE_PATH = "/Users/agustayachaturvedi/Documents/configparser/src/main/java/com/configparser/source.csv";
        return SAMPLE_CSV_FILE_PATH;
    }

    @Override
    public Iterator<CSVUser> readCSVFile(String SAMPLE_CSV_FILE_PATH) throws IOException {
        Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class).withIgnoreLeadingWhiteSpace(true).build();

        Iterator<CSVUser> csvUserIterator = csvToBean.iterator();

        return csvUserIterator;

    }

    @Override
    public boolean validateCSVFile(Iterator<CSVUser> csvUserIterator) {
        int flag=0;
        while(csvUserIterator.hasNext()) {
            CSVUser csvUser = csvUserIterator.next();
            if(csvUser.getName()==null || csvUser.getEmail()==null || csvUser.getPhoneNo()==null || csvUser.getCountry()==null) {
                System.out.println("Data inconsistent");
                flag = 1;
            } 

        }
        if(flag==0)
        return true;
        else
        return false;

    }

    @Override
    public void processCSVFile(Iterator<CSVUser> csvUserIterator) {
        while (csvUserIterator.hasNext()) {
            CSVUser csvUser = csvUserIterator.next();
            System.out.println("Name : " + csvUser.getName());
            System.out.println("Email : " + csvUser.getEmail());
            System.out.println("PhoneNo : " + csvUser.getPhoneNo());
            System.out.println("Country : " + csvUser.getCountry());
            System.out.println("-----------------------------------");
        }

        

    }

    

    @Override
    public Scanner readCSVFilee(String SAMPLE_CSV_FILE_PATH) throws FileNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean validateCSVFile(Scanner scanner) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void processCSVFile(Scanner scanner) {
        // TODO Auto-generated method stub
        
    }

}