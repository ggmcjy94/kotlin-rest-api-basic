package com.example.kotlinrestapibasic.service

import com.example.kotlinrestapibasic.dto.MovieDTO
import com.example.kotlinrestapibasic.repository.MovieRepository
import com.example.kotlinrestapibasic.utils.mapper.MovieMapper
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) : MovieService {
    override fun createMovie(movieDTO: MovieDTO): MovieDTO {

        println("12321312: ${movieDTO.id}" )
        if (movieDTO.id != -1) {
            throw IllegalArgumentException("Id must be null or -1.")
        }

        val movie = movieMapper.toEntity(movieDTO)
        movieRepository.save(movie)
        return movieMapper.fromEntity(movie)
    }

}