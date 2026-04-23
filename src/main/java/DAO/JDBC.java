package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	private static final String url="jdbc:mysql://localhost:3308/data";
	private static final String user="root";
	private static final String pass="";
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, pass);
	}
	
	public static void dongKetNoi(Connection con, Statement stm, ResultSet rs) {
		try {
			if(con != null || !con.isClosed()) {
				con.close();
			}
			if(stm != null) {
				stm.close();
			}
			if(rs != null) {
				rs.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
