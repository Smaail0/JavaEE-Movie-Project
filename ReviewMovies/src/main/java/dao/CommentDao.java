package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import beans.Comment;


public class CommentDao {
	
	private Connection conn;
	
	public CommentDao() {
	    conn = DaoFactory.getConnection();
	}
	
	public List<Comment> listComment(int movieId){
	    String sql = "SELECT comments.comment_id, comments.user_id, comments.comment_text, users.username " +
	                 "FROM comments " +
	                 "JOIN users ON comments.user_id = users.user_id " +
	                 "WHERE comments.movie_id = ?";
	    List<Comment> comments = new ArrayList<>();
	    try(PreparedStatement statement = conn.prepareStatement(sql)){
	        statement.setInt(1, movieId);
	        ResultSet rs = statement.executeQuery();
	        
	        while(rs.next()) {
	        	int commentId = rs.getInt("comment_id");
	            int userId = rs.getInt("user_id");
	            String commentText = rs.getString("comment_text");
	            String username = rs.getString("username");

	            Comment comment = new Comment(commentId, userId, commentText, movieId, username);
	            comments.add(comment);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return comments;
	}


	public void addComment(int userId, int movieId, String comment) {
		String sql ="INSERT INTO comments(user_id,comment_text,movie_id) VALUES (?,?,?) ";
		try(PreparedStatement ptsmt = conn.prepareStatement(sql)){
	        ptsmt.setInt(1, userId);
	        ptsmt.setString(2, comment);
	        ptsmt.setInt(3, movieId);
	        ptsmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
