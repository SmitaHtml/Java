package com;

import java.util.ArrayList;

public class CuisineRepository {

    private Database database;

    public CuisineRepository(Database db) {
        this.database = db;
    }

    public Cuisine Get(int id) {
        for (int i = 0; i < database.cuisines.size(); i++) {
            if (database.cuisines.get(i).getId() == id) {
                return database.cuisines.get(i);
            }
        }
        return null;
    }

    public ArrayList<Cuisine> GetAll() {
        return database.cuisines;
    }
}