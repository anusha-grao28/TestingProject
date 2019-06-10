package com.journaldev.jackson.model;

import java.util.List;
import java.util.Map;

public class Country {
    private String post_code;
    private String country;
    private String country_abbreviation;
    // private Map<String, String> places;
    private List<Place> places;

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry_abbreviation() {
        return country_abbreviation;
    }

    public void setCountry_abbreviation(String country_abbreviations) {
        this.country_abbreviation = country_abbreviations;
    }

    /*public Map<String, String> getPlaces() {
        return places;
    }

    public void setPlaces(Map<String, String> places) {
        this.places = places;
    } */



    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "Country{" +
                "post_code='" + post_code + '\'' +
                ", country='" + country + '\'' +
                ", country_abbreviation='" + country_abbreviation + '\'' +
                ", places=" + places +
                '}';
    }
}

