package com.example.football_kotlin.BL.InterfaceBL

import com.example.football_kotlin.BL.ModelBL.BLTeamsModelX
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface TeamsBL {

    // https://api.football-data.org/v2/competitions/2002/teams

    @get:GET("v2/competitions/2002/teams")
    @get:Headers("X-Auth-Token: 161d94ea5ccd478596a33f51876bd457")
    val getBLTeamsData : Call<BLTeamsModelX>

}