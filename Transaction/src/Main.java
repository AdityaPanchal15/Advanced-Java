import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/medical","root","");
			
			}catch(Exception e) {
				System.out.println(e);
			}
		Transaction transaction=new Transaction();
		transaction.Transfer("acc1","acc3",500,conn,stmt);
			
	}
}