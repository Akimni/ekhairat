package ekhairat;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class KhairatmemberHandler
 */
@WebServlet("/KhairatmemberHandler")
public class KhairatmemberHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private registrationDao rd;
	public void init(){
		rd = new registrationDao();
	}
    /**
     * Default constructor. 
     */
    public KhairatmemberHandler() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "createKhairatmember": 
				createKhairatmember(request,response);
			break;
			/*case "deleteKhairatmember":
				deleteKhairatmember(request,response;)
			break;
			case "updateKahiratmember":
				updateKhairatmember(request,responses);
				break;
				case "cancel":
				 * cancel(request,response);
				 * break;*/
			
		}
		}
		catch (SQLException e) {
			throw new ServletException(e);
			}
	}
	
	private void createKhairatmember(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

		String memberName = request.getParameter("memberName");
		String memberID = request.getParameter("memberID");
		String memberContactNo = request.getParameter("memberContactNo");
		String memberAddress = request.getParameter("memberAddress");
		String memberEmail = request.getParameter("memberEmail");
		String memberPassword = request.getParameter("memberPassword");

		Khairatmember mem = new Khairatmember();

		mem.setmemberName(memberName);
		mem.setmemberID(memberID);
		mem.setmemberContactNo(memberContactNo);
		mem.setmemberAddress(memberAddress);
		mem.setmemberEmail(memberEmail);
		mem.setmemberPassword(memberPassword);

        rd.createKhairatmember(mem);
        response.sendRedirect("loginpage.jsp");
    }
}
	/*private void deleteKhairatmember(HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String memberName = request.getParameter("memberName");
		int memberContactNo = Integer.parseInt(request.getParameter("memberContactNo"));
		String memberAddress = request.getParameter("memberAddress");
		String memberEmail = request.getParameter("memberEmail");
		String memberPassword = request.getParameter("memberPassword");
		
		Member mem = new Member();
		mem.setMemberID(id);
		mem.setmemberName(memberName);
		mem.setmemberContactNo(memberContactNo);
		mem.setmemberAddress(memberAddress);
		mem.setmemberPassword(memberPassword);
		
		rd.updateMember(mem);
		
		response.sendRedirect("registrationmember.jsp");
		
	}*/
