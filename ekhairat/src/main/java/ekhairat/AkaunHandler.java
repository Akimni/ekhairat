package ekhairat;

import java.io.IOException;
import java.util.List;

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
	private AkaunDao<?> AkaunDAO;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AkaunHandler() {
       this.AkaunDAO=new AkaunDao<Object>();
       
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
		case "/new":
			showNewForm(request,response);
			break;
		case "/insert":
			break;
		case "/delete":
			break;
		case "/edit":
			break;
		case "update":
			break;
		default:
			listUser(request, response);
			break;
		}		
		}

		private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher= request.getRequestDispatcher("AKAUN_PENGGUNA.jsp");
		dispatcher.forward(request,response);
		}
		private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Khairatmember>listUser=AkaunDAO.selectAllKhairatmember();
			request.setAttribute("listUser", listUser);
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