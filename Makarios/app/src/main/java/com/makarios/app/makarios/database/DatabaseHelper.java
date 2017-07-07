package com.makarios.app.makarios.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.makarios.app.makarios.models.FashionLine;
import com.makarios.app.makarios.models.MyCollection;

import java.sql.SQLException;

import static com.makarios.app.makarios.models.FashionLine.TABLE_NAME_FASHION_LINE;
import static com.makarios.app.makarios.models.MyCollection.TABLE_NAME_COLLECTIONS;

class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "MakariosDataStore";
    private static final int DATABASE_VERSION = 1;
    private Dao<MyCollection, Integer> myCollectionIntegerDao;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, FashionLine.class);
            TableUtils.createTable(connectionSource, MyCollection.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_FASHION_LINE);
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_COLLECTIONS);
        onCreate(database);
    }

    public Dao<MyCollection, Integer> getCollectionsIntegerDao() {
            if (myCollectionIntegerDao == null) {
                try {
                    myCollectionIntegerDao = getDao(MyCollection.class);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return myCollectionIntegerDao;
    }
}
