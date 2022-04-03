package com.example.football_kotlin.SA.ModelSA

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
    val team: TeamX,
    val won: Int
)