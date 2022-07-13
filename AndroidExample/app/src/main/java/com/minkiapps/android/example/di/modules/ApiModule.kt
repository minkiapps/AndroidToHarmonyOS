package com.minkiapps.android.example.di.modules

import com.minkiapps.shared.api.createApiService
import javax.inject.Singleton
import com.minkiapps.shared.api.ApiService
import dagger.Module
import dagger.Provides

@Module
class ApiModule {

    @Provides
    @Singleton
    fun providesApiService(): ApiService {
        return createApiService()
    }
}