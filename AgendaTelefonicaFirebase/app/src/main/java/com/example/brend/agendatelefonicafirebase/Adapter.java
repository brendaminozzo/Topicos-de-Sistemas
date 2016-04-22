package com.example.brend.agendatelefonicafirebase;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Brenda on 18/04/2016.
 */
public class Adapter extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}
