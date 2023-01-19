package com.ta2gi.searchbook.retrofit2

import com.google.gson.annotations.SerializedName

data class KakaoData(
    @SerializedName("documents")
    var documents : List<BookDto>
)