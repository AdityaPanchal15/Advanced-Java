import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.CallableStatement;

public class TransactionImpl implements TransInterface {

		CallableStatement cst=null;
		public void Implfun() {
			
			Scanner input=new Scanner(System.in);
			System.out.println("Enter id:");
			int id=Integer.parseInt(input.nextLine());
			System.out.println("Enter room number:");
			int number=Integer.parseInt(input.nextLine());
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection(CONNURL,DBUSER,DBPSWD);
			
			cst=conn.prepareCall("{call insertRoom(?,?)}");
			cst.setInt(1,id);
			cst.setInt(2,number);
			cst.execute();
			conn.close();
			input.close();

		}catch(Exception e) {
				System.out.println(e);
			}
		  
		}
		
}
