package com.mb.uk.web.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties configProps;
    public static Properties getConfigProps(){
        return configProps;
    }

    /**
     * @implNote Load properties values to object
     * @throws IOException
     */
    public static void loadProps() throws IOException {
        String baseProjectPath=System.getProperty("user.dir");
        configProps=new Properties();
        configProps.load(new FileReader(new File(baseProjectPath.concat("/src/main/resources/config/env.properties"))));
    }
}
