package com.example.nasaapi

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.nasaapi.model.NasaResponse
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class DailyPhotoView (private val mainView : ViewGroup) : MainView, KoinComponent, LayoutContainer{

    private val activityRetrivier : ActivityRetrivier by inject()

    override val containerView: View?
        get() = mainView

    init {
        val viewModel = ViewModelProviders.of(activityRetrivier.getActivity() as FragmentActivity)
            .get(MainViewModel::class.java)
        viewModel.view = this
        viewModel.getDailyPhoto()
    }

    override fun setDailyPhoto(dailyPhoto: NasaResponse) {
        val picasso = Picasso.get()
        picasso.load(dailyPhoto.url)
            .error(R.drawable.ic_baseline_broken_image_24)
            .into(activitymain_iv_photo)

        activitymain_tv_date.text = dailyPhoto.date
        activitymain_tv_desc.text = dailyPhoto.explanation

    }
}