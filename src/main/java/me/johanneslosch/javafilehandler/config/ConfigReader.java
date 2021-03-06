package me.johanneslosch.javafilehandler.config;

import me.johanneslosch.javafilehandler.FileHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    /**
     * reads values from .prop(erties) file
     * @param path      path to file
     * @param filename  filename (without ending)
     * @param key       category for value
     * @return          returns value
     */
    public static String read(String path, String filename, String key) {
        Properties prop = new Properties();
        InputStream input = null;
        if (FileHelper.checkFile(path, filename, "prop")) {
            try {

                input = new FileInputStream(new File(path + "/"+ filename + "prop"));

                prop.load(input);

                prop.getProperty(key);

            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return prop.getProperty(key);
    }
}
