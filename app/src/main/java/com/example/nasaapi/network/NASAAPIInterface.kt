package com.example.nasaapi.network

import com.example.nasaapi.model.NasaResponse
import retrofit2.http.GET

const val API_KEY = "akQ3RaGztAMyzlHPkgVeURad4yZzyotmNSCsMV1K"

interface NASAAPIInterface {
    @GET("apod?api_key=$API_KEY")
    suspend fun getDailyPhoto() : NasaResponse
}