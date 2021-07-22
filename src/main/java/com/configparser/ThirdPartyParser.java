package com.configparser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class ThirdPartyParser {

    private static final String SAMPLE_CSV_FILE_PATH = "/Users/agustayachaturvedi/Documents/configparser/src/main/java/com/configparser/source.csv";

    // Third party parser
    void ThirdPartyParser(int n) throws IOException {

        try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));) {
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader).withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true).build();

            Iterator<CSVUser> csvUserIterator = csvToBean.iterator();

            int counter = 0;

            while (csvUserIterator.hasNext()) {
                CSVUser csvUser = csvUserIterator.next();
                System.out.println("Name : " + csvUser.getName());
                System.out.println("Email : " + csvUser.getEmail());
                System.out.println("PhoneNo : " + csvUser.getPhoneNo());
                System.out.println("Country : " + csvUser.getCountry());
                System.out.println("-----------------------------------");
                counter += 1;
                if (counter >= n)
                    break;
            }
        }

    }
}
