import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Impl implements JDBCinterface {
	PreparedStatement psmt=null;
	public void Implfun() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection(CONNURL,DBUSER,DBPSWD);
		String query="insert into room values(?,?)";
		psmt=conn.prepareStatement(query);
		
		psmt.setInt(1,2);
		psmt.setInt(2,123);
		psmt.addBatch();
		
		psmt.setInt(1,3);
		psmt.setInt(2,434);
		psmt.addBatch();

		psmt.executeBatch();
	    
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
