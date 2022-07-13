package com.minkiapps.hos.migration.di.component;

import com.minkiapps.hos.migration.di.modules.ApiModule;
import com.minkiapps.hos.migration.di.modules.AppModule;
import com.minkiapps.hos.migration.slice.MainAbilitySlice;

import javax.inject.Singleton;

@Singleton
@dagger.Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {

    void inject(final MainAbilitySlice mainAbilitySlice);
}
