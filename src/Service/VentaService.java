package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Venta;

// TODO: Auto-generated Javadoc
/**
 * The Class VentaService.
 */
public class VentaService {

	/** The tabla. */
	private final String tabla = "venta";

	/**
	 * Save.
	 *
	 * @param conexion the conexion
	 * @param venta    the venta
	 * @throws SQLException the SQL exception
	 */
	public void save(Connection conexion, Venta venta) throws SQLException {
		try {
			PreparedStatement consulta;
			if (venta.getIdVenta() == null) {
				consulta = conexion.prepareStatement(
						"INSERT INTO " + this.tabla + "(idCliente,idVehiculo,fechaHora) VALUES(?, ?, ?)");
				consulta.setInt(1, venta.getIdCliente());
				consulta.setInt(2, venta.getIdVehiculo());
				consulta.setDate(3, venta.getFechaHora());

			} else {
				consulta = conexion.prepareStatement("UPDATE " + this.tabla
						+ " SET idCliente = ?, idVehiculo = ?, fechaHora  = ? WHERE idVenta = ?");
				consulta = conexion.prepareStatement(
						"INSERT INTO " + this.tabla + "(idCliente,idVehiculo,fechaHora) VALUES(?, ?, ?)");
				consulta.setInt(1, venta.getIdCliente());
				consulta.setInt(2, venta.getIdVehiculo());
				consulta.setDate(3, venta.getFechaHora());
				consulta.setInt(4, venta.getIdVenta());
			}
			consulta.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	/**
	 * Gets the venta.
	 *
	 * @param conexion the conexion
	 * @param idVenta  the id venta
	 * @return the venta
	 * @throws SQLException the SQL exception
	 */
	public Venta getVenta(Connection conexion, Integer idVenta) throws SQLException {
		Venta venta = null;
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT idVenta,idCliente,idVehiculo,fechaHora " + " FROM " + this.tabla + " WHERE idVenta = ?");
			consulta.setInt(1, idVenta);
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				venta = new Venta(resultado.getInt("idVenta"), resultado.getInt("idCliente"),
						resultado.getInt("idVehiculo"), resultado.getDate("fechaHora"));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return venta;
	}

	/**
	 * Gets the ventaid.
	 *
	 * @param conexion   the conexion
	 * @param idCliente  the id cliente
	 * @param idVehiculo the id vehiculo
	 * @return the ventaid
	 * @throws SQLException the SQL exception
	 */
	public Venta getVentaid(Connection conexion, Integer idCliente, Integer idVehiculo) throws SQLException {
		Venta venta = null;
		try {
			PreparedStatement consulta = conexion.prepareStatement("SELECT idVenta,idCliente,idVehiculo,fechaHora "
					+ " FROM " + this.tabla + " WHERE idCliente = ? AND idVehiculo = ?");
			consulta.setInt(1, idCliente);
			consulta.setInt(2, idVehiculo);
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				venta = new Venta(resultado.getInt("idVenta"), resultado.getInt("idCliente"),
						resultado.getInt("idVehiculo"), resultado.getDate("fechaHora"));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return venta;
	}

	/**
	 * Removes the.
	 *
	 * @param conexion the conexion
	 * @param venta    the venta
	 * @throws SQLException the SQL exception
	 */
	public void remove(Connection conexion, Venta venta) throws SQLException {
		try {
			PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE idVenta = ?");
			consulta.setInt(1, venta.getIdVenta());
			consulta.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	/**
	 * Gets the all ventas.
	 *
	 * @param conexion the conexion
	 * @return the all ventas
	 * @throws SQLException the SQL exception
	 */
	public List<Venta> getAllVentas(Connection conexion) throws SQLException {
		List<Venta> products = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT idVenta,idCliente,idVehiculo,fechaHora " + " FROM " + this.tabla);
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				products.add(new Venta(resultado.getInt("idVenta"), resultado.getInt("idCliente"),
						resultado.getInt("idVehiculo"), resultado.getDate("fechaHora")));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return products;
	}

}
