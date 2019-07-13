package com;

public class AssociatedId {

    private int id;
    private int restaurantId;
    private int locationId;
    private int cuisineId;

    public int getId() {
        return id;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public int getLocationId() {
        return locationId;
    }

    public int getCuisineId() {
        return cuisineId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRestaurantId(int rId) {
        this.id = rId;
    }

    public void setLocationId(int lId) {
        this.id = lId;
    }

    public void setCuisineId(int cId) {
        this.id = cId;
    }
}