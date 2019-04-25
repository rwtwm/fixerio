package com.sparta.waj;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader
{
    private static final String PROP_LOC = "resources/api.properties";
    private static String apiKey;
    private static String baseUrl;

    private PropertiesReader() { }


    public static String getKey()
    {
        if (apiKey == null)
        {
            setUp();
        }
        return apiKey;
    }

    public static String getBaseUrl()
    {
        if (baseUrl == null)
        {
            setUp();
        }
        return baseUrl;
    }

    private static void setUp()
    {
        try
        {
            Properties properties = new Properties();
            properties.load(new FileReader(PROP_LOC));
            apiKey = properties.getProperty("fixerioKey");
            baseUrl = properties.getProperty("base_url");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
