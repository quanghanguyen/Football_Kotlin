package com.example.football_kotlin.BL.ModelBL

data class ModelMain(
    val area: Area,
    val code: String,
    val currentSeason: CurrentSeason,
    val emblemUrl: String,
    val id: Int,
    val lastUpdated: String,
    val name: String,
    val plan: String,
    val seasons: List<Season>
)