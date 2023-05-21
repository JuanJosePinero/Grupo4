package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static Connection cnx = null;

	public static Connection obtener() throws SQLException, ClassNotFoundException {
		if (cnx == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				cnx = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/gestionra8?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
						"root", "root");
			} catch (SQLException ex) {
				throw new SQLException(ex);
			} catch (ClassNotFoundException ex) {
				throw new ClassNotFoundException(ex.getMessage());
			}
		}
		return cnx;
	}

	public static void cerrar() throws SQLException {
		if (cnx != null) {
			cnx.close();
		}
	}
}
