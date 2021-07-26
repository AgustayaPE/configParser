package com.configparser;

import java.io.FileNotFoundException;

public interface Parser {
    String getFileName();
    public boolean readCSVFile(String SAMPLE_CSV_FILE_PATH);
    public boolean validateCSVFile(String SAMPLE_CSV_FILE_PATH) throws FileNotFoundException ;
    public void processCSVFile(String SAMPLE_CSV_FILE_PATH) throws FileNotFoundException ;
}
