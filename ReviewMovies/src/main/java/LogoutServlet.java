

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import beans.Movie;
import dao.MovieDao;
import dao.UserDao;

@WebServlet(
		urlPatterns="/logout")

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LogoutServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().invalidate();
        response.sendRedirect("homepage");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
