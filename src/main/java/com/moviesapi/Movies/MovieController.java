package com.moviesapi.Movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> allMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable ObjectId id){
        return new ResponseEntity<>(movieService.getMovieById(id), HttpStatus.OK);
    }

    @GetMapping("/imdb/{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovieByImdbId(@PathVariable String imdbId){
        return new ResponseEntity<>(movieService.getMovieByImdbId(imdbId), HttpStatus.OK);
    }
}
