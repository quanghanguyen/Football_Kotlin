package com.example.football_kotlin.BL.ModelBL

data class BLChartModel(
    val competition: Competition,
    val filters: Filters,
    val season: SeasonX,
    val standings: List<Standing>
)