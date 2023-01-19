package com.ta2gi.searchbook.retrofit2

import com.ta2gi.searchbook.retrofit2.KakaoInfo.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val kakaoService = retrofit.create(KakaoService::class.java)
}