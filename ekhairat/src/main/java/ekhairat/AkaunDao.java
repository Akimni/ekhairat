package ekhairat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AkaunDao<Khairatmemberr> {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	
	private static final String dbURL = "jdbc:postgresql://ec2-52-73-184-24.compute-1.amazonaws.com/dckqi5pj1ki93c";
	private static final String user = "olkzesmgaifpnp";
	private static final String pass = "e13b8bdf28023c60fd1bfde4b54a707571b971a82e85d244b7871afc806f26ed";
	private static final String SELECT_MEMBERKHAIRAT_BY_ID="select memberid,membername,membercontactno,mambereamil,memberadress from khairatmeber where id?";
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
     
    	//untuk update user
    	/*public boolean updateKhairatmemberr(Khairatmember mem) throws SQLException{
    		
    		boolean rowUpdated;
    		try (Connection connection= getConnection();
    				PreparedStatement statement =connection.prepareStatement("");){
    					statement.setString(1, mem.getmemberName());
    					statement.setString(2, mem.getmemberID());
    		            statement.setString(3, mem.getmemberContactNo());
    		            statement.setString(5, mem.getmemberEmail());
    		            statement.setString(6, mem.getmemberPassword());
    		            statement.setString(4, mem.getmemberAddress());
    		            
    		            rowUpdated=statement.executeUpdate()>0;
    				}
    				return rowUpdated;
    	}*/

    	//select user by memberid
    	public Khairatmember selectKhairatmember (String memberID) {
    		Khairatmember user=null; 
    		try(Connection connection= getConnection();
    		PreparedStatement preparedStatement = connection.prepareStatement("SELECT_MEMBERKHAIRAT_BY_MEMBERID");){	
    			preparedStatement.setString(1,memberID);
    		System.out.println(preparedStatement);
    		ResultSet rs = preparedStatement.executeQuery();
    		 while (rs.next()) {
    			 String memberName=rs.getString("membername");
    			 String memberContactNo= rs.getString("membercontactno");
    			 String memberAddress=rs.getString("memberaddress");
    			 String memberEmail=rs.getString("memberemail");
    			 String memberPassword=rs.getString("memberpassword");
    			 user= new Khairatmember(memberID,memberName,memberContactNo,memberEmail,memberPassword,memberAddress);	 
    		 }
    		}
    		catch (SQLException e)
    		{
    			e.printStackTrace();
    		}
    		return user;
    		}
    	//select users
    	/*public List<Khairatmember> selectAllKhairatmember(){
    		List<Khairatmember> users =new ArrayList<>();
    		try(Connection connection= getConnection(); 
    		PreparedStatement preparedStatement= connection.prepareStatement("");){
    			System.out.println(preparedStatement);
    			ResultSet rs=preparedStatement.executeQuery();
    			while (rs.next()) {
    				String memberID=rs.getString("memberid");
    				String memberName=rs.getString("membername");
    				 String memberContactNo= rs.getString("membercontactno");
    				 String memberAddress=rs.getString("memberaddress");
    				 String memberEmail=rs.getString("memberemail");
    				 String memberPassword=rs.getString("memberpassword");
    				 users.add( new Khairatmember(memberID,memberName,memberContactNo,memberEmail,memberPassword,memberAddress));	 
    		}
    		}
    			catch (SQLException e) {
    			e.printStackTrace();	
    			}
    			return users;
    		
    }*/
}
