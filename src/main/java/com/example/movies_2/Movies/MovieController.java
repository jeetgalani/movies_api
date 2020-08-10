package com.example.movies_2.Movies;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/moviedata")
public class MovieController {

    @Autowired
    MovieRepository repository;

    // Everything for Create and Read Routes

    @GetMapping
    public List<MovieData> readAllMovies() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public MovieData readMovieById(@PathVariable UUID id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public MovieData createMovie(@RequestBody MovieData movie) {
        return repository.save(movie);
    }

    //Update and Delete code
    
    @PutMapping("/{id}")
    public MovieData updateMovie(@PathVariable UUID id, @RequestBody MovieData movie) {
        MovieData movieToEdit = repository.findById(id).orElse(null);

        if(movieToEdit == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Message Data not Found.");
        
            
        }
        movieToEdit.setReleaseYear(movie.getReleaseYear());   
        return repository.save(movieToEdit); 
    }

    @DeleteMapping("/{id}") 
        public void deleteMovie(@PathVariable UUID id) {
            if(repository.existsById(id)) {
                repository.deleteById(id);
            }
        }


}