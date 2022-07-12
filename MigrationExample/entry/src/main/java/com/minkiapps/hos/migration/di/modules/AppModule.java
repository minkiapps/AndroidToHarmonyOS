package com.minkiapps.hos.migration.di.modules;

import com.minkiapps.hos.migration.util.LoggerFacade;
import com.minkiapps.shared.util.Logger;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    public static Logger providesLogger() {
        return new Logger(new LoggerFacade());
    }

}
