package ekhairat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class registrationDao {
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	private static final String dbURL = "jdbc:postgresql://ec2-52-73-184-24.compute-1.amazonaws.com/dckqi5pj1ki93c";
	private static final String user = "olkzesmgaifpnp";
	private static final String pass = "e13b8bdf28023c60fd1bfde4b54a707571b971a82e85d244b7871afc806f26ed";
	
	public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(dbURL, user, pass);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;

    }
	
	public void createKhairatmember (Khairatmember mem) throws SQLException {

        // try-with-resource statement will auto close the connection.
        try (Connection con = getConnection();
             PreparedStatement preparedStatement = con.prepareStatement("insert into khairatmember(membername,memberid,membercontactno,memberaddress,memberemail,memberpassword) values(?,?,?,?,?,?)"))
        {
            preparedStatement.setString(1, mem.getmemberName());
            preparedStatement.setString(2, mem.getmemberID());
            preparedStatement.setString(3, mem.getmemberContactNo());
            preparedStatement.setString(5, mem.getmemberEmail());
            preparedStatement.setString(6, mem.getmemberPassword());
            preparedStatement.setString(4, mem.getmemberAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	
	public void createKhairatstaff (Khairatstaff sta) throws SQLException {

        // try-with-resource statement will auto close the connection.
        try (Connection con = getConnection();
             PreparedStatement preparedStatement = con.prepareStatement("insert into khairatstaff(staffname,staffid,staffcontactno,staffaddress,staffemail,staffpassword) values(?,?,?,?,?,?)"))
        {
            preparedStatement.setString(1, sta.getstaffName());
            preparedStatement.setString(2, sta.getstaffID());
            preparedStatement.setString(3, sta.getstaffContactNo());
            preparedStatement.setString(5, sta.getstaffEmail());
            preparedStatement.setString(6, sta.getstaffPassword());
            preparedStatement.setString(4, sta.getstaffAddress());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


	/*private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
	}
	
	public boolean updateregister(Khairatmember khairatmember) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("update admin set khairatmembermembername=?,khairatmembermembercontactno=?,khairatmembermemberemail=?, khairatmembermemberpassword=?, khairatmembermemberAddress=? where khairatmembermemberID=?");)
        {
        	statement.setString(1, khairatmember.getmemberName());
        	statement.setString(2, khairatmember.getmemberID());
            statement.setString(3, khairatmember.getmemberContactNo());
            statement.setString(4, khairatmember.getmemberEmail());
            statement.setString(5, khairatmember.getmemberPassword());
            statement.setString(6, khairatmember.getmemberAddress());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
	
	public boolean deleteregister(int memberID) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("delete from khairatmember where memberid=?");) {
            statement.setInt(1, memberID);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }*/
public static List<Khairatmember> getAllInfo(){
	List<Khairatmember> infos = new ArrayList<Khairatmember>();
	
	try 
			{
		Connection con=getConnection();
		stmt = con.createStatement();
		String sql = "SELECT * FROM khairatmember ORDER BY memberid";
		
		rs= stmt.executeQuery(sql);
		
		while(rs.next()) {
			Khairatmember i= new Khairatmember(); 
			i.setmemberName(rs.getString("membername"));
			i.setmemberID(rs.getString("memberid"));
			i.setmemberContactNo(rs.getString("membercontactno"));
			i.setmemberEmail(rs.getString("memberemail"));
			i.setmemberPassword(rs.getString("memberpassword"));
			i.setmemberAddress(rs.getString("memberaddress"));
		
			infos.add(i);
		}
		con.close();
	}catch (Exception e) {
          e.printStackTrace();
	}      
	return infos;
}
public static Khairatmember getKhairatmemberBymemberID(int memberID) {
	// TODO Auto-generated method stub
	Khairatmember i = new Khairatmember();
	try {
		
		ps = con.prepareStatement("SELECT * FROM khairatmember WHERE memberid=?");
		
		rs = ps.executeQuery();
		if(rs.next()) {
			i.setmemberName(rs.getString("name"));
			i.setmemberID(rs.getString("memberid"));
			i.setmemberContactNo(rs.getString("memberrcontactno"));
			i.setmemberEmail(rs.getString("memberemail"));
			i.setmemberPassword(rs.getString("memberpassword"));
			i.setmemberAddress(rs.getString("memberaddress"));
		}
		
		con.close();
		
	}catch (Exception e) {
          e.printStackTrace();
    }
	
	return i;
}
}
