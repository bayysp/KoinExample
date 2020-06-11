package com.example.nasaapi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasaapi.model.NasaResponse
import com.example.nasaapi.network.NASAAPIInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

interface MainView{
    fun setDailyPhoto(dailyPhoto : NasaResponse)
}

class MainViewModel : ViewModel() , KoinComponent{
    lateinit var view : MainView
    val nasaAPIInterface : NASAAPIInterface by inject()

    fun getDailyPhoto(){
        viewModelScope.launch(Dispatchers.IO){

            val dailyPhoto = nasaAPIInterface.getDailyPhoto()
            withContext(Dispatchers.Main){
                view?.setDailyPhoto(dailyPhoto)
            }
        }
    }
}