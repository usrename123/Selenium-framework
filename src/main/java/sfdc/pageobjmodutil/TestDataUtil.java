package sfdc.pageobjmodutil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDataUtil {

	public static String readPropertiesFile(String filePath, String key) {
	    String value = null;
	    System.out.println("Reading properties file from " + filePath);
	    Properties properties = new Properties();

	    try (InputStream inputStream = new FileInputStream(filePath)) {
	        properties.load(inputStream);  // Load first
	        value = properties.getProperty(key);  // Then read value
	        System.out.println("Value of the key '" + key + "' = " + value);
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return value;
	}
}
