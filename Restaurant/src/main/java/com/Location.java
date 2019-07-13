package com;

public class Location {

    private int id;
    private String street;
    private String city;
    private String state;
    private int zipCode;

    // Getter Methods
    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }

    // Setter Methods
    public void setId( int id ) {
        this.id = id;
    }

    public void setStreet( String street ) {
        this.street = street;
    }

    public void setCity( String city ) {
        this.city = city;
    }

    public void setState( String state ) {
        this.state = state;
    }

    public void setZipCode( int zipCode ) {
        this.zipCode = zipCode;
    }
}


