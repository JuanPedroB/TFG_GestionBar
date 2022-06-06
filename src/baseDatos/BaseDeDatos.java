package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatos {

	private Connection base = null;
	static String URL_BASEDATOS = "jdbc:mysql://localhost:3306/gestionbar";
	
	public BaseDeDatos() {
		super();
		try {
			this.base = DriverManager.getConnection(URL_BASEDATOS, "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getBase() {
		return base;
	}
}
