import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import beans.Comment;
import beans.Movie;
import beans.User;
import dao.CommentDao;
import dao.MovieDao;


@WebServlet(urlPatterns="/film")
public class DetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String movieId = request.getParameter("movieId");
        int id = Integer.valueOf(movieId);

        MovieDao movieDao = new MovieDao();
        Movie movie = movieDao.getMovieById(id);
        request.setAttribute("movie", movie);

        CommentDao cmDao = new CommentDao();
        List<Comment> comments = cmDao.listComment(id);
        
        request.setAttribute("comments", comments);

        request.getRequestDispatcher("MovieDetails.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        User user = (User) session.getAttribute("user");

        if (user != null) {
            String comment = request.getParameter("comment");
            System.out.println(comment);
            String movieId = request.getParameter("movieId");
            System.out.println(movieId);
            int id = Integer.valueOf(movieId);
            System.out.println(id);
            CommentDao cmDao = new CommentDao();
            
            if(comment != null && !comment.isBlank()) {
            	cmDao.addComment(user.getId(), id, comment);
            }
            
            MovieDao movieDao = new MovieDao();
            Movie movie = movieDao.getMovieById(id);
            request.setAttribute("movie", movie);
            List<Comment> comments = cmDao.listComment(id);
            
            request.setAttribute("comments", comments);
            
            request.getRequestDispatcher("MovieDetails.jsp").forward(request, response);
            
        }
    }
}

	    

