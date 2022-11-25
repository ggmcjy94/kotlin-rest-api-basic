package com.example.kotlinrestapibasic.service

import com.example.kotlinrestapibasic.dto.MovieDTO
import com.example.kotlinrestapibasic.entity.Movie

interface MovieService {

    fun createMovie(movieDTO: MovieDTO): MovieDTO
}