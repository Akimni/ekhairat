package ekhairat;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewIndexController
 */
@WebServlet("/AkaunHAndler")
public class AkaunHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AkaunHandler() {
        super();
       new registrationDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int memberid = Integer.parseInt(request.getParameter("memberid"));
		request.setAttribute("i", registrationDao.getKhairatmemberBymemberID(memberid));
		RequestDispatcher view = request.getRequestDispatcher("AKAUN_PENGGUNA.jsp");
		view.forward(request, response); 
	}

}