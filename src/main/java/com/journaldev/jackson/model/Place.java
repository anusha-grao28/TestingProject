package com.journaldev.jackson.model;

public class Place {
    private String place_name;
    private String longitude;
    private String state;
    private String state_abbreviation;
    private String latitude;

    public Place(String place_name, String longitude, String state, String state_abbreviation, String latitude) {
        this.place_name = place_name;
        this.longitude = longitude;
        this.state = state;
        this.state_abbreviation = state_abbreviation;
        this.latitude = latitude;
    }

    public Place() {
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState_abbreviation() {
        return state_abbreviation;
    }

    public void setState_abbreviation(String state_abbreviation) {
        this.state_abbreviation = state_abbreviation;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Place{" +
                "place_name='" + place_name + '\'' +
                ", longitude='" + longitude + '\'' +
                ", state='" + state + '\'' +
                ", state_abbreviation='" + state_abbreviation + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }

}

