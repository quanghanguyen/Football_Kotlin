package com.example.football_kotlin.L1.InterfaceL1

import com.example.football_kotlin.L1.ModelL1.ModelL1Main
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface MainAPIL1 {

     // https://api.football-data.org/v2/competitions/2015

    @get:GET("v2/competitions/2015")
    @get:Headers("X-Auth-Token: 161d94ea5ccd478596a33f51876bd457")
    val allL1MainData : Call<ModelL1Main>

}