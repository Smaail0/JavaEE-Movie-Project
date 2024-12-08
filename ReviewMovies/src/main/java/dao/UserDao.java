package dao;

import java.util.List;

import beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao implements UserDaoImp{

	private Connection conn;
	
	public UserDao() {
	    conn = DaoFactory.getConnection();
	}

	
	@Override
    public void add(User user) {
		  String sql = "INSERT INTO Users (username, password, email, role, profile_picture) VALUES (?, ?, ?, ?, ?)";
	        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, user.getUsername());
	            pstmt.setString(2, user.getUserPassword());
	            pstmt.setString(3, user.getUserEmail());
	            pstmt.setString(4, user.getRole());
	            pstmt.setString(5, user.getProfilePicture());
	            pstmt.executeUpdate();
	            System.out.println("User added successfully!");
	        } catch (SQLException e) {
	            System.err.println("Error adding user: " + e.getMessage());
	        }
    }

    @Override
    public User getById(int userId) {
    	User user = new User();
    	String sql = "SELECT * FROM Users WHERE user_id = ?";
    	try(PreparedStatement pstmt = conn.prepareStatement(sql)){
    		pstmt.setInt(1, userId);
    		ResultSet rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			user = new User();
    			user.setId(rs.getInt("user_Id"));
    			user.setUserEmail(rs.getString("email"));
    			user.setUserPassword(rs.getString("password"));
    			user.setRole(rs.getString("role"));
    		}
    	} catch (SQLException e) {
    		System.err.println("Error fetching user: " + e.getMessage());
    		e.printStackTrace();
		}
        return null;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>();
    }

    @Override
    public void update(User user) {
    }

    @Override
    public void delete(int userId) {
    }
    
    public User getUserByEmailAndPassword(String email, String password) {
    	User user = null;
    	String sql = "SELECT * FROM Users WHERE email = ? AND password = ?";
    	try(PreparedStatement pstmt = conn.prepareStatement(sql)){
    		pstmt.setString(1, email);
    		pstmt.setString(2, password);
    		ResultSet rs = pstmt.executeQuery();
                
    		while (rs.next()) {
    			user = new User();
    			user.setId(rs.getInt("user_id"));
    			user.setUsername(rs.getString("username"));
    			user.setUserEmail(rs.getString("email"));
    			user.setUserPassword(rs.getString("password"));
    			user.setRole(rs.getString("role"));
    		}
                
    	} catch (SQLException e) {
    		System.err.println("Error fetching user: " + e.getMessage());
    		e.printStackTrace();
    	}
            
    	return user;
    }
    
    public User getUserByEmailAndUsername(String email, String username) {
        User user = null;
        String sql = "SELECT * FROM Users WHERE email = ? OR username = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.setString(2, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
            	
                int userId =rs.getInt("user_id");
                String userName = rs.getString("username");
                String userEmail = rs.getString("email");
                String password = rs.getString("password");
                String role = rs.getString("role");
                String userPic = rs.getString("profile_picture");
                user = new User(userId , userEmail , userName , password , role , userPic);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching user: " + e.getMessage());
        }

        return user ;
    }


}
	
