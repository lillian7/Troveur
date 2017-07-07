package com.makarios.app.makarios.database;


import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.makarios.app.makarios.models.MyCollection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static DatabaseManager instance;
    private final DatabaseHelper dbHelper;
    private Dao<MyCollection, Integer> myCollectionDao;
    private List<MyCollection> myCollectionList = new ArrayList<>();

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

    public List<MyCollection> getCollections() {
        myCollectionDao = getDbHelper().getCollectionsIntegerDao();
        final QueryBuilder<MyCollection, Integer> qb = myCollectionDao.queryBuilder();
        myCollectionList = new ArrayList<>();
        try {
            myCollectionList = qb.orderBy("lifeStyle", true).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myCollectionList;
    }

    public void create(MyCollection collection) {
        myCollectionDao = getDbHelper().getCollectionsIntegerDao();
        final QueryBuilder<MyCollection, Integer> qb = myCollectionDao.queryBuilder();
        MyCollection mCollection;
        try {
            mCollection = qb.where()
                    .eq("id", collection.getId()).queryForFirst();
            if (mCollection == null) {
                myCollectionDao.create(collection);
            } else {
                myCollectionDao.update(collection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
