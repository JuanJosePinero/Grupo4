package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Views.Login;
import models.Comentario;

// TODO: Auto-generated Javadoc
/**
 * The Class ComentarioService.
 */
public class ComentarioService {

	/** The tabla. */
	private final String tabla = "comentario";

	/**
	 * Save.
	 *
	 * @param conexion   the conexion
	 * @param comentario the comentario
	 * @throws SQLException the SQL exception
	 */
	public void save(Connection conexion, Comentario comentario) throws SQLException {
		try {
			PreparedStatement consulta;
			if (comentario.getIdCliente() == null) {
				consulta = conexion.prepareStatement(
						"INSERT INTO " + this.tabla + "(idCliente,idVehiculo,comentario) VALUES(?, ?, ?)");
				consulta.setInt(1, comentario.getIdCliente());
				consulta.setInt(2, comentario.getIdVehiculo());
				consulta.setString(3, comentario.getComentario());

			} else {
				consulta = conexion.prepareStatement("UPDATE " + this.tabla
						+ " SET idCliente = ?, idVehiculo = ?, comentario  = ? WHERE idCliente = ?");
				consulta = conexion.prepareStatement(
						"INSERT INTO " + this.tabla + "(idCliente,idVehiculo,comentario) VALUES(?, ?, ?)");
				consulta.setInt(1, comentario.getIdCliente());
				consulta.setInt(2, comentario.getIdVehiculo());
				consulta.setString(3, comentario.getComentario());
			}
			consulta.executeUpdate();
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Ya has enviado un comentario");
		}
	}

	/**
	 * Gets the comentario.
	 *
	 * @param conexion the conexion
	 * @return the comentario
	 * @throws SQLException the SQL exception
	 */
	public Comentario getComentario(Connection conexion) throws SQLException {
		Comentario comentario = null;
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT idVenta,idCliente,idVehiculo,comentario " + " FROM " + this.tabla + " WHERE idVenta = ?");
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				comentario = new Comentario(resultado.getInt("idCliente"), resultado.getInt("idVehiculo"),
						resultado.getString("comentario"));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return comentario;
	}

	/**
	 * Gets the comentario id.
	 *
	 * @param conexion the conexion
	 * @param id       the id
	 * @return the comentario id
	 * @throws SQLException the SQL exception
	 */
	public Comentario getComentarioId(Connection conexion, int id) throws SQLException {
		Comentario comentario = null;
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT idCliente,idVehiculo,comentario " + " FROM " + this.tabla + " WHERE idVehiculo = ?");
			consulta.setInt(1, id);
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				comentario = new Comentario(resultado.getInt("idCliente"), resultado.getInt("idVehiculo"),
						resultado.getString("comentario"));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return comentario;
	}

	/**
	 * Removes the.
	 *
	 * @param conexion   the conexion
	 * @param comentario the comentario
	 * @throws SQLException the SQL exception
	 */
	public void remove(Connection conexion, Comentario comentario) throws SQLException {
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("DELETE FROM " + this.tabla + " WHERE idCliente = ?");
			consulta.setInt(1, comentario.getIdCliente());
			consulta.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	/**
	 * Gets the all comentario.
	 *
	 * @param conexion the conexion
	 * @return the all comentario
	 * @throws SQLException the SQL exception
	 */
	public List<Comentario> getAllComentario(Connection conexion) throws SQLException {
		List<Comentario> products = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT idCliente,idVehiculo,comentario " + " FROM " + this.tabla);
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				products.add(new Comentario(resultado.getInt("idCliente"), resultado.getInt("idVehiculo"),
						resultado.getString("comentario")));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return products;
	}

	/**
	 * Gets the all comentario id.
	 *
	 * @param conexion the conexion
	 * @return the all comentario id
	 * @throws SQLException the SQL exception
	 */
	public List<Comentario> getAllComentarioId(Connection conexion) throws SQLException {
		List<Comentario> products = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT idCliente,idVehiculo,comentario " + " FROM " + this.tabla + " WHERE idVehiculo = ?");
			consulta.setInt(1, Login.getidVehiculo());
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				products.add(new Comentario(resultado.getInt("idCliente"), resultado.getInt("idVehiculo"),
						resultado.getString("comentario")));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return products;
	}
}
