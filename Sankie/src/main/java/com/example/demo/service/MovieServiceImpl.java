package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Movie;
import com.example.demo.exception.MovieNotFoundException;
import com.example.demo.repository.MovieRepository;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {
@Autowired MovieRepository repo;
	@Override
	public Movie createMovie(Movie m) {
		// TODO Auto-generated method stub
		return repo.save(m);
		
		
	}

	@Override
	public String updateMovie(int id,Movie m) throws MovieNotFoundException {
		Movie em;
		if(repo.findById(id).isPresent())
			em=repo.findById(id).get();
		else
			throw new MovieNotFoundException("Movie record with id "+id+" not present in record");
		if(m.getDirectorName()!=null)
		em.setDirectorName(m.getDirectorName());
		if(m.getDuration()!=0)
		em.setDuration(m.getDuration());
		if(m.getMovieName()!=null)
		em.setMovieName(m.getMovieName());
		if(m.getReleaseYear()!=0 )
		em.setReleaseYear(m.getReleaseYear());
		em.setId(id);
		repo.save(em);
		
		
		return "Movie details updated successfully with id: "+em.getId();
	}

	@Override
	public List<Movie> listMovie() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public String deleteMovie(int id)throws MovieNotFoundException {

		try{repo.deleteById(id);}
		catch(Exception e)
		{
		throw new MovieNotFoundException("Cannot delete Movie with this id:"+id);
		}
		
		return "Movie got deleted successfully. ";
	
	}

	@Override
	public Movie viewMovie(int id) throws MovieNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Movie> m=repo.findById(id);
		if(m.isPresent())
		{
			return m.get();
		}
		else
			throw new MovieNotFoundException("Movie not found for id:"+id);
	}

}
