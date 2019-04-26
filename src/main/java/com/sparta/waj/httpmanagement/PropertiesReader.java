package com.sparta.waj.httpmanagement;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader
{
    private static final String PROP_LOC = "resources/api.properties";
    private static final String KEY_REF = "fixerioKey";
    private static final String URL_REF = "base_url_latest";
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
            apiKey = properties.getProperty(KEY_REF);
            baseUrl = properties.getProperty(URL_REF);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
