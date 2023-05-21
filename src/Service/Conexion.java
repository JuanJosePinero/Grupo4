package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// TODO: Auto-generated Javadoc
/**
 * The Class Conexion.
 */
public class Conexion {

	/** The cnx. */
	private static Connection cnx = null;

	/**
	 * Obtener.
	 *
	 * @return the connection
	 * @throws SQLException           the SQL exception
	 * @throws ClassNotFoundException the class not found exception
	 */
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

	/**
	 * Cerrar.
	 *
	 * @throws SQLException the SQL exception
	 */
	public static void cerrar() throws SQLException {
		if (cnx != null) {
			cnx.close();
		}
	}
}
