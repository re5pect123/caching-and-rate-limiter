package com.example.caching.model;

public class Adress {

    private String streetNumber;

    private String streetName;

    private String city;

    private String postalCode;

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Adress(String streetNumber, String streetName, String city, String postalCode) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
    }
}
