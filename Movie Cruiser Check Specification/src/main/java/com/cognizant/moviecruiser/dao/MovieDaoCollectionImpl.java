package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.moviecruiser.model.Movie;

@Component
public class MovieDaoCollectionImpl implements MovieDao{

	private static List<Movie> movieList;
	public MovieDaoCollectionImpl() {
		ApplicationContext context = new ClassPathXmlApplicationContext("movies.xml");
		ArrayList<Movie> list=context.getBean("movieList", java.util.ArrayList.class);
		this.movieList=list;
		}
	
	@Override
	public List<Movie> getMovieListAdmin() {
		// TODO Auto-generated method stub
		return movieList;
	}

	@Override
	public List<Movie> getMovieListCustomer() {
		// TODO Auto-generated method stub
		List<Movie> customerMovieList = new ArrayList<Movie>();

		for (int i = 0; i < movieList.size(); i++) {
			Movie movie = movieList.get(i);
			if ((movie.getDateOfLaunch().equals(new Date()) 
					|| movie.getDateOfLaunch().before(new Date())) && movie.isActive()) {
				customerMovieList.add(movie);
			}
		}

		return customerMovieList;
	}

	@Override
	public void modifyMovie(Movie movie) {
		// TODO Auto-generated method stub
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId()==movie.getId()) {
				movieList.set(i, movie);
				break;
			}
		}
	}

	@Override
	public Movie getMovie(long movieId) {
		// TODO Auto-generated method stub
		Movie movie = null;
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movieId) {
				movie = movieList.get(i);
				break;
			}
		}
		return movie;
	}

}
