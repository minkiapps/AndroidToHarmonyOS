package com.minkiapps.hos.migration.di.modules;

import com.minkiapps.shared.api.ApiService;
import com.minkiapps.shared.api.FactoryKt;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class ApiModule {

    @Provides
    @Singleton
    public static ApiService providesApiService() {
        return FactoryKt.createApiService();
    }
}
