package com.example.football_kotlin.PL.InterfacePL

import com.example.football_kotlin.PL.ModelPL.ModelPLHome
import com.example.football_kotlin.PL.ModelPL.TeamsDataPL
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface MainAPI {

    // https://api.football-data.org/v2/competitions/2021

//    @Headers("X-Auth-Token: 161d94ea5ccd478596a33f51876bd457")
//    @GET("v2/competitions/2021")
//    fun getPLDataHome(): Call<ModelPLHome>

    @get:GET("v2/competitions/2021")
    @get:Headers("X-Auth-Token: 161d94ea5ccd478596a33f51876bd457")
    val allMainData: Call<ModelPLHome?>?

}