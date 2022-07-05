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
	private AkaunDao AkaunDAO;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AkaunHandler() {
       this.AkaunDAO=new AkaunDao();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
		}
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getServletPath();
		switch (action) {
		case "/view":
			Khairatmember(request, response);
		default:
			break;
		}		
		}

		/*private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("AKAUN_PENGGUNA.jsp");
		dispatcher.forward(request,response);
		}*/
		
		private void Khairatmember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher dispatcher =request.getRequestDispatcher("AKAUN_PENGGUNA.jsp");
			dispatcher.forward(request, response);
			
		}
		/*
		int memberid = Integer.parseInt(request.getParameter("memberid"));
		request.setAttribute("i", registrationDao.getKhairatmemberBymemberID(memberid));
		RequestDispatcher view = request.getRequestDispatcher("AKAUN_PENGGUNA.jsp");
		view.forward(request, response); 
	}*/
    
    

}