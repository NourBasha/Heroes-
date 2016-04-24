package com.example.pc.heroes1;

import android.util.Log;

import com.firebase.client.Firebase;

/**
 * Created by pc on 4/17/2016.
 */
public class HeroeApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Log.e("TAG", "inside application class");
        /* Initialize Firebase */
        Firebase.setAndroidContext(this);
    }
}
