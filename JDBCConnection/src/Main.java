import java.sql.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/medical","root","");
			String query="select * from room";
			Statement stmt=conn.createStatement();
			//stmt.execute(query);
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				 System.out.println(rs.getInt(1)+""+rs.getInt(2));
				 conn.close();
			}
			}catch(Exception e) {
				System.out.println(e);
			}
	}

}
