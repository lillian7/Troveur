package com.makarios.app.makarios.database;


import android.content.Context;

public class DatabaseManager {
    private static DatabaseManager instance;
    private final DatabaseHelper dbHelper;

    private DatabaseManager(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public static void init(Context context) {
        if (instance == null) {
            instance = new DatabaseManager(context);
        }
    }

    public static DatabaseManager getInstance() {
        return instance;
    }

    private DatabaseHelper getDbHelper() {
        return dbHelper;
    }

}
