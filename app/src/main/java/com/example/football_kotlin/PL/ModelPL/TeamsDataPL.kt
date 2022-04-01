package com.example.football_kotlin.PL.ModelPL

data class TeamsDataPL(
    val competition: Competition,
    val count: Int,
    val filters: Filters,
    val season: SeasonX,
    val teams: List<Team>
)