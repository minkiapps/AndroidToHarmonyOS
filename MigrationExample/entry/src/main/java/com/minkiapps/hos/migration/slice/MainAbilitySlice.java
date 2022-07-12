package com.minkiapps.hos.migration.slice;

import butterknife.BindComponent;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.minkiapps.hos.migration.MyApplication;
import com.minkiapps.hos.migration.ResourceTable;
import com.minkiapps.hos.migration.api.ApiService;
import com.minkiapps.shared.util.Logger;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.openharmony.schedulers.OpenHarmonySchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Component;
import ohos.agp.components.Image;
import ohos.agp.components.Text;

import javax.inject.Inject;

public class MainAbilitySlice extends AbilitySlice {

    @Inject
    ApiService apiService;

    @Inject
    Logger logger;

    private Component rootComponent;

    @BindComponent(ResourceTable.Id_dv_ability_main_top_image)
    Image image;

    @BindComponent(ResourceTable.Id_t_ability_main_load_joke)
    Component loadJoke;

    @BindComponent(ResourceTable.Id_t_ability_main_joke)
    Text jokeText;

    private Disposable disposable;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        ((MyApplication)getAbility().getAbilityPackage()).appComponent.inject(this);

        super.setUIContent(ResourceTable.Layout_ability_main);
        rootComponent = findComponentById(ResourceTable.Id_dl_ability_main_root);
        ButterKnife.bind(this, rootComponent);

        Glide.with(this)
                .load("https://www.biography.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cg_face%2Cq_auto:good%2Cw_300/MTgwNTA1Mzc0MzgwNTMzMzky/gettyimages-150327735-copy.jpg")
                .into(image);

        loadJoke.setClickedListener(component -> {
            loadJoke.setEnabled(false);
            jokeText.setText("");
            jokeText.setHint("Load new joke...");

            disposable = apiService.fetchJokes()
                    .subscribeOn(Schedulers.io())
                    .observeOn(OpenHarmonySchedulers.mainThread())
                    .doOnSubscribe(disposable -> logger.d("Start to fetch joke"))
                    .subscribe(joke -> {
                        loadJoke.setEnabled(true);
                        jokeText.setText(joke.getValue());
                    }, throwable -> {
                        logger.e("Failed to fetch joke: " + throwable.getMessage() , throwable);
                        loadJoke.setEnabled(true);
                    });
        });
    }

    @Override
    protected void onActive() {
        super.onActive();
        rootComponent.requestFocus();
    }

    @Override
    protected void onStop() {
        super.onStop();
        disposable.dispose();
    }
}
