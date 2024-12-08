package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import beans.Movie;

public class MovieDao implements MovieDaoImp{
	
	private Connection conn;
	
	public MovieDao() {
	    conn = DaoFactory.getConnection();
	}

	@Override
	public void addMovie(Movie movie) {
		 String sql = "INSERT INTO movielist (title , release_year, genre, director, description, rating, image_path, full_image) VALUES (?,?,?,?,?,?,?,?) ";
		 try(PreparedStatement ptsmt = conn.prepareStatement(sql)){
			 ptsmt.setString(1, movie.getTitle());
			 ptsmt.setInt(2, movie.getReleaseYear());
			 ptsmt.setString(3, movie.getGenre());
			 ptsmt.setString(4,movie.getDirector());
			 ptsmt.setString(5,movie.getDescription());
			 ptsmt.setFloat(6,movie.getRating());
			 ptsmt.setString(7,movie.getMoviePath());
			 ptsmt.setString(8,movie.getFullPicture());
			 ptsmt.executeUpdate();
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Error inserting movie" + e.getMessage());
		}
	}

	@Override
	public List<Movie> listMovie() {
		List<Movie> movieList = new ArrayList<>();
		String sql = "SELECT * From movielist";
		try(Statement statement = conn.createStatement()){
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("movie_id");
				String title = rs.getString("title");
				int releaseYear = rs.getInt("release_year");
				String genre = rs.getString("genre");
				String director = rs.getString("director");
				String description = rs.getString("description");
				float rating = rs.getFloat("rating");
				String moviePath = rs.getString("image_path");
				String fullPicture = rs.getString("full_image");
				Movie movie = new Movie(id,title,releaseYear,genre,director,description,rating,moviePath,fullPicture);
				movieList.add(movie);
				
			}
			
		} catch (SQLException e) {
			System.err.println("Error listing movie: " + e.getMessage());
		}
		
