package com;

import java.io.*;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Database {


    public String restaurantFilePath = "./src/main/resources/com/restaurant.json";
    public String locationFilePath = "./src/main/resources/com/location.json";
    public String cuisineFilePath = "./src/main/resources/com/cuisine.json";
    public String associatedIdsFilePath = "./src/main/resources/com/associatedId.json";

    public String restaurantLocationCuisineWriteFilePath = "./src/main/resources/com/restaurantLocationCuisine.json";

    public ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
    public ArrayList<Location> locations = new ArrayList<Location>();
    public ArrayList<Cuisine> cuisines = new ArrayList<Cuisine>();
    public ArrayList<AssociatedId> associatedIds = new ArrayList<AssociatedId>();
    public ArrayList<RestaurantLocationCuisine> restaurantLocationCuisines = new ArrayList<RestaurantLocationCuisine>();

    public Gson gson = new Gson();

    Database() throws FileNotFoundException {

        Load();
    }

    private void Load() throws FileNotFoundException {

        BufferedReader restaurantBr = new BufferedReader(
                new FileReader(restaurantFilePath));
        BufferedReader locationBr = new BufferedReader(
                new FileReader(locationFilePath));
        BufferedReader cuisineBr = new BufferedReader(
                new FileReader(cuisineFilePath));
        BufferedReader associatedIdBr = new BufferedReader(
                new FileReader(associatedIdsFilePath));

        restaurants = gson.fromJson(restaurantBr, new TypeToken<ArrayList<Restaurant>>(){}.getType());
        locations = gson.fromJson(locationBr, new TypeToken<ArrayList<Location>>(){}.getType());
        cuisines = gson.fromJson(cuisineBr, new TypeToken<ArrayList<Cuisine>>(){}.getType());
        associatedIds = gson.fromJson(associatedIdBr, new TypeToken<ArrayList<AssociatedId>>(){}.getType());
    }

    public void SaveChanges() throws IOException {

        String restaurantLocationCuisineJson = gson.toJson(restaurantLocationCuisines);
        FileWriter restaurantLocationCuisineWriter = new FileWriter(restaurantLocationCuisineWriteFilePath);
        restaurantLocationCuisineWriter.write(restaurantLocationCuisineJson);
        restaurantLocationCuisineWriter.close();

    }
}

