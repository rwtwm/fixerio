package com.sparta.waj.datamanipulation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class RatesDeserialiser
{
    public RatesDTO ratesMappedDTO;

    public RatesDeserialiser(String filePath)
    {
        ObjectMapper ratesObjectMapper = new ObjectMapper();

        try
        {
            ratesMappedDTO = ratesObjectMapper.readValue(new File(filePath), RatesDTO.class);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
