package ekhairat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static java.lang.System.out;

public class registrationDao {
	
	String dbURL = "jdbc:postgres://ec2-52-73-184-24.compute-1.amazonaws.com/dckqi5pj1ki93c";
	String user = "olkzesmgaifpnp";
	String pass = "e13b8bdf28023c60fd1bfde4b54a707571b971a82e85d244b7871afc806f26ed";
	
	protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(dbURL, user, pass);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
	
	public void register (Khairatmember khairatmember) throws SQLException {

        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into khairatmember(memberName,memberContactNo,memberEmail,memberPassword,memberAddress;) values(?,?,?,?,?)");)
        {
            preparedStatement.setString(1, khairatmember.getmemberName());
            preparedStatement.setString(2, khairatmember.getmemberContactNo());
            preparedStatement.setString(3, khairatmember.getmemberEmail());
            preparedStatement.setString(4, khairatmember.getmemberPassword());
            preparedStatement.setString(5, khairatmember.getmemberAddress());

            out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
	}
	
	public boolean updateregister(Khairatmember khairatmember) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("update admin set khairatmembermemberName=?,khairatmembermemberContactNo=?,khairatmembermemberEmail=?, khairatmembermemberPassword=?, khairatmembermemberAddress=? where khairatmembermemberID=?");)
        {
        	statement.setString(1, khairatmember.getmemberName());
            statement.setString(2, khairatmember.getmemberContactNo());
            statement.setString(3, khairatmember.getmemberEmail());
            statement.setString(4, khairatmember.getmemberPassword());
            statement.setString(5, khairatmember.getmemberAddress());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
	
	public boolean deleteregister(int memberID) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("delete from khairatmember where memberID=?");) {
            statement.setInt(1, memberID);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}