package com.moviehouse.movieservice.controllers;

import com.moviehouse.movieservice.models.Movie;
import com.moviehouse.movieservice.exception.BadCredentialsException;
import com.moviehouse.movieservice.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MovieController {
    @Autowired
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @CrossOrigin
    @GetMapping("/popular/{page}")
    public Page<Movie> getPopular(@PathVariable int page,@RequestHeader("Authorization") String token) throws BadCredentialsException{

        if(movieService.tokenIsValid(token)){
            return movieService.fetchPopular(page);
        }

        Page p = Page.empty();
        return p;
    }
    @CrossOrigin
    @GetMapping("/{id}")
    public Optional<Movie> getMovie(@PathVariable long id,@RequestHeader("Authorization") String token) throws BadCredentialsException {
        if(movieService.tokenIsValid(token)){
           return movieService.fetchMovie(id);
        }
        return Optional.empty();
    }

//    @PostMapping("/loadmovies")
//    public ResponseEntity loadMovies(@RequestBody Movie[] movies){
//        movieService.pushMovies(movies);
//        return ResponseEntity.ok().build();
//    }
}
