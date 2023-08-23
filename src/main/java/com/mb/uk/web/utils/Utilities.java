package com.mb.uk.web.utils;

import java.io.FileWriter;

public class Utilities {

    FileWriter writer;

    /**
     * @implNote Create File Object
     */
    public void createFile() {
        try {
            String file = System.getProperty("user.dir") + "//"+ Constants.FILENAME;
            writer = new FileWriter(file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @implNote Write data to file
     * @param value
     */
    public void writeFile(String value) {
        try {
            writer.write(value+System.lineSeparator());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @implNote Close File Object
     */
    public void closeFile() {
        try {
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
