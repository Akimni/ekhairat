package ekhairat;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.sql.*;



@WebServlet("/loginmember")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberid = request.getParameter("nomborkp");
		String memberpassword = request.getParameter("pass");
		
		//Create session
		HttpSession session = request.getSession();
		
		//request dispatcher
		RequestDispatcher dispatcher = null;
		
		String dbUrl = "jdbc:postgresql://ec2-52-73-184-24.compute-1.amazonaws.com/dckqi5pj1ki93c";
		String username = "olkzesmgaifpnp";
		String password = "e13b8bdf28023c60fd1bfde4b54a707571b971a82e85d244b7871afc806f26ed";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(dbUrl,username,password);
			
			
			
			//SQL Statement/Query 
			PreparedStatement pst = connection.prepareStatement("select * from khairatmember where memberid = ? and memberpassword = ?");
			
			// Set string - set for ? by order
			pst.setString(1, memberid);
			pst.setString(2, memberpassword);
			
			// Execute Query Method
			ResultSet result = pst.executeQuery();
			
			// if result has data
			if(result.next()) {
				//will redirect to homepage
				session.setAttribute("name", result.getString("membername"));
				session.setAttribute("id", result.getString("memberid"));
				session.setAttribute("contact", result.getString("membercontactno"));
				session.setAttribute("address", result.getString("memberadress"));
				session.setAttribute("email", result.getString("memberemail"));
				session.setAttribute("password", result.getString("memberpassword"));
				
				//request dispatcher - if login successful
				dispatcher = request.getRequestDispatcher("HOMEPAGE_MEMBER.jsp");
			}
			else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("index.jsp");
			}
			
			dispatcher.forward(request, response);
			
			{
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}