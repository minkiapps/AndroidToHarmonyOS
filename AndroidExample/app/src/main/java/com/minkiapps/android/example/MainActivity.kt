package com.minkiapps.android.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.minkiapps.android.example.databinding.ActivityMainBinding
import com.minkiapps.shared.CHUCK_NORRIS_IMAGE_URL
import com.minkiapps.shared.api.ApiService
import com.minkiapps.shared.util.Logger
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var logger: Logger

    private var disposable : Disposable = Disposable.disposed()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).appComponent.inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Glide.with(this)
            .load(CHUCK_NORRIS_IMAGE_URL)
            .into(binding.ivActivityMain)

        binding.tvAbilityMainLoadJoke.setOnClickListener {
            binding.tvAbilityMainLoadJoke.isEnabled = false;
            binding.tvAbilityMainJoke.apply {
                text = ""
                hint = "Load new joke..."
            }

            disposable = apiService.fetchJokes()
                .subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    logger.d("Start to fetch joke")
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ j ->
                    binding.tvAbilityMainLoadJoke.isEnabled = true
                    binding.tvAbilityMainJoke.text = j.value
                }, { e ->
                    logger.e("Failed to fetch joke: " + e.message , e)
                    binding.tvAbilityMainLoadJoke.isEnabled = true
                })
        }
    }

    override fun onStop() {
        super.onStop()
        disposable.dispose()
    }
}