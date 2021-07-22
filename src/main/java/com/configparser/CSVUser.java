package com.configparser;

import com.opencsv.bean.CsvBindByName;

public class CSVUser {
    @CsvBindByName
    private String name;

    @CsvBindByName(column = "email", required = true)
    private String email;

    @CsvBindByName(column = "phone")
    private String phoneNo;

    @CsvBindByName
    private String country;

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public String getCountry() {
        return this.country;
    }

}
