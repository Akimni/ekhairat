package ekhairat;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class KhairatmemberHandler
 */
@WebServlet("/KhairatmemberHandler")
public class KhairatmemberHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private khairatDao rd;
	public void init(){
		rd = new khairatDao();
	}
	
    /**
     * Default constructor. 
     */
    public KhairatmemberHandler() {
    	super();
    	rd =new khairatDao();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	/*HttpSession session = request.getSession();
    	session.removeAttribute("membername");
    	session.invalidate();
    	response.sendRedirect("index.jsp");*/
    	
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
			case "createKhairatstaff": 
				createKhairatstaff(request,response);
			break;
			/*case "deleteKhairatmember":
				deleteKhairatmember(request,response;)
			break;*/
			case "updateKhairatmember":
				updateKhairatmember(request,response);
				break;/*
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
        response.sendRedirect("index.jsp");
    }
	
	private void createKhairatstaff(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

		String staffName = request.getParameter("staffName");
		String staffID = request.getParameter("staffID");
		String staffContactNo = request.getParameter("staffContactNo");
		String staffAddress = request.getParameter("staffAddress");
		String staffEmail = request.getParameter("staffEmail");
		String staffPassword = request.getParameter("staffPassword");

		Khairatstaff sta = new Khairatstaff();

		sta.setstaffName(staffName);
		sta.setstaffID(staffID);
		sta.setstaffContactNo(staffContactNo);
		sta.setstaffAddress(staffAddress);
		sta.setstaffEmail(staffEmail);
		sta.setstaffPassword(staffPassword);

        rd.createKhairatstaff(sta);
        response.sendRedirect("staff.index.jsp");
    }

	private void updateKhairatmember(HttpServletRequest request, HttpServletResponse response)
        throws SQLException, IOException {
		
		HttpSession session = request.getSession();
		String memberNAME = request.getParameter("name");
		String memberID = request.getParameter("id");
		String memberCONTACTNO = request.getParameter("contact");
		String memberADDRESS = request.getParameter("address");
		String memberEMAIL = request.getParameter("email");
		String memberPASSWORD = request.getParameter("password");
		Khairatmember mem = new Khairatmember();
		
		mem.setmemberName(memberNAME);
		mem.setmemberID(memberID);
		mem.setmemberContactNo(memberCONTACTNO);
		mem.setmemberAddress(memberADDRESS);
		mem.setmemberEmail(memberEMAIL);
		mem.setmemberPassword(memberPASSWORD);
		rd.updateKhairatmember(mem);
		
		session.removeAttribute("name");
		session.removeAttribute("id");
		session.removeAttribute("contact");
		session.removeAttribute("address");
		session.removeAttribute("email");
		session.removeAttribute("password");
		
		session.setAttribute("name", memberNAME);
		session.setAttribute("id", memberID);
		session.setAttribute("contact", memberCONTACTNO);
		session.setAttribute("address" , memberADDRESS);
		session.setAttribute("email" , memberEMAIL);
		session.setAttribute("password", memberPASSWORD);
		
		response.sendRedirect("AKAUN_PENGGUNA.jsp");
		
		
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
