package com;

import java.util.ArrayList;

public class LocationRepository {

    private Database database;

    public LocationRepository(Database db) {

        this.database = db;
    }

    public Location Get(int id) {
        for (int i = 0; i < database.locations.size(); i++) {
            if (database.locations.get(i).getId() == id) {
                return database.locations.get(i);
            }
        }
        return null;
    }

    public ArrayList<Location> GetAll() {
        return database.locations;
    }

}