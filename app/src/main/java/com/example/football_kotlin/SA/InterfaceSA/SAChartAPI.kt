package com.example.football_kotlin.SA.InterfaceSA

import com.example.football_kotlin.SA.ModelSA.Standings
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface SAChartAPI {

    // https://api.football-data.org/v2/competitions/2019/standings?standingType=HOME

    @get:GET("v2/competitions/2019/standings?standingType=HOME")
    @get:Headers("X-Auth-Token: 161d94ea5ccd478596a33f51876bd457")

    val getSAChartData : Call<Standings>

}