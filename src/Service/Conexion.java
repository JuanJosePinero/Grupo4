package Service;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection cnx = null;

    public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (cnx == null) {
            try {
                // Verificar la versión del controlador JDBC de MySQL que estás utilizando
                // Si estás usando MySQL 8.0 o superior
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Si estás usando una versión anterior a MySQL 8.0
                // Class.forName("com.mysql.jdbc.Driver");

                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionra8?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
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
