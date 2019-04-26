package com.sparta.waj.httpmanagement;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HTTPManager
{
    private CloseableHttpResponse fullResponse;
    private CloseableHttpClient httpClient;

    public HTTPManager()
    {
        httpClient = HttpClients.createDefault();
    }


    /**
     * shutdown releases the HTTP resources. Should be used at the end of the program.
     */
    public void shutdown()
    {
        try
        {
            fullResponse.close();
            httpClient.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    private void makeAllRatesCall()
    {

        try
        {
            HttpGet getLatestRates = new HttpGet(PropertiesReader.getBaseUrl() + "?access_key=" + PropertiesReader.getKey());
            fullResponse = httpClient.execute(getLatestRates);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private String getResponseBody()
    {
        String responseBody = null;

        try{
            responseBody = EntityUtils.toString(fullResponse.getEntity());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return responseBody;
    }


}

