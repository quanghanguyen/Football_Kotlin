package com.example.football_kotlin.PL.ModelPL

data class Standings(
    val competition: CompetitionX,
    val filters: FiltersX,
    val season: SeasonXX,
    val standings: List<Standing>,
    val message: String,
    val errorCode: String
)