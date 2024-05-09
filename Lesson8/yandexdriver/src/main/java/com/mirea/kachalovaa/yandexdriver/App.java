package com.mirea.kachalovaa.yandexdriver;

import android.app.Application;

import com.yandex.mapkit.MapKitFactory;

public class App extends Application {
    private final String MAPKIT_API_KEY = "171bb6a2-9a86-4afe-8cab-7ff2b8f95aef";

    @Override
    public void onCreate() {
        super.onCreate();

        // Set the api key before calling initialize on MapKitFactory.
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
    }
}
