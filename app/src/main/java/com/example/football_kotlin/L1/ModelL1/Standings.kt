package com.example.football_kotlin.L1.ModelL1

data class Standings(
    val competition: CompetitionX,
    val filters: FiltersX,
    val season: SeasonXX,
    val standings: List<Standing>
)