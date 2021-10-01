package genericMethods;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {

    public static String getDataFromPropertyFile(String key) {

        String data = null;
        try {
            File f = new File(System.getProperty("user.dir") + "/config.properties");
            FileInputStream fis = new FileInputStream(f);
            Properties prop = new Properties();
            prop.load(fis);
            data = (String)prop.getProperty(key);

        }catch (Exception e) {

            System.out.println("Exception while reading data from properties file " + e.getMessage());
            e.printStackTrace();

        }
        return data;
    }
}
