package com.example.kotlinrestapibasic.dto

data class MovieDTO(
    var id : Int = -1,
    var name : String = "Default movie",
    var rating : Double
)
