package com.organisation.bazar.utils

import com.organisation.bazar.data.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

  val instance: ApiInterface by lazy {
    val retrofit =
      Retrofit.Builder()
        .baseUrl(RetrofitUtils.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    retrofit.create(ApiInterface::class.java)
  }
}
