package com.example.football_kotlin.SA.ModelSA

data class SATeamsModel(
    val competition: Competition,
    val count: Int,
    val filters: Filters,
    val season: SeasonX,
    val teams: List<Team>
)