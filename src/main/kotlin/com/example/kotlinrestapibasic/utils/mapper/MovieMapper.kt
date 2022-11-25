package com.example.kotlinrestapibasic.utils.mapper

import com.example.kotlinrestapibasic.dto.MovieDTO
import com.example.kotlinrestapibasic.entity.Movie
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class MovieMapper: Mapper<MovieDTO, Movie> {
    override fun fromEntity(entity: Movie): MovieDTO {
        return MovieDTO(
            entity.id,
            entity.name,
            entity.rating
        )
    }

    override fun toEntity(domain: MovieDTO): Movie {
        return Movie(
            domain.id,
            domain.name,
            domain.rating
        )
    }
}