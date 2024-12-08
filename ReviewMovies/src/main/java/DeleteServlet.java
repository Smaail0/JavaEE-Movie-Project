

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.MovieDao;

@WebServlet(
		urlPatterns = "/delete"
		)


public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movieId = request.getParameter("movieId");
		MovieDao movieDao = new MovieDao();
		int id = Integer.valueOf(movieId);
		HttpSession session = request.getSession();
		
		if(session.getAttribute("adminUsername") != null) {
			movieDao.deleteMovie(id);
			response.sendRedirect("homepage");
		}else {
			response.sendRedirect("homepage");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
