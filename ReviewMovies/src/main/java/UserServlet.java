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
	    urlPatterns = "/userlogin")

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

    public UserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/Login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		
		request.setAttribute("userEmail", userEmail);
		request.setAttribute("userPassword", userPassword);
		
		userDao = new UserDao();
		User user = userDao.getUserByEmailAndPassword(userEmail, userPassword);
		HashMap<String,String> userErrors = new HashMap<>();
		if(userPassword == null || userPassword.isBlank()) {
			userErrors.put("userPassword", "Please type a password");
		}if(userEmail == null || userEmail.isBlank()) {
			userErrors.put("userEmail", "Email must not be empty");
		}if(!isEmailVaild(userEmail)) {
			userErrors.put("userEmail", "email is invalid");
		}if(!userErrors.isEmpty()) {
	        request.setAttribute("userErrors", userErrors);
		    request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
		
		if(userEmail.equals("admin@gmail.com") && userPassword.equals("adminadmin")) {
			HttpSession session = request.getSession();
			session.setAttribute("adminUsername", "Admin");
			response.sendRedirect("homepage");
			return;
		}
		
	    if(user != null) {
	    	
	    	HttpSession session = request.getSession();
	        session.setAttribute("user", user);

	        response.sendRedirect("homepage");
	    } else {
	        userErrors.put("loginError", "Invalid email or password");
	        request.setAttribute("userErrors", userErrors);
	        request.getRequestDispatcher("/Login.jsp").forward(request, response);
	    }
		
	}
	private boolean isEmailVaild(String email) {
		return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
	}

}
