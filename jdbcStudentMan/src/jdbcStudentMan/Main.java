package jdbcStudentMan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/medical","root","");
			Statement statement = connection.createStatement();
			
			Scanner input = new Scanner(System.in);
			System.out.println("Enter Option:");
			int op = Integer.parseInt(input.nextLine());
			System.out.println(op);
			String sql = null;
			switch(op) {
				case 1:
					sql = "create table user_tbl(ID INT(5),NAME VARCHAR(20))" ;
					statement.execute(sql);
					System.out.println("Table Created.");
					break;
				case 2:
					sql = "select * from user_tbl";
					ResultSet rs = statement.executeQuery(sql);
					while(rs.next()) {
						System.out.println(rs.getInt(1)+" "+rs.getString(2));
					}
					rs.close();
					break;
				case 3:
					sql = "insert into user_tbl values(1,'Aditya')";
					statement.execute(sql);
					break;
				case 4:
					System.out.println("Enter id:");
					int id=Integer.parseInt(input.nextLine());
					sql = "delete from user_tbl where id='"+id+"'" ;
					statement.execute(sql);
					break;
				default:
					break;
			}
			
			connection.close();
			
		}catch(Exception e) {
			
		}
	}
}
