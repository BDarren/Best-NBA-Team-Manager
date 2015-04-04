package org.can;
import java.sql.*;

public class DBConnection {
	Connection con;
	Statement sql;
	String query;
	ResultSet rs;
	public DBConnection(String sql){
		query=sql;
	}
	
	public ResultSet getData(){
	
	
	try{Class.forName("com.mysql.jdbc.Driver").newInstance();}
	catch(Exception e){System.out.print(e);}
	try{
	String uri="jdbc:mysql://localhost:8889/NBA";
	con=DriverManager.getConnection(uri,"can","626391");
	sql=con.createStatement();
	rs=sql.executeQuery(query);
	}catch(SQLException e1){System.out.print(e1);}
	return rs;

	}
	public void close(){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