		return movieList;
	}
	
	public List<Movie> getMovieByKeyWord(String keyWord) {
	    List<Movie> movies = new ArrayList<>();
	    Movie movie = new Movie();
	    String sql = "SELECT * FROM movielist WHERE LOWER(title) LIKE ? OR release_year = ?";
	    if (keyWord != null) {
	        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, "%" + keyWord.toLowerCase() + "%");
	            if (isNumeric(keyWord)) {
	            pstmt.setInt(2, Integer.parseInt(keyWord));
	            } else {
	                pstmt.setNull(2, java.sql.Types.INTEGER);
	                }
	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	                int id = rs.getInt("movie_id");
	                String title = rs.getString("title");
	                int releaseYear = rs.getInt("release_year");
	                String genre = rs.getString("genre");
	                String director = rs.getString("director");
	                String description = rs.getString("description");
	                float rating = rs.getFloat("rating");
	                String moviePath = rs.getString("image_path");
	                String fullPicture = rs.getString("full_image");
	                movie = new Movie(id, title, releaseYear, genre, director, description, rating, moviePath, fullPicture);
	                movies.add(movie);
	            }
	        } catch (SQLException e) {
	            System.err.println("Error getting movie: " + e.getMessage());
	            e.printStackTrace(); // Log the full stack trace for debugging
	        }
	    }
	    return movies;
	}


	public ArrayList<Movie> getMovieByGenre(String genre) {
		ArrayList<Movie> movies = new ArrayList<>();
	    Movie movie = new Movie();
	    String sql = "SELECT * FROM movielist WHERE CONCAT(',', genre, ',') LIKE ?";
	    
	    try {
	        PreparedStatement stat = conn.prepareStatement(sql);
	        stat.setString(1, "%" + genre + "%");
	        ResultSet rs = stat.executeQuery();
	        
	        while(rs.next()) {
	            int id = rs.getInt("movie_id");
	            String title = rs.getString("title");
	            int releaseYear = rs.getInt("release_year");
	            String genre1 = rs.getString("genre");
	            String director = rs.getString("director");
	            String description = rs.getString("description");
	            float rating = rs.getFloat("rating");
	            String moviePath = rs.getString("image_path");
	            String fullPicture = rs.getString("full_image");
	            movie = new Movie(id, title, releaseYear, genre1, director, description, rating, moviePath, fullPicture);
	            movies.add(movie);
	            System.out.println(movie.getTitle());
	        }
	    } catch (SQLException e) {
	        System.err.println("Error getting movie by error" + e.getMessage());
	    }
	    return movies;
	}

	public ArrayList<Movie> getMoviesByKeywordAndGenre(String keyword, String genre) {
	    ArrayList<Movie> movies = new ArrayList<>();
	    String sql = "SELECT * FROM movielist WHERE CONCAT(',', genre, ',') LIKE ? AND (title LIKE ? OR description LIKE ?)";
	    
	    try {
	        PreparedStatement stat = conn.prepareStatement(sql);
	        stat.setString(1, "%" + genre + "%");
	        stat.setString(2, "%" + keyword + "%");
	        stat.setString(3, "%" + keyword + "%");
	        ResultSet rs = stat.executeQuery();
	        
	        while (rs.next()) {
	            int id = rs.getInt("movie_id");
	            String title = rs.getString("title");
	            int releaseYear = rs.getInt("release_year");
	            String genre1 = rs.getString("genre");
	            String director = rs.getString("director");
	            String description = rs.getString("description");
	            float rating = rs.getFloat("rating");
	            String moviePath = rs.getString("image_path");
	            String fullPicture = rs.getString("full_image");
	            Movie movie = new Movie(id, title, releaseYear, genre1, director, description, rating, moviePath, fullPicture);
	            movies.add(movie);
	        }
	    } catch (SQLException e) {
	        System.err.println("Error getting movies by genre and keyword: " + e.getMessage());
	    }
	    
	    return movies;
	}
	
		public Movie getMovieById(int id) {
			Movie movie = new Movie();
			String sql = "SELECT * FROM movielist WHERE movie_id = ?";
			try (PreparedStatement stat = conn.prepareStatement(sql)) {
		        stat.setInt(1, id);
		        ResultSet rs = stat.executeQuery();

		        if (rs.next()) {
		            int movieId = rs.getInt("movie_id");
		            String title = rs.getString("title");
		            int releaseYear = rs.getInt("release_year");
		            String genre = rs.getString("genre");
		            String director = rs.getString("director");
		            String description = rs.getString("description");
		            int rating = rs.getInt("rating");
		            String path = rs.getString("image_path");
		            String fullPicture = rs.getString("full_image");
		            movie = new Movie(movieId, title, releaseYear, genre, director, description, rating, path, fullPicture);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return movie;
		}
		
		public List<Movie> getTopMovies(){
			Movie movie = new Movie();
			List<Movie> movies = new ArrayList<>();
			String sql = "SELECT * FROM movielist WHERE rating >= ?";
			try (PreparedStatement stat = conn.prepareStatement(sql)) {
		        stat.setDouble(1, 9);
		        ResultSet rs = stat.executeQuery();

		        while(rs.next()) {
		            int movieId = rs.getInt("movie_id");
		            String title = rs.getString("title");
		            int releaseYear = rs.getInt("release_year");
		            String genre = rs.getString("genre");
		            String director = rs.getString("director");
		            String description = rs.getString("description");
		            int rating = rs.getInt("rating");
		            String path = rs.getString("image_path");
		            String fullPicture = rs.getString("full_image");
		            movie = new Movie(movieId, title, releaseYear, genre, director, description, rating, path, fullPicture);
		            movies.add(movie);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return movies;
		}
	
		public List<Movie> getClassisMovies(){
			Movie movie = new Movie();
			List<Movie> movies = new ArrayList<>();
			String sql = "SELECT * FROM movielist WHERE release_year <= ? AND rating < ?";
			try (PreparedStatement stat = conn.prepareStatement(sql)) {
		        stat.setInt(1, 2006);
		        stat.setFloat(2, 9);
		        ResultSet rs = stat.executeQuery();

		        while(rs.next()) {
		            int movieId = rs.getInt("movie_id");
		            String title = rs.getString("title");
		            int releaseYear = rs.getInt("release_year");
		            String genre = rs.getString("genre");
		            String director = rs.getString("director");
		            String description = rs.getString("description");
		            int rating = rs.getInt("rating");
		            String path = rs.getString("image_path");
		            String fullPicture = rs.getString("full_image");
		            movie = new Movie(movieId, title, releaseYear, genre, director, description, rating, path, fullPicture);
		            movies.add(movie);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return movies;
		}
		
		public List<Movie> getFeaturedMovie(){
			List<Movie> movies = new ArrayList<>();
			Movie movie = new Movie();
			Random random = new Random();
	        Set<Integer> generatedNumbers = new HashSet<>();
	        while (generatedNumbers.size() < 8) {
	            int randomNumber = random.nextInt(20 - 1 + 1) + 1;
	            generatedNumbers.add(randomNumber);
	        }
	        for (int number : generatedNumbers) {
				String sql = "SELECT * FROM movielist WHERE movie_id = ?";
				try (PreparedStatement stat = conn.prepareStatement(sql)) {
			        stat.setInt(1, number);
			        ResultSet rs = stat.executeQuery();

			        while(rs.next()) {
			            int movieId = rs.getInt("movie_id");
			            String title = rs.getString("title");
			            int releaseYear = rs.getInt("release_year");
			            String genre = rs.getString("genre");
			            String director = rs.getString("director");
			            String description = rs.getString("description");
			            int rating = rs.getInt("rating");
			            String path = rs.getString("image_path");
			            String fullPicture = rs.getString("full_image");
			            movie = new Movie(movieId, title, releaseYear, genre, director, description, rating, path, fullPicture);
			            movies.add(movie);
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
	        }
	        
	        return movies;
	        }

		
		public List<Movie> getNewMovies(){
			Movie movie = new Movie();
			List<Movie> movies = new ArrayList<>();
			String sql = "SELECT * FROM movielist WHERE release_year >= ?";
			try (PreparedStatement stat = conn.prepareStatement(sql)) {
		        stat.setInt(1, 2023);
		        ResultSet rs = stat.executeQuery();

		        while(rs.next()) {
		            int movieId = rs.getInt("movie_id");
		            String title = rs.getString("title");
		            int releaseYear = rs.getInt("release_year");
		            String genre = rs.getString("genre");
		            String director = rs.getString("director");
		            String description = rs.getString("description");
		            int rating = rs.getInt("rating");
		            String path = rs.getString("image_path");
		            String fullPicture = rs.getString("full_image");
		            movie = new Movie(movieId, title, releaseYear, genre, director, description, rating, path, fullPicture);
		            movies.add(movie);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return movies;
		}
		
		
	@Override
	public void deleteMovie(int movieId) {
        String sql = "DELETE FROM movielist WHERE movie_id = ?";
        
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, movieId);
            int rowsDeleted = statement.executeUpdate();
            
            if (rowsDeleted > 0) {
                System.out.println("Movie with ID " + movieId + " deleted successfully.");
            } else {
                System.out.println("No movie found with ID " + movieId + ". Deletion failed.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting movie: " + e.getMessage());
        }
    }

	@Override
	public void updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		
	}
	
	public static boolean isNumeric(String str) {
	    try {
	        Integer.parseInt(str);
	        return true;
	    } catch(NumberFormatException e){
	        return false;
	    }
	}
	
}
