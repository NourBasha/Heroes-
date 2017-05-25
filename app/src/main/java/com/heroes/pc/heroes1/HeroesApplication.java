package com.heroes.pc.heroes1;

import com.firebase.client.Firebase;

/**
 * Created by pc on 4/17/2016.
 */
public class HeroesApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
