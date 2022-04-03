package com.example.football_kotlin.BL.InterfaceBL

import com.example.football_kotlin.BL.ModelBL.BLChartModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ChartBL {

    // https://api.football-data.org/v2/competitions/2002/standings?standingType=HOME

    @get:GET("v2/competitions/2002/standings?standingType=HOME")
    @get:Headers("X-Auth-Token: 161d94ea5ccd478596a33f51876bd457")
    val getBLChartData : Call<BLChartModel>

}