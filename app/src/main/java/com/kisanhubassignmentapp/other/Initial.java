package com.kisanhubassignmentapp.other;

import android.app.Application;

/**
 * Created by Prajakta on 27-09-2018.
 */

public class Initial extends Application {

    private static Initial mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized Initial getInstance() {
        return mInstance;
    }

}
