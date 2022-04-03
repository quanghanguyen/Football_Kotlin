package com.example.football_kotlin.BL.ModelBL

data class BLTeamsModelX(
    val competition: CompetitionX,
    val count: Int,
    val filters: FiltersX,
    val season: SeasonXX,
    val teams: List<TeamX>
)