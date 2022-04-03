package com.example.football_kotlin.BL.ModelBL

data class Table(
    val draw: Int,
    val form: Any,
    val goalDifference: Int,
    val goalsAgainst: Int,
    val goalsFor: Int,
    val lost: Int,
    val playedGames: Int,
    val points: Int,
    val position: Int,
    val team: Team,
    val won: Int
)