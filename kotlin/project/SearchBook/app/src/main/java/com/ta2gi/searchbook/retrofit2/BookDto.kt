package com.ta2gi.searchbook.retrofit2

import com.google.gson.annotations.SerializedName

data class BookDto(
    @SerializedName("thumbnail") val thumbnail : String, // 이미지
    @SerializedName("title") val title : String, // 제목
    @SerializedName("authors") val authors : ArrayList<String>, // 저자
    @SerializedName("price") val price : Int, // 정가
    @SerializedName("contents") val contents : String, // 소개
    @SerializedName("status") val status : String, // 판매 상태
    @SerializedName("url") val url : String // 상세주소
)