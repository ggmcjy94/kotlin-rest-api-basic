package com.example.kotlinrestapibasic.service

import com.example.kotlinrestapibasic.dto.MovieDTO
import com.example.kotlinrestapibasic.repository.MovieRepository
import com.example.kotlinrestapibasic.utils.excptions.MovieException
import com.example.kotlinrestapibasic.utils.mapper.MovieMapper
import org.springframework.stereotype.Service

@Service
class MovieServiceImpl(
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) : MovieService {
    override fun createMovie(movieDTO: MovieDTO): MovieDTO {

        if (movieDTO.id != -1) {
            throw IllegalArgumentException("Id must be null or -1.")
        }
        val movie = movieRepository.save(movieMapper.toEntity(movieDTO))
        return movieMapper.fromEntity(movie)
    }

    override fun getMovies(): List<MovieDTO> {
        val movies = movieRepository.getAllMovies()

        if (movies.isEmpty()) {
            throw MovieException("List of movies is empty")
        }
        return movies.map {it -> movieMapper.fromEntity(it)}
    }

    override fun getMovie(id: Int): MovieDTO {
        return movieMapper.fromEntity(
            movieRepository
                .findById(id)
                .orElseThrow { MovieException("Movie with id $id is not present") }
        )
    }

    override fun updateMovie(movieDTO: MovieDTO): MovieDTO {
        val exists = movieRepository.existsById(movieDTO.id)
        if (!exists)
            throw  MovieException("Movie with id ${movieDTO.id} is not present")

        if (movieDTO.rating == 0.0 || movieDTO.name == "Default movie")
            throw MovieException("Cmplete movie object is expected")

        movieRepository.save(movieMapper.toEntity(movieDTO))
        return movieDTO
    }

    override fun deleteMovie(id: Int) {
        val exists = movieRepository.existsById(id)

        if (!exists)
            throw  MovieException("Movie with id $id is not present")

        movieRepository.deleteById(id)
    }


}