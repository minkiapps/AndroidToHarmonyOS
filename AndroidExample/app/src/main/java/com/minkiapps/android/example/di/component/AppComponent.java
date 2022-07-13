package com.minkiapps.android.example.di.component;

import com.minkiapps.android.example.MainActivity;
import com.minkiapps.android.example.di.modules.ApiModule;
import com.minkiapps.android.example.di.modules.AppModule;

import javax.inject.Singleton;

@Singleton
@dagger.Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {

    void inject(final MainActivity mainActivity);
}
