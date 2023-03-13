package DataProviders;

import Enums.DriverType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private final Properties properties;

    public ConfigFileReader() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String propertyFilePath = "config/configuration.properties";
        try {
            fileReader = new FileReader(propertyFilePath); //Creates a new FileReader, given the name of the file to read from.
            bufferedReader = new BufferedReader(fileReader); //Reads text from a character-input stream, buffering characters to provide for the efficient reading of characters, arrays, and lines.
            properties = new Properties(); //The Properties class represents a persistent set of properties. The Properties can be saved to a stream or loaded from a stream. Each key and its corresponding value in the property list is a string.
            try {
                properties.load(bufferedReader); //Reads a property list (key and element pairs) from the input character stream in a simple line-oriented format.
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getUrl() {
        String url = properties.getProperty("url"); //properties object gives us a .getProperty method which takes the Key of the property as a parameter and return the Value of the matched key from the .properties file.
        //Simply If...Else
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the config file.");
    }

    public long getTime() {
        String timeout = properties.getProperty("timeout");
        //Common If...Else
        if (timeout != null) {
            return Long.parseLong(timeout);
        } else {
            throw new RuntimeException("timeout not specified in the config file.");
        }
    }

    public DriverType getBrowser()  {
        String browserName = properties.getProperty("browser");
        return switch (browserName) {
            case "chrome" -> DriverType.CHROME;
            case "edge" -> DriverType.EDGE;
            default ->
                    throw new RuntimeException("Browser name key value in configuration file is not matched: " + browserName);
        };
    }
}
