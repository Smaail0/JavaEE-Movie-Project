 import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import beans.Movie;
import dao.MovieDao;

@WebServlet(
		urlPatterns = "/homepage")


public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomePageServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDao movieDao = new MovieDao();
		List<Movie> movieList = movieDao.listMovie();
		List<Movie> topMovies = movieDao.getTopMovies();
		List<Movie> classicMovies = movieDao.getClassisMovies();
		List<Movie> featureMovies = movieDao.getFeaturedMovie();
		List<Movie> newMovies = movieDao.getNewMovies();	
		
		request.setAttribute("newMovies", newMovies);
		request.setAttribute("featuredMovies", featureMovies);
		request.setAttribute("classicMovies", classicMovies);
        request.setAttribute("topMovies", topMovies);
        request.setAttribute("movieList", movieList);
        
        request.getRequestDispatcher("/Home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
