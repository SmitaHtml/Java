package com;

import java.util.ArrayList;

public class RestaurantRepository {

    private Database database;

    public RestaurantRepository(Database db) {
        this.database = db;
    }

    public Restaurant Get(int id) {
        for (int i = 0; i < database.restaurants.size(); i++) {
            if (database.restaurants.get(i).getId() == id) {
                return database.restaurants.get(i);
            }
        }
        return null;
    }

    public ArrayList<Restaurant> GetAll() {
        return database.restaurants;
    }
}