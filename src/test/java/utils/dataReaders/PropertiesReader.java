package utils.dataReaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    public static Properties pathsData;

    static {
        try {
            pathsData = loadProperties(System.getProperty("user.dir")+"//src//main//resources//paths.properties");
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred"+ e.getMessage());
        }
    }


    private static Properties loadProperties(String path) throws FileNotFoundException {
        Properties pro = new Properties();
        FileInputStream fis = new FileInputStream(path);
        try {
            pro.load(fis);
        } catch (IOException e) {
            System.out.println("Error occurred"+ e.getMessage());
        }
            return pro;
    }
}
