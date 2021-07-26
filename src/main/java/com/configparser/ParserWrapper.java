package com.configparser;

import java.io.FileNotFoundException;
import java.io.IOException;

/*enum Parser {
    ParserCustom, ParserThirdParty, ParserExit;
}*/

public class ParserWrapper {
    String parser;
    CustomParser custom = new CustomParser();
    ThirdPartyParser third = new ThirdPartyParser();

    public ParserWrapper(String str) {
        this.parser = str;
    }

    public void choice() throws IOException {
        switch (parser) {
            case "ParserCustom":
                System.out.println("Command entered: "+parser);
                if(custom.readCSVFile(custom.getFileName()) == true);
                custom.processCSVFile(custom.getFileName());
                break;
            case "ParserThirdParty":
                System.out.println("Command entered: "+parser);
                if (third.readCSVFile(third.getFileName()) == true);
                third.processCSVFile(third.getFileName());
                break;
            case "ParserExit":
                System.out.println("Command entered: "+parser);
                System.out.println("Exiting the application. Thanks");
            default:
                break;

        }
    }

}
