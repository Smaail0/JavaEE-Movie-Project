package dao;

import java.util.List;

import beans.Movie;

public interface MovieDaoImp {

	void addMovie(Movie movie);
	List<Movie> listMovie();
	void updateMovie(Movie movie);
	void deleteMovie(int id);
	
}
