package com;

import java.util.ArrayList;

public class AssociatedIdRepository {

    private Database database;

    public AssociatedIdRepository(Database db) {
        this.database = db;
    }

    public AssociatedId Get(int id) {
        for (int i = 0; i < database.associatedIds.size(); i++) {
            if (database.associatedIds.get(i).getId() == id) {
                return database.associatedIds.get(i);
            }
        }
        return null;
    }

    public ArrayList<AssociatedId> GetAll() {
        return database.associatedIds;
    }
}