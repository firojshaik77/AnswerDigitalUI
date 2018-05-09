package org.testng.propertymgr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Purpose: Defines a helper class for loading property files.
 * @author Firoj Shaik
 *
 */
public class PropertyManager {

    private final Properties property;

    /**
     * Constructor for PropertyManager.
     */
    public PropertyManager() {
        property = new Properties();
    }

    /**
     * Method for loading property file.
     * @param propertyToLoad
     * @return Properties
     */
    public Properties loadPropertyFile(String propertyToLoad) {
        try {
            property.load(new FileInputStream(new File(System
                    .getProperty("user.dir")
                    + "\\src\\test\\java\\org\\properties\\"
                    + propertyToLoad)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }
}
