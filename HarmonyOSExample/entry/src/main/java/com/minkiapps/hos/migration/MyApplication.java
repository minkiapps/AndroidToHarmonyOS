package com.minkiapps.hos.migration;

import com.minkiapps.hos.migration.di.component.AppComponent;
import com.minkiapps.hos.migration.di.component.DaggerAppComponent;
import ohos.aafwk.ability.AbilityPackage;

public class MyApplication extends AbilityPackage {

    public AppComponent appComponent;

    @Override
    public void onInitialize() {
        super.onInitialize();

        appComponent = DaggerAppComponent.builder()
                .build();
    }
}
