package com.example.kotlinrestapibasic.web.rest

import com.example.kotlinrestapibasic.dto.MovieDTO
import com.example.kotlinrestapibasic.service.MovieService
import com.example.kotlinrestapibasic.utils.excptions.ApiError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MovieResource(
    private val movieService: MovieService
) {



    @PostMapping("/")
    fun createMovie(@RequestBody movieDTO: MovieDTO) : ResponseEntity<MovieDTO> {
        return ResponseEntity(movieService.createMovie(movieDTO), HttpStatus.CREATED)
    }
}