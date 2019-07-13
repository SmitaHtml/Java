package com;

import java.util.ArrayList;

public class RestaurantLocationCuisine {

    private int id;
    private String name;
    private Location location;
    private Cuisine cuisine;

    // Getter Methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    // Setter Methods
    public void setId( int id ) {
        this.id = id;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

}

