package conection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConnectionMysql implements ConnectionManager {

	public Connection open(String jdbcUrl) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(jdbcUrl, "root", "");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return conn;
	}

	public Connection executeSql(Connection conn, String sql) {
		PreparedStatement prepareStatement;
		try {
			prepareStatement = conn.prepareStatement(sql);
		prepareStatement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

}

