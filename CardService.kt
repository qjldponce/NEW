package com.example.labact6_supplementary

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CardService {
    @GET("v2/list")

    fun getCardData():
            Call<List<CardAttributes>>

}
