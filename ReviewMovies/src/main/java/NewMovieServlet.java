import java.io.IOException;

import beans.Movie;
import dao.MovieDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(
		urlPatterns ="/addNewMovie")

public class NewMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NewMovieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("adminUsername") != null ) {
			request.getRequestDispatcher("/AddMovie.jsp").forward(request, response);}
		else {
			request.getRequestDispatcher("userlogin").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("adminUsername") != null) {
		
		String title = request.getParameter("title");
		String releaseYear = request.getParameter("year");
		String genre = request.getParameter("genre");
		String director = request.getParameter("director");
		String description = request.getParameter("description");
		String rating = request.getParameter("rating");
		String poster = request.getParameter("poster");
		String image = request.getParameter("widescreen");
		
		int year = Integer.valueOf(releaseYear);
		float rate = Float.valueOf(rating);
		
			MovieDao movieDao = new MovieDao();
			Movie movie = new Movie(title, year, genre, director, description, rate, poster, image);
			movieDao.addMovie(movie);
				response.sendRedirect("homepage");
		}else {
	        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Unauthorized access");

		}
	}
}