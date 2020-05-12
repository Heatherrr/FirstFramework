package Helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesHelper {

    public final static PropertiesHelper INSTANCE = new PropertiesHelper();

    private Properties properties;

    private PropertiesHelper() {
        properties = new Properties();

        try {
            FileInputStream file = new FileInputStream(new File("data.properties"));
            properties.load(file);
        } catch (Exception e) {
            System.out.println("data.properties file is not found");
        }
    }

    public synchronized String getProperties(String key) {
        String value;
        value = (String) properties.get(key);
        return value;
    }
}

