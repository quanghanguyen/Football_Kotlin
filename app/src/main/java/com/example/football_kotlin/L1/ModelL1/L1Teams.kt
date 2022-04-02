package com.example.football_kotlin.L1.ModelL1

data class L1Teams(
    val competition: Competition,
    val count: Int,
    val filters: Filters,
    val season: SeasonX,
    val teams: List<Team>
)