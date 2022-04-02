package com.example.football_kotlin.PL.InterfacePL


import com.example.football_kotlin.PL.ModelPL.Standings
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface PLChart {

    // https://api.football-data.org/v2/competitions/2021/standings?standingType=HOME

    @get:GET("v2/competitions/2021/standings?standingType=HOME")
    @get:Headers("X-Auth-Token: 161d94ea5ccd478596a33f51876bd457")
    val allChartData: Call<Standings?>?

}