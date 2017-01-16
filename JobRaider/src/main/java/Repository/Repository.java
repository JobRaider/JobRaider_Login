package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import conection.ConnectionManager;
import conection.ConnectionMysql;

public class Repository {
	protected static final String jdbcUrl = "jdbc:mysql://localhost:3306/jobraider";
	static ConnectionManager manager = new ConnectionMysql();
	Connection connection = null;

	public static boolean Validate(String name, String pass) {
		boolean status = false;
		Connection connection = null;
		try {
			connection = manager.open(jdbcUrl);

			PreparedStatement ps = connection.prepareStatement("select * from user where nombre=? and password=?");
			ps.setString(1, name);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			status = rs.next();
			manager.close(connection);

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public void InsertUser(String s1, String s2,  String s3, String s4){
		boolean status = false;
		Connection connection = null;
		try
    	{
			connection = manager.open(jdbcUrl);
    	PreparedStatement ps=connection.prepareStatement("insert into user (nombre, password, apellido, dni) values( ?, ?, ?, ? )");
    	ps.setString(1, s1);
    	ps.setString(2,s2);
    	ps.setString(3, s3);
    	ps.setString(4,s4);
    	ps.executeUpdate();
    	manager.close(connection);
    	}
    	catch (Exception e) {
    		e.printStackTrace();
		}
	}
		public void InsertLog(String s1, String s2, String s3, String s4){
			boolean status = false;
			Connection connection = null;
			try
	    	{
				connection = manager.open(jdbcUrl);
	    	PreparedStatement ps=connection.prepareStatement("insert into log (nombre, apellido, hora, estado) values( ?, ?, ?, ?)");
	    	ps.setString(1, s1);
	    	ps.setString(2,s2);
	    	ps.setString(3, s3);
	    	ps.setString(4,s4);
	    	ps.executeUpdate();
	    	manager.close(connection);
	    	}
	    	catch (Exception e) {
	    		e.printStackTrace();
			}
		
		
	}

}
