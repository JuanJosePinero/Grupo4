package Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Views.Login;
import models.Alquiler;

// TODO: Auto-generated Javadoc
/**
 * The Class AlquilerService.
 */
public class AlquilerService {

	/** The tabla. */
	private final String tabla = "alquiler";

	/**
	 * Save.
	 *
	 * @param conexion the conexion
	 * @param alquiler the alquiler
	 * @throws SQLException the SQL exception
	 */
	public void save(Connection conexion, Alquiler alquiler) throws SQLException {
		try {
			PreparedStatement consulta;
			if (alquiler.getIdAlquiler() == null) {
				consulta = conexion.prepareStatement(
						"INSERT INTO " + this.tabla + "(idCliente,idVehiculo,fechaInic,fechaFin) VALUES(?, ?, ?, ?)");
				consulta.setInt(1, alquiler.getIdCliente());
				consulta.setInt(2, alquiler.getIdVehiculo());
				consulta.setDate(3, (Date) alquiler.getFechaInic());
				consulta.setDate(4, (Date) alquiler.getFechFin());
			} else {
				consulta = conexion.prepareStatement("UPDATE " + this.tabla
						+ " SET idCliente = ?, idVehiculo = ?, fechaInic  = ?, fechaFin  = ? WHERE idAlquiler = ?");
				consulta = conexion.prepareStatement(
						"INSERT INTO " + this.tabla + "(idCliente,idVehiculo,fechaInic,fechaFin) VALUES(?, ?, ?, ?)");
				consulta.setInt(1, alquiler.getIdCliente());
				consulta.setInt(2, alquiler.getIdVehiculo());
				consulta.setDate(3, (Date) alquiler.getFechaInic());
				consulta.setDate(4, (Date) alquiler.getFechFin());
				consulta.setInt(5, alquiler.getIdAlquiler());
			}
			consulta.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	/**
	 * Gets the alquiler.
	 *
	 * @param conexion the conexion
	 * @param id       the id
	 * @return the alquiler
	 * @throws SQLException the SQL exception
	 */
	public Alquiler getAlquiler(Connection conexion, int id) throws SQLException {
		Alquiler alquiler = null;
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT idAlquiler,idCliente,idVehiculo,fechaInic,fechaFin " + " FROM "
							+ this.tabla + " WHERE idAlquiler = ?");
			consulta.setInt(1, id);
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				alquiler = new Alquiler(resultado.getInt("idAlquiler"), resultado.getInt("idCliente"),
						resultado.getInt("idVehiculo"), resultado.getDate("fechaInic"), resultado.getDate("fechaFin"));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return alquiler;
	}

	/**
	 * Removes the.
	 *
	 * @param conexion the conexion
	 * @param alquiler the alquiler
	 * @throws SQLException the SQL exception
	 */
	public void remove(Connection conexion, Alquiler alquiler) throws SQLException {
		try {
			PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE idVenta = ?");
			consulta.setInt(1, alquiler.getIdAlquiler());
			consulta.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	/**
	 * Gets the all alquileres.
	 *
	 * @param conexion the conexion
	 * @return the all alquileres
	 * @throws SQLException the SQL exception
	 */
	public List<Alquiler> getAllAlquileres(Connection conexion) throws SQLException {
		List<Alquiler> alquiler = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT idAlquiler, idCliente, idVehiculo, fechaInic, fechaFin " + "FROM "
							+ this.tabla + " WHERE idCliente=?");
			consulta.setInt(1, Login.getidClienteLogin());
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				alquiler.add(new Alquiler(resultado.getInt("idAlquiler"), resultado.getInt("idCliente"),
						resultado.getInt("idVehiculo"), resultado.getDate("fechaInic"), resultado.getDate("fechaFin")));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return alquiler;
	}
}
