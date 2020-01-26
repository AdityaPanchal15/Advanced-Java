import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {

public boolean Transfer(String acc1,String acc2,int amount,Connection connection,Statement stmt) throws SQLException {
	connection.setAutoCommit(false);
	if(withdraw(acc1,amount,connection,stmt)) {
		if(deposit(acc2,amount,connection,stmt)) {
			System.out.println("Successfully Transaction Done");
			connection.commit();
			return true;
		}else {
			System.out.println("Not Successfully transaction done");
			return false;
		}
	}else {
		System.out.println("Not Successfully transaction done");
		return false;
	}
	
	
}

public boolean deposit(String acc2,int amount,Connection connection,Statement stmt) {
	try {
	stmt=connection.createStatement();
	ResultSet rs=stmt.executeQuery("select amount from bank where Account='"+acc2+"'");
	while(rs.next()) {
    	if(rs.getString(1)==acc2)
    		amount=amount+rs.getInt(2);
    }
	
	stmt.execute("update bank SET amount='"+amount+"' WHERE Account='"+acc2+"'");
	
	}catch(Exception e) {
		
	}

	return true;
}

public boolean withdraw(String acc1,int amount,Connection connection,Statement stmt) throws SQLException {
	int amount1 = 0;
	
	stmt=connection.createStatement();
	ResultSet rs=stmt.executeQuery("select amount from bank where Account='"+acc1+"'");
    while(rs.next()) {
    	if(rs.getString(1)==acc1)
    		amount1=amount-rs.getInt(2);
    }
	if(amount1<=0) {
		stmt.execute("update bank SET amount='"+amount1+"' WHERE Account='"+acc1+"'");
		return true;
	}else {
		return false;
	}
	
 }
}
