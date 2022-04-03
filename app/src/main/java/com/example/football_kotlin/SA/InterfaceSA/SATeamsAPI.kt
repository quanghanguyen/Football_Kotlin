package com.example.football_kotlin.SA.InterfaceSA

import com.example.football_kotlin.SA.ModelSA.SATeamsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface SATeamsAPI {

    // https://api.football-data.org/v2/competitions/2019/teams

    @get:GET("v2/competitions/2019/teams")
    @get:Headers("X-Auth-Token: 161d94ea5ccd478596a33f51876bd457")

    val getSATeamsData : Call<SATeamsModel>

}