package com.example.kotlinrestapibasic.web.rest

import com.example.kotlinrestapibasic.dto.MovieDTO
import com.example.kotlinrestapibasic.service.MovieService
import com.example.kotlinrestapibasic.utils.excptions.ApiError
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class MovieResource(
    private val movieService: MovieService
) {



    @PostMapping
    fun createMovie(@RequestBody movieDTO: MovieDTO) : ResponseEntity<MovieDTO> {
        return ResponseEntity(movieService.createMovie(movieDTO), HttpStatus.CREATED)
    }

    @GetMapping
    fun getMovies() : ResponseEntity<List<MovieDTO>> =
        ResponseEntity(movieService.getMovies(),HttpStatus.OK)


    @GetMapping("{id}")
    fun getMovie(@PathVariable("id") id :Int) : ResponseEntity<MovieDTO> =
        ResponseEntity(movieService.getMovie(id), HttpStatus.OK)

    @PutMapping
    fun updateMovie(@RequestBody movieDTO: MovieDTO): ResponseEntity<MovieDTO> =
        ResponseEntity(movieService.updateMovie(movieDTO),HttpStatus.OK)

    @DeleteMapping("{id}")
    fun deleteMovie(@PathVariable("id") id :Int): ResponseEntity<Unit> =
        ResponseEntity(movieService.deleteMovie(id), HttpStatus.NO_CONTENT)

}