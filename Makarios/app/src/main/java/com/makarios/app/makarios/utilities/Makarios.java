package com.makarios.app.makarios.utilities;

import android.app.Application;

import com.makarios.app.makarios.database.DatabaseManager;

public class Makarios extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseManager.init(getApplicationContext());
    }
}
