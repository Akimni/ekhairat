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
	
	private registrationDao rd;
	public void init(){
		rd = new registrationDao();
	}
	
	private updateDao ud;
	public void onit() {
		ud = new updateDao();
	}
    /**
     * Default constructor. 
     */
    public KhairatmemberHandler() {
    	super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	session.removeAttribute("membername");
    	session.invalidate();
    	response.sendRedirect("index.jsp");
    	
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
		String membername = request.getParameter("membername");
		String memberid = request.getParameter("memberid");
		String membercontactno = request.getParameter("membercontactno");
		String memberaddress = request.getParameter("memberaddress");
		String memberemail = request.getParameter("memberemail");
		String memberpassword = request.getParameter("memberpassword");
		Khairatmember mem = new Khairatmember();
		
		mem.setmemberID(memberid);
		mem.setmemberName(membername);
		mem.setmemberContactNo(membercontactno);
		mem.setmemberAddress(memberaddress);
		mem.setmemberEmail(memberemail);
		mem.setmemberPassword(memberpassword);
		ud.updateKhairatmember(mem);
		
		session.removeAttribute("membername");
		session.removeAttribute("memberid");
		session.removeAttribute("membercontactno");
		session.removeAttribute("memberaddress");
		session.removeAttribute("memberemail");
		session.removeAttribute("memberpassword");
		
		session.setAttribute("membername", membername);
		session.setAttribute("memberid", memberid);
		session.setAttribute("membercontactno", membercontactno);
		session.setAttribute("memberaddress" , memberaddress);
		session.setAttribute("memberpassword", memberpassword);
		
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
