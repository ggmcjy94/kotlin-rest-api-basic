package com.example.kotlinrestapibasic.repository

import com.example.kotlinrestapibasic.entity.Movie
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieRepository: CrudRepository<Movie, Int> {
}