package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Cliente;
import models.Vehiculo;

// TODO: Auto-generated Javadoc
/**
 * The Class ClientService.
 */
public class ClientService {

	/** The tabla. */
	private final String tabla = "cliente";

	/**
	 * Save.
	 *
	 * @param conexion the conexion
	 * @param cliente  the cliente
	 * @throws SQLException the SQL exception
	 */
	public void save(Connection conexion, Cliente cliente) throws SQLException {
		try {
			PreparedStatement consulta;
			if (cliente.getIdClientes() == null) {
				consulta = conexion.prepareStatement("INSERT INTO " + this.tabla
						+ "(nombre, direccion,rol,usuario,Contasenya,Activar,numCompras,numAlquileres,numcomentarios,numvaloraciones) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				consulta.setString(1, cliente.getNombre());
				consulta.setString(2, cliente.getDireccion());
				consulta.setString(3, cliente.getRol());
				consulta.setString(4, cliente.getNombreUsuario());
				consulta.setString(5, cliente.getContrasena());
				consulta.setInt(6, cliente.getActivar());
				consulta.setInt(7, cliente.getNumCompras());
				consulta.setInt(8, cliente.getNumAlquileres());
				consulta.setInt(9, cliente.getNumComentarios());
				consulta.setInt(10, cliente.getNumValoraciones());

			} else {
				consulta = conexion.prepareStatement("UPDATE " + this.tabla
						+ " SET nombre = ?, direccion = ?,rol = ?, usuario = ?, Contasenya = ?, Activar = ?, numCompras = ?, numAlquileres = ?, numcomentarios = ?, numvaloraciones = ? WHERE idCliente = ?");
				consulta.setString(1, cliente.getNombre());
				consulta.setString(2, cliente.getDireccion());
				consulta.setString(3, cliente.getRol());
				consulta.setString(4, cliente.getNombreUsuario());
				consulta.setString(5, cliente.getContrasena());
				consulta.setInt(6, cliente.getActivar());
				consulta.setInt(7, cliente.getNumCompras());
				consulta.setInt(8, cliente.getNumAlquileres());
				consulta.setInt(9, cliente.getNumComentarios());
				consulta.setInt(10, cliente.getNumValoraciones());
				consulta.setInt(11, cliente.getIdClientes());
			}
			consulta.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	/**
	 * Gets the cliente.
	 *
	 * @param conexion      the conexion
	 * @param nombreUsuario the nombre usuario
	 * @return the cliente
	 * @throws SQLException the SQL exception
	 */
	public Cliente getCliente(Connection conexion, String nombreUsuario) throws SQLException {
		Cliente cliente = null;
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT idCliente,nombre, direccion,rol,usuario,Contasenya,Activar,numCompras,numAlquileres,numcomentarios,numvaloraciones "
							+ " FROM " + this.tabla + " WHERE usuario = ?");
			consulta.setString(1, nombreUsuario);
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				cliente = new Cliente(resultado.getInt("idCliente"), resultado.getString("nombre"),
						resultado.getString("direccion"), resultado.getString("rol"), resultado.getString("usuario"),
						resultado.getString("Contasenya"), resultado.getInt("Activar"), resultado.getInt("numCompras"),
						resultado.getInt("numAlquileres"), resultado.getInt("numcomentarios"),
						resultado.getInt("numvaloraciones"));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return cliente;
	}

	/**
	 * Gets the cliente id.
	 *
	 * @param conexion the conexion
	 * @param id       the id
	 * @return the cliente id
	 * @throws SQLException the SQL exception
	 */
	public Cliente getClienteId(Connection conexion, int id) throws SQLException {
		Cliente cliente = null;
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT idCliente,nombre, direccion,rol,usuario,Contasenya,Activar,numCompras,numAlquileres,numcomentarios,numvaloraciones "
							+ " FROM " + this.tabla + " WHERE idCliente = ?");
			consulta.setInt(1, id);
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				cliente = new Cliente(resultado.getInt("idCliente"), resultado.getString("nombre"),
						resultado.getString("direccion"), resultado.getString("rol"), resultado.getString("usuario"),
						resultado.getString("Contasenya"), resultado.getInt("Activar"), resultado.getInt("numCompras"),
						resultado.getInt("numAlquileres"), resultado.getInt("numcomentarios"),
						resultado.getInt("numvaloraciones"));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return cliente;
	}

	/**
	 * Removes the.
	 *
	 * @param conexion the conexion
	 * @param cliente  the cliente
	 * @throws SQLException the SQL exception
	 */
	public void remove(Connection conexion, Cliente cliente) throws SQLException {
		try {
			PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE id = ?");
			consulta.setInt(1, cliente.getIdClientes());
			consulta.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	/**
	 * Gets the all cliente.
	 *
	 * @param conexion the conexion
	 * @return the all cliente
	 * @throws SQLException the SQL exception
	 */
	public List<Cliente> getAllCliente(Connection conexion) throws SQLException {
		List<Cliente> cliente = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT idCliente,nombre,direccion ,rol,usuario,contasenya,Activar,numCompras,numAlquileres"
							+ " FROM " + this.tabla);
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				cliente.add(new Cliente(resultado.getInt("idCliente"), resultado.getString("nombre"),
						resultado.getString("direccion"), resultado.getString("rol"), resultado.getString("usuario"),
						resultado.getString("contasenya"), resultado.getInt("Activar"), resultado.getInt("numCompras"),
						resultado.getInt("numAlquileres")));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return cliente;
	}

	/**
	 * Gets the all rol cliente.
	 *
	 * @param conexion the conexion
	 * @return the all rol cliente
	 * @throws SQLException the SQL exception
	 */
	public List<Cliente> getAllRolCliente(Connection conexion) throws SQLException {
		List<Cliente> cliente = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT idCliente,nombre,direccion,rol,usuario,contasenya,Activar" + " FROM "
							+ this.tabla + " WHERE rol = 'Cliente'");
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				cliente.add(new Cliente(resultado.getInt("idCliente"), resultado.getString("nombre"),
						resultado.getString("direccion"), resultado.getString("rol"), resultado.getString("usuario"),
						resultado.getString("contasenya"), resultado.getInt("Activar")));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return cliente;
	}

	/**
	 * Gets the compras cliente.
	 *
	 * @param conexion the conexion
	 * @return the compras cliente
	 * @throws SQLException the SQL exception
	 */
	public List<Cliente> getComprasCliente(Connection conexion) throws SQLException {
		List<Cliente> cliente = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT cliente.idCliente, cliente.nombre, cliente.direccion, cliente.rol, cliente.usuario, cliente.contasenya, cliente.Activar, "
							+ "(SELECT COUNT(idCliente) FROM venta WHERE venta.idCliente = cliente.idCliente) AS numCompras, "
							+ "(SELECT COUNT(idCliente) FROM alquiler WHERE alquiler.idCliente = cliente.idCliente) AS numAlquileres "
							+ "FROM " + this.tabla + " WHERE cliente.rol = 'Cliente' " + "ORDER BY numCompras DESC");
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				int id = resultado.getInt("idCliente");
				String nombre = resultado.getString("nombre");
				String direccion = resultado.getString("direccion");
				String rol = resultado.getString("rol");
				String usuario = resultado.getString("usuario");
				String contrasenya = resultado.getString("contasenya");
				int activar = resultado.getInt("Activar");
				int numCompras = resultado.getInt("numCompras");
				int numAlquileres = resultado.getInt("numAlquileres");
				cliente.add(new Cliente(id, nombre, direccion, rol, usuario, contrasenya, activar, numCompras,
						numAlquileres));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return cliente;
	}

	/**
	 * Gets the alquileres cliente.
	 *
	 * @param conexion the conexion
	 * @return the alquileres cliente
	 * @throws SQLException the SQL exception
	 */
	public List<Cliente> getAlquileresCliente(Connection conexion) throws SQLException {
		List<Cliente> cliente = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT cliente.idCliente, cliente.nombre, cliente.direccion, cliente.rol, cliente.usuario, cliente.contasenya, cliente.Activar, "
							+ "(SELECT COUNT(idVenta) FROM venta WHERE venta.idCliente = cliente.idCliente) AS numCompras, "
							+ "(SELECT COUNT(idAlquiler) FROM alquiler WHERE alquiler.idCliente = cliente.idCliente) AS numAlquileres "
							+ "FROM " + this.tabla + " WHERE cliente.rol = 'Cliente' " + "GROUP BY cliente.idCliente "
							+ "ORDER BY numAlquileres DESC");
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				int id = resultado.getInt("idCliente");
				String nombre = resultado.getString("nombre");
				String direccion = resultado.getString("direccion");
				String rol = resultado.getString("rol");
				String usuario = resultado.getString("usuario");
				String contrasenya = resultado.getString("contasenya");
				int activar = resultado.getInt("Activar");
				int numCompras = resultado.getInt("numCompras");
				int numAlquileres = resultado.getInt("numAlquileres");
				cliente.add(new Cliente(id, nombre, direccion, rol, usuario, contrasenya, activar, numCompras,
						numAlquileres));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return cliente;
	}

	/**
	 * Gets the comentarios cliente.
	 *
	 * @param conexion the conexion
	 * @return the comentarios cliente
	 * @throws SQLException the SQL exception
	 */
	public List<Cliente> getComentariosCliente(Connection conexion) throws SQLException {
		List<Cliente> cliente = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT cliente.idCliente, cliente.nombre, cliente.direccion, cliente.rol, cliente.usuario, cliente.contasenya,  cliente.numcomentarios, cliente.numvaloraciones,"
							+ "(SELECT COUNT(*) FROM comentario WHERE comentario.idCliente = cliente.idCliente) AS numcomentarios, "
							+ "(SELECT COUNT(valoracion) FROM valoracion WHERE valoracion.idCliente = cliente.idCliente) AS numvaloraciones "
							+ "FROM " + this.tabla + " WHERE cliente.rol = 'Cliente' " + "GROUP BY cliente.idCliente "
							+ "ORDER BY numcomentarios DESC");
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				int id = resultado.getInt("idCliente");
				String nombre = resultado.getString("nombre");
				String direccion = resultado.getString("direccion");
				String rol = resultado.getString("rol");
				String usuario = resultado.getString("usuario");
				String contrasenya = resultado.getString("contasenya");
				int numcomentarios = resultado.getInt("numcomentarios");
				int numvaloraciones = resultado.getInt("numvaloraciones");
				cliente.add(
						new Cliente(id, nombre, direccion, rol, usuario, contrasenya, numcomentarios, numvaloraciones));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return cliente;
	}

	/**
	 * Gets the valoraciones cliente.
	 *
	 * @param conexion the conexion
	 * @return the valoraciones cliente
	 * @throws SQLException the SQL exception
	 */
	public List<Cliente> getValoracionesCliente(Connection conexion) throws SQLException {
		List<Cliente> cliente = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT cliente.idCliente, cliente.nombre, cliente.direccion, cliente.rol, cliente.usuario, cliente.contasenya, cliente.Activar, "
							+ "(SELECT COUNT(comentario) FROM comentario WHERE comentario.idCliente = cliente.idCliente) AS numcomentarios, "
							+ "(SELECT COUNT(*) FROM valoracion WHERE valoracion.idCliente = cliente.idCliente) AS numvaloraciones "
							+ "FROM " + this.tabla + " WHERE cliente.rol = 'Cliente' " + "GROUP BY cliente.idCliente "
							+ "ORDER BY numvaloraciones DESC");
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				int id = resultado.getInt("idCliente");
				String nombre = resultado.getString("nombre");
				String direccion = resultado.getString("direccion");
				String rol = resultado.getString("rol");
				String usuario = resultado.getString("usuario");
				String contrasenya = resultado.getString("contasenya");
				int activar = resultado.getInt("Activar");
				int numcomentarios = resultado.getInt("numcomentarios");
				int numvaloraciones = resultado.getInt("numvaloraciones");
				cliente.add(new Cliente(id, nombre, direccion, rol, usuario, contrasenya, activar, numcomentarios,
						numvaloraciones));
			}

		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return cliente;
	}
}
