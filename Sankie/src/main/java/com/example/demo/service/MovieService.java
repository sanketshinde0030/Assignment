package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Movie;
import com.example.demo.exception.MovieNotFoundException;

public interface MovieService {
	public Movie createMovie(Movie m);
	
    public String updateMovie(int id,Movie m)throws MovieNotFoundException;
    
    public List<Movie> listMovie();
    
    public String deleteMovie(int id)throws MovieNotFoundException;
    
    public Movie viewMovie(int id) throws MovieNotFoundException;
}
