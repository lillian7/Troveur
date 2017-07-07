package com.makarios.app.makarios.database;


import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.makarios.app.makarios.models.MyCollections;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseManager {
    private static DatabaseManager instance;
    private final DatabaseHelper dbHelper;
    private Dao<MyCollections, Integer> myCollectionDao;
    private List<MyCollections> myCollectionList = new ArrayList<>();

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

    public List<MyCollections> getCollections() {
        myCollectionDao = getDbHelper().getCollectionsIntegerDao();
        final QueryBuilder<MyCollections, Integer> qb = myCollectionDao.queryBuilder();
        myCollectionList = new ArrayList<>();
        try {
            myCollectionList = qb.orderBy("lifeStyle", true).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myCollectionList;
    }
}
