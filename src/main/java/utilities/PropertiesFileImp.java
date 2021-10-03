package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertiesFileImp {

    private PropertiesFileImp() {
    }

    private static Properties prop = new Properties();
    private static final HashMap<String, String> CONFIGMAP = new HashMap<>();

    //defining the properties file load in static block so that it can be initialized once
    static {
        try {
            File f = new File(System.getProperty("user.dir") + "/src/main/resources/config/config.properties");
            FileInputStream fis = new FileInputStream(f);
            prop.load(fis);

            // Creating Hashmap, relevant when properties file is read multiple times and needs to be faster then the normal hashtable approach
            for (Map.Entry<Object, Object> entry : prop.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
            }

            //prop.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
        } catch (IOException e) {
            System.out.println("Properties file couldn't be found" + e.getMessage());
        }

    }

    public static String getDataFromPropertyFile(String key) {
        try {
            if (Objects.isNull(CONFIGMAP.get(key))) {
                System.out.println("Specified Key -> '" + key + "' is not found");
            }
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception caught " + e.getMessage());
        }
        return CONFIGMAP.get(key);
    }

    /* //Reading from properties file with hashtable concept which is thread safe but slower
    public static String getDataFromPropertyFile(String key) {
        try{
            if(Objects.isNull(prop.getProperty(key))){
                System.out.println("Specified Key -> '" +key + "' is not found");
            }
        }catch (NullPointerException e){
            System.out.println("Null Pointer Exception caught " + e.getMessage());
        }
        return prop.getProperty(key);
    }
     */
}
