package com.example.kotlinrestapibasic.service

import com.example.kotlinrestapibasic.dto.MovieDTO
import com.example.kotlinrestapibasic.entity.Movie

interface MovieService {

    fun createMovie(movieDTO: MovieDTO): MovieDTO

    fun getMovies() : List<MovieDTO>

    fun getMovie(id: Int) : MovieDTO

    fun updateMovie(movieDTO: MovieDTO) : MovieDTO

    fun deleteMovie(id: Int)
}