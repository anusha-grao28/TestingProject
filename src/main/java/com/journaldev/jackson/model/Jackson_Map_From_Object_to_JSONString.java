
package com.journaldev.jackson.model;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.journaldev.jackson.model.Address;
import com.journaldev.jackson.model.Employee;


public class Jackson_Map_From_Object_to_JSONString {

    public static void main(String[] args) throws IOException {

        //read json file data to String
        // byte[] jsonData = Files.readAllBytes(Paths.get("countrys.txt"));

        //create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        //convert json string to object
        //  Country cou = objectMapper.readValue(jsonData, Country.class);

        //  System.out.println("Employee Object\n"+cou);

        //convert Object to json string
        Country cou1 = createCountry();
        //configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        //writing to console, can write to any output stream such as file
        StringWriter stringCou = new StringWriter();
        objectMapper.writeValue(stringCou, cou1);
        System.out.println("Employee JSON is\n"+stringCou.toString());
    }

    public static Country createCountry() {

        Country cou = new Country();
        cou.setPost_code("90210");
        cou.setCountry("United States");
        cou.setCountry_abbreviation("US");



        List<Place> places=createPlaces();
       /* Map<String, String> pla = new HashMap<String, String>();
        pla.put("place_name", "Beverly Hills");
        pla.put("longitude", "-118.4065");
        pla.put( "state", "California");
        pla.put("state_abbreviation", "-118.4065");
        pla.put("latitude", "34.0901"); */

        cou.setPlaces(places);

        return cou;
    }

    private static List<Place> createPlaces() {
        Place place1=new Place("Beverly Hills","-118.4065","California","-118.4065","34.0901");
        Place place2=new Place("Beverly Hills","-118.4065","California","-118.4065","34.0901");
        List<Place> placeList=Arrays.asList(place1,place2);
        return placeList;
    }

}



