package com.configparser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

class ThirdPartyParser implements Parser {

    private boolean flag;

    @Override
    public String getFileName() {
        final String SAMPLE_CSV_FILE_PATH = "/Users/agustayachaturvedi/Documents/configparser/src/main/java/com/configparser/source.csv";
        return SAMPLE_CSV_FILE_PATH;
    }

    @Override
    public boolean readCSVFile(String SAMPLE_CSV_FILE_PATH) {
        Reader reader;
        try {
            reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        if(reader!=null)
        return true;
        else
        return false;

    }

    @Override
    public boolean validateCSVFile(String SAMPLE_CSV_FILE_PATH) throws FileNotFoundException{
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        
        CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class).withIgnoreLeadingWhiteSpace(true).build();
        Iterator<CSVUser> csvUserIterator = csvToBean.iterator();
        while(csvUserIterator.hasNext()) {
            CSVUser csvUser = csvUserIterator.next();
            if(csvUser.getName()==null || csvUser.getEmail()==null || csvUser.getPhoneNo()==null || csvUser.getCountry()==null) {
                System.out.println("Data inconsistent");
                flag = false;
            } 

        }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        flag = false;
    }
    if(flag==true)
    return true;
    else
    return false;

    }

    @Override
    public void processCSVFile(String SAMPLE_CSV_FILE_PATH) throws FileNotFoundException {
        Reader reader;
        try {
            reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        
        CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class).withIgnoreLeadingWhiteSpace(true).build();
        Iterator<CSVUser> csvUserIterator = csvToBean.iterator();
        while (csvUserIterator.hasNext()) {
            CSVUser csvUser = csvUserIterator.next();
            System.out.println("Name : " + csvUser.getName());
            System.out.println("Email : " + csvUser.getEmail());
            System.out.println("PhoneNo : " + csvUser.getPhoneNo());
            System.out.println("Country : " + csvUser.getCountry());
            System.out.println("-----------------------------------");
        }
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

        

    }


    



}