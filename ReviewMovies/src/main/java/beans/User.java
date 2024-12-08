package beans;

public class User {
    private int userId;
    private String userEmail;
    private String userPassword;
    private String profilePicture;
    private String role;
    private String username;
    
    

    public User(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public User(String userEmail, String username, String userPassword) {
    	this.username = username;
    	this.userEmail = userEmail;
    	this.userPassword = userPassword;
    }
    
    
    public User(int userId, String userEmail, String userPassword, String profilePicture, String role,
			String username) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.profilePicture = profilePicture;
		this.role = role;
		this.username = username;
	}

	public User() {
    	
    }

    public int getId() {
        return userId;
    }

    public void setId(int id) {
        this.userId = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
