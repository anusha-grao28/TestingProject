package com.journaldev.jackson.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Jackson_Map_From_JSON_To_Object {
    public static void main(String[] args) throws IOException {

        //read json file data to String
        byte[] jsonData = Files.readAllBytes(Paths.get("D:\\WSP2\\rest-assured-workshop\\countrys.txt"));

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //convert json string to object
        Country cou = objectMapper.readValue(jsonData, Country.class);

        System.out.println("Country Object\n"+cou);


    }
}