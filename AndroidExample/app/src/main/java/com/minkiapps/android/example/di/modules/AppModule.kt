package com.minkiapps.android.example.di.modules

import com.minkiapps.android.example.util.LoggerFacade
import com.minkiapps.shared.util.Logger
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun providesLogger(): Logger {
        return Logger(LoggerFacade())
    }
}