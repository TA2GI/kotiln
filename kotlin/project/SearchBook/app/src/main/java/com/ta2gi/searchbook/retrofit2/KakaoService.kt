package com.ta2gi.searchbook.retrofit2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface KakaoService {
    @GET("/v3/search/book")
    fun getSearchBook(
        @Header("Authorization")
        key : String,
        @Query("query")
        query : String
    ): Call<KakaoData>
}