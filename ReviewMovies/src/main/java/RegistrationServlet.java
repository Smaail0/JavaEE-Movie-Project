import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import beans.Movie;
import beans.User;
import dao.MovieDao;
import dao.UserDao;

@WebServlet(
	    urlPatterns = "/registration")

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegistrationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.getRequestDispatcher("/RegisterPage.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String username = request.getParameter("username");
		
		request.setAttribute("username", username);
		request.setAttribute("email", email);
		
		
		HashMap<String,String>errors = new HashMap<>();
		if(email == null) {
			errors.put("email", "Email must not be empty");
		}if(password == null || password.isBlank()) {
			errors.put("password", "Please type a password");
		}if(confirmPassword == null || confirmPassword.isBlank()) {
			errors.put("confirmPassword", "Please confirm your password");
		}if(confirmPassword == null || !confirmPassword.equals(password)) {
			errors.put("confirmPassword", "Passwords don't match");
		}if(!isEmailVaild(email)) {
			errors.put("email", "email is invalid");
		}if(username == null || username.isBlank()) {
			errors.put("username", "Please type a username");
		}
		if(!errors.isEmpty()) {
			request.setAttribute("errors", errors);
		    request.getRequestDispatcher("/RegisterPage.jsp").forward(request, response);
		}else {
			User user = new User(email,username,password);
			user.setRole("user");
			UserDao userDao = new UserDao();
			User existingUser = userDao.getUserByEmailAndUsername(email, username);
			if (existingUser != null) {
	            errors.put("existingUser", "User with the same email or username already exists");
	            request.setAttribute("errors", errors);
	            request.getRequestDispatcher("/RegisterPage.jsp").forward(request, response);
	        } else {
	            try {
	                userDao.add(user);
	                HttpSession session = request.getSession();
	                session.setAttribute("user", user);
	                response.sendRedirect("homepage");
	                return;
	            } catch (Exception e) {
	                errors.put("databaseError", "Error adding user to the database");
	                request.setAttribute("errors", errors);
	                request.getRequestDispatcher("/RegisterPage.jsp").forward(request, response);
	            }
	        }
	    }
	}
	private static boolean isEmailVaild(String email) {
		return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
	
	}}
