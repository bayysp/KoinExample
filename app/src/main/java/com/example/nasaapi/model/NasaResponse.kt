package com.example.nasaapi.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NasaResponse(

	@field:Json(name = "date")
	val date: String? = null,

	@field:Json(name = "media_type")
	val mediaType: String? = null,

	@field:Json(name = "hdurl")
	val hdurl: String? = null,

	@field:Json(name = "service_version")
	val serviceVersion: String? = null,

	@field:Json(name = "explanation")
	val explanation: String? = null,

	@field:Json(name = "title")
	val title: String? = null,

	@field:Json(name = "url")
	val url: String? = null
) : Parcelable
