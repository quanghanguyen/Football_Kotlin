package com.example.football_kotlin.SA.ModelSA

data class Standings(
    val competition: CompetitionX,
    val filters: FiltersX,
    val season: SeasonXX,
    val standings: List<Standing>
)