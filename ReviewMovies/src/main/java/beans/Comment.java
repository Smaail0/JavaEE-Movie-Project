package beans;

import java.text.SimpleDateFormat;

public class Comment {
	private int commentId;
	private int userId;
	private String commentText;
	private int movieId;
	private String username;

	public Comment() {

	}

	public Comment(int commentId, int userId, String commentText ,int movieId, String username) {
		this.commentId = commentId;
		this.userId = userId;
		this.commentText = commentText;
		this.username = username;
		this.movieId = movieId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public int getMovieId() {
		return movieId;
	}
	
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}


	
	
}
