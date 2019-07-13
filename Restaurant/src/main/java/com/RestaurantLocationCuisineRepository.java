package com;

import java.io.IOException;
import java.util.ArrayList;

public class RestaurantLocationCuisineRepository {
    private Database database;

    public RestaurantLocationCuisineRepository(Database db) {
        this.database = db;
    }

    public RestaurantLocationCuisine Get(int id) {
        for (int i = 0; i < database.restaurantLocationCuisines.size(); i++) {
            if (database.restaurantLocationCuisines.get(i).getId() == id) {
                return database.restaurantLocationCuisines.get(i);
            }
        }
        return null;
    }

    public ArrayList<RestaurantLocationCuisine> GetAll() {
        return database.restaurantLocationCuisines;
    }

    public void Add(Restaurant restaurant, Location location, Cuisine cuisine) throws IOException {

        RestaurantLocationCuisine restaurantLocationCuisine = new RestaurantLocationCuisine();

        restaurantLocationCuisine.setId(restaurant.getId());
        restaurantLocationCuisine.setName(restaurant.getName());
        restaurantLocationCuisine.setLocation(location);
        restaurantLocationCuisine.setCuisine(cuisine);

        database.restaurantLocationCuisines.add(restaurantLocationCuisine);
        database.SaveChanges();
    }

}
