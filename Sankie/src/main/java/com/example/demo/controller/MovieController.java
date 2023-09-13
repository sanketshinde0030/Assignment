package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Movie;
import com.example.demo.exception.MovieNotFoundException;
import com.example.demo.service.MovieService;

@RequestMapping("/movie")

@RestController
public class MovieController {
	@Autowired MovieService service;
	
	@GetMapping(path="/listMovie")
	public List<Movie> listMovie()
	{
		
		return service.listMovie();
	}
	
	@GetMapping(path="/viewMovie/{id}")
	public Movie viewMovie(@PathVariable int id) throws MovieNotFoundException
	{
		Movie m=service.viewMovie(id);
		
		return m;
	}
	
	@PostMapping(path="createMovie")
	public Movie createMovie(@RequestBody Movie m)
	{
		return service.createMovie(m);
		
	}
	
	@PutMapping("updateMovie/{id}")
	public String updateMovie(@PathVariable int id,@RequestBody Movie m)throws MovieNotFoundException
	{
		return service.updateMovie(id,m);
		
	}
	
	@DeleteMapping(path="deleteMovie/{id}")
	public String deleteMapping(@PathVariable int id)throws MovieNotFoundException
	{
		return service.deleteMovie(id);
	}
	
	

}
