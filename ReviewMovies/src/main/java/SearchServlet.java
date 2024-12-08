import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import beans.Movie;
import dao.MovieDao;

@WebServlet(
	    urlPatterns = "/search")

public class SearchServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private MovieDao movieDao;
       
    public SearchServlet() {
        super();
    }
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        movieDao = new MovieDao();
        HashMap<String, String> movieError = new HashMap<>();
        List<Movie> moviesFound = new ArrayList<>();
        String keyWord = request.getParameter("search");
        String genre = request.getParameter("genre");

        if ((keyWord == null || keyWord.isEmpty()) && (genre == null || genre.isEmpty())) {
        	response.sendRedirect("homepage");
            return;
        }

        if (genre != null && !genre.isEmpty() && !genre.equals("All") && keyWord != null && keyWord.isBlank()) {
            moviesFound.addAll(movieDao.getMovieByGenre(genre));
        } else if (genre != null && genre.equals("All") && (keyWord == null || keyWord.isEmpty())) {
            moviesFound.addAll(movieDao.listMovie());
        } else if (keyWord != null && !keyWord.isEmpty()) {
            if (genre != null && !genre.equals("All")) {
                moviesFound.addAll(movieDao.getMoviesByKeywordAndGenre(keyWord, genre));
            } else {
                moviesFound.addAll(movieDao.getMovieByKeyWord(keyWord));
            }
        }

        if (!moviesFound.isEmpty()) {
            request.setAttribute("moviesFound", moviesFound);
            request.getRequestDispatcher("SearchResult.jsp").forward(request, response);
        } else {
            movieError.put("notFound", "No movies found");
            request.setAttribute("movieError", movieError);
            request.getRequestDispatcher("SearchResult.jsp").forward(request, response);
        }
    }





	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
		
}
