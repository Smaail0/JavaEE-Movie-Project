package beans;

public class Movie {
	
	private int movieId;
	private String title;
	private int releaseYear;
	private String genre;
	private String director;
	private String description;
	private float rating;
	private String moviePath;
	private String fullPicture;
	
	
	
	public Movie() {
	}

	public Movie(int id, String title, int releaseYear, String genre, String director, String description,
			float rating, String moviePath, String fullPicture) {
		
		this.movieId = id;
		this.title = title;
		this.releaseYear = releaseYear;
		this.genre = genre;
		this.director = director;
		this.description = description;
		this.rating = rating;
		this.moviePath = moviePath;
		this.fullPicture = fullPicture;
		
	}

	public Movie(String title2, int releaseYear, String genre, String director, String description, float rating,
			String moviePath, String image) {
		this.title = title2;
		this.releaseYear = releaseYear;
		this.genre = genre;
		this.director = director;
		this.description = description;
		this.rating = rating;
		this.moviePath = moviePath;
		this.fullPicture = image;
	}

	public String getFullPicture() {
		return fullPicture;
	}

	public void setFullPicture(String fullPicture) {
		this.fullPicture = fullPicture;
	}

	public String getMoviePath() {
		return moviePath;
	}

	public void setMoviePath(String moviePath) {
		this.moviePath = moviePath;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	
		
}
