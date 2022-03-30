package com.example.football_kotlin.InterfacePL

import com.example.football_kotlin.ModelPL.ModelPLHome
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface MainAPI {

    // https://api.football-data.org/v2/competitions/2021

    @Headers("X-Auth-Token: 161d94ea5ccd478596a33f51876bd457")
    @GET("v2/competitions/2021")
    fun getPLDataHome(): Call<ModelPLHome>

}