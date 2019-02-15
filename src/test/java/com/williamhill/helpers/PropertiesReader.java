package com.williamhill.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    /**
     * Helper which read properties from file for specific value
     */

    public static  String readProperty(String path,String property) throws IOException {
        Properties prop = new Properties();
        FileInputStream files = new FileInputStream(path);

        prop.load(files);
        String propertyValue = prop.getProperty(property);
        return propertyValue;
    }
}
