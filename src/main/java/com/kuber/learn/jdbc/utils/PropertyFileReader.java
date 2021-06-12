package com.kuber.learn.jdbc.utils;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyFileReader{
    private static Properties properties;
    private static Logger logger=Logger.getLogger("PropertyFileReader");
    public PropertyFileReader(){
        this.properties = new Properties();
        try
        {
            this.properties.load(new FileReader("D:/database.properties"));
        }
        catch(IOException e)
        {
            logger.log(Level.WARNING,e.getMessage());
        }
    }

    public  String  getProperty(String property)
    {
     return properties.getProperty(property);
    }
}
