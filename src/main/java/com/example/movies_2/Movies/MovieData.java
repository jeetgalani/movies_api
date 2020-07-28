
package com.example.movies_2.Movies;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title; 
    private String releaseYear; 

    public MovieData(){}
    
    public MovieData (String title, String releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear; 
    }

    public UUID getId() {
        return this.id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle () {
        return this.title;
    }

    
    public void setTitle (String title) {
        this.title = title;
    }

    public String getReleaseYear () {
        return this.releaseYear;
    }

    public void setReleaseYear (String releaseYear) {
        this.releaseYear = releaseYear;
    }
}