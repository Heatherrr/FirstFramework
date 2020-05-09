package Helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertieesHelper {

    public final static PropertieesHelper INSTANCE = new PropertieesHelper();

    private Properties properties;

    private PropertieesHelper() {
        properties = new Properties();

        try {
            FileInputStream file = new FileInputStream(new File("data.properties")
            properties.load(file);
        } catch (Exception e) {
            System.out.println(("data.properties file is not found");
        }

        public synchronized String getProperty(String key) {
            String value;
            value = (String)properties.get(key);
            return value;
        }
    }

    public String getProperty(String password) {
    }
}
