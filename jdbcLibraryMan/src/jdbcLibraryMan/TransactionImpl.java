package jdbcLibraryMan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
			
			Scanner input1 = new Scanner(System.in);
			System.out.println("Enter Option:");
			int op = Integer.parseInt(input1.nextLine());
			System.out.println(op);
			String sql = null;
			switch(op) {
				case 1:
					
					cst = conn.prepareCall("{call createRoom()}");
					System.out.println("Table Created.");
					break;
				case 2:
					sql = "select * from user_tbl";
					ResultSet rs = cst.executeQuery(sql);
					while(rs.next()) {
						System.out.println(rs.getInt(1)+" "+rs.getString(2));
					}
					rs.close();
					break;
				case 3:
					cst=conn.prepareCall("{call insertRoom(?,?)}");
					cst.setInt(1,id);
					cst.setInt(2,number);
					break;
				case 4:
					System.out.println("Enter id:");
					int id1=Integer.parseInt(input1.nextLine());
					cst=conn.prepareCall("{call deleteRoom(?)}");
					cst.setInt(1,id);
					break;
				default:
					break;
			}
			
			
			cst.execute();
			conn.close();
			input1.close();

		}catch(Exception e) {
				System.out.println(e);
			}
		  
		}
		
}
