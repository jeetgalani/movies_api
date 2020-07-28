package com.example.movies_2;

import com.example.movies_2.Movies.MovieData;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/movies")
    public MovieData getServerMessage() {
        return new MovieData("Up", "2009");
    }

    @PostMapping("/movies")
    public MovieData recieveMessage(@RequestBody MovieData movie){
        return new MovieData(movie.getTitle(), movie.getReleaseYear());
    }

}