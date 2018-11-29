package com.newwave_preintern.leaverequestemployee;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        // support vectors
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
