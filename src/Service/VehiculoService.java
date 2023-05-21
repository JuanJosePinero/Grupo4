package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Views.ListViewFabricante;
import Views.Login;
import models.Vehiculo;

// TODO: Auto-generated Javadoc
/**
 * The Class VehiculoService.
 */
public class VehiculoService {

	/** The tabla. */
	private final String tabla = "vehiculo";

	/**
	 * Save.
	 *
	 * @param conexion the conexion
	 * @param vehiculo the vehiculo
	 * @throws SQLException the SQL exception
	 */
	public void save(Connection conexion, Vehiculo vehiculo) throws SQLException {
		try {
			PreparedStatement consulta;
			if (vehiculo.getIdVehiculos() == null) {
				consulta = conexion.prepareStatement("INSERT INTO " + this.tabla
						+ "(modelo, marca, anyo, color, precio, idFabricante, ruta, numcomentarios,numvaloraciones) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
				consulta.setString(1, vehiculo.getModelo());
				consulta.setString(2, vehiculo.getMarca());
				consulta.setInt(3, vehiculo.getAnyo());
				consulta.setString(4, vehiculo.getColor());
				consulta.setFloat(5, vehiculo.getPrecio());
				consulta.setInt(6, vehiculo.getIdFabricante());
				consulta.setString(7, vehiculo.getRuta());
				consulta.setInt(8, vehiculo.getNumcomentarios());
				consulta.setInt(9, vehiculo.getNumvaloraciones());
			} else {
				consulta = conexion.prepareStatement("UPDATE " + this.tabla
						+ " SET modelo = ?, marca = ?, anyo = ?, color = ?, precio = ?, idFabricante = ?, ruta = ?, comprado = ?, alquilado = ?, numcomentarios = ?, numvaloraciones = ?  WHERE idVehiculos = ?");
				consulta.setString(1, vehiculo.getModelo());
				consulta.setString(2, vehiculo.getMarca());
				consulta.setInt(3, vehiculo.getAnyo());
				consulta.setString(4, vehiculo.getColor());
				consulta.setFloat(5, vehiculo.getPrecio());
				consulta.setInt(6, vehiculo.getIdFabricante());
				consulta.setString(7, vehiculo.getRuta());
				consulta.setInt(8, vehiculo.getComprado());
				consulta.setInt(9, vehiculo.getAlquilado());
				consulta.setInt(10, vehiculo.getNumcomentarios());
				consulta.setInt(11, vehiculo.getNumvaloraciones());
				consulta.setInt(12, vehiculo.getIdVehiculos());
			}
			consulta.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	/**
	 * Gets the vehiculo.
	 *
	 * @param conexion the conexion
	 * @param id       the id
	 * @return the vehiculo
	 * @throws SQLException the SQL exception
	 */
	public Vehiculo getVehiculo(Connection conexion, int id) throws SQLException {
		Vehiculo vehiculo = null;
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante, ruta, comprado, alquilado,numcomentarios,numvaloraciones"
							+ " FROM " + this.tabla + " WHERE idVehiculos = ?");
			consulta.setInt(1, id);
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				vehiculo = new Vehiculo(resultado.getInt("idVehiculos"), resultado.getString("modelo"),
						resultado.getString("marca"), resultado.getInt("anyo"), resultado.getString("color"),
						resultado.getFloat("precio"), resultado.getInt("idFabricante"), resultado.getString("ruta"),
						resultado.getInt("comprado"), resultado.getInt("alquilado"), resultado.getInt("numcomentarios"),
						resultado.getInt("numvaloraciones"));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return vehiculo;
	}

	/**
	 * Removes the.
	 *
	 * @param conexion the conexion
	 * @param vehiculo the vehiculo
	 * @throws SQLException the SQL exception
	 */
	public void remove(Connection conexion, Vehiculo vehiculo) throws SQLException {
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("DELETE FROM " + this.tabla + " WHERE idVehiculos = ?");
			consulta.setInt(1, vehiculo.getIdVehiculos());
			consulta.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	/**
	 * Gets the all vehiculos.
	 *
	 * @param conexion the conexion
	 * @return the all vehiculos
	 * @throws SQLException the SQL exception
	 */
	public List<Vehiculo> getAllVehiculos(Connection conexion) throws SQLException {
		List<Vehiculo> listaVehiculos = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante, comprado, alquilado"
							+ " FROM " + this.tabla);
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				listaVehiculos.add(new Vehiculo(resultado.getInt("idVehiculos"), resultado.getString("modelo"),
						resultado.getString("marca"), resultado.getInt("anyo"), resultado.getString("color"),
						resultado.getFloat("precio"), resultado.getInt("idFabricante")));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return listaVehiculos;
	}

	/**
	 * Gets the all vehiculos marca.
	 *
	 * @param conexion the conexion
	 * @return the all vehiculos marca
	 * @throws SQLException the SQL exception
	 */
	public List<Vehiculo> getAllVehiculosMarca(Connection conexion) throws SQLException {
		List<Vehiculo> listaVehiculos = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante " + " FROM "
							+ this.tabla + " ORDER BY marca");
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				listaVehiculos.add(new Vehiculo(resultado.getInt("idVehiculos"), resultado.getString("modelo"),
						resultado.getString("marca"), resultado.getInt("anyo"), resultado.getString("color"),
						resultado.getFloat("precio"), resultado.getInt("idFabricante")));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return listaVehiculos;
	}

	/**
	 * Gets the all vehiculos modelo.
	 *
	 * @param conexion the conexion
	 * @return the all vehiculos modelo
	 * @throws SQLException the SQL exception
	 */
	public List<Vehiculo> getAllVehiculosModelo(Connection conexion) throws SQLException {
		List<Vehiculo> listaVehiculos = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante " + " FROM "
							+ this.tabla + " ORDER BY modelo");
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				listaVehiculos.add(new Vehiculo(resultado.getInt("idVehiculos"), resultado.getString("modelo"),
						resultado.getString("marca"), resultado.getInt("anyo"), resultado.getString("color"),
						resultado.getFloat("precio"), resultado.getInt("idFabricante")));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return listaVehiculos;
	}

	/**
	 * Gets the all vehiculos anyo.
	 *
	 * @param conexion the conexion
	 * @return the all vehiculos anyo
	 * @throws SQLException the SQL exception
	 */
	public List<Vehiculo> getAllVehiculosAnyo(Connection conexion) throws SQLException {
		List<Vehiculo> listaVehiculos = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante " + " FROM "
							+ this.tabla + " ORDER BY anyo");
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				listaVehiculos.add(new Vehiculo(resultado.getInt("idVehiculos"), resultado.getString("modelo"),
						resultado.getString("marca"), resultado.getInt("anyo"), resultado.getString("color"),
						resultado.getFloat("precio"), resultado.getInt("idFabricante")));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return listaVehiculos;
	}

	/**
	 * Gets the all vehiculos color.
	 *
	 * @param conexion the conexion
	 * @return the all vehiculos color
	 * @throws SQLException the SQL exception
	 */
	public List<Vehiculo> getAllVehiculosColor(Connection conexion) throws SQLException {
		List<Vehiculo> listaVehiculos = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante " + " FROM "
							+ this.tabla + " ORDER BY color");
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				listaVehiculos.add(new Vehiculo(resultado.getInt("idVehiculos"), resultado.getString("modelo"),
						resultado.getString("marca"), resultado.getInt("anyo"), resultado.getString("color"),
						resultado.getFloat("precio"), resultado.getInt("idFabricante")));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return listaVehiculos;
	}

	/**
	 * Gets the all vehiculos precio.
	 *
	 * @param conexion the conexion
	 * @return the all vehiculos precio
	 * @throws SQLException the SQL exception
	 */
	public List<Vehiculo> getAllVehiculosPrecio(Connection conexion) throws SQLException {
		List<Vehiculo> listaVehiculos = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante " + " FROM "
							+ this.tabla + " ORDER BY precio");
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				listaVehiculos.add(new Vehiculo(resultado.getInt("idVehiculos"), resultado.getString("modelo"),
						resultado.getString("marca"), resultado.getInt("anyo"), resultado.getString("color"),
						resultado.getFloat("precio"), resultado.getInt("idFabricante")));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return listaVehiculos;
	}

	/**
	 * Gets the all vehiculosid fabricante.
	 *
	 * @param conexion the conexion
	 * @return the all vehiculosid fabricante
	 * @throws SQLException the SQL exception
	 */
	public List<Vehiculo> getAllVehiculosidFabricante(Connection conexion) throws SQLException {
		List<Vehiculo> listaVehiculos = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante " + " FROM "
							+ this.tabla + " ORDER BY idFabricante");
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				listaVehiculos.add(new Vehiculo(resultado.getInt("idVehiculos"), resultado.getString("modelo"),
						resultado.getString("marca"), resultado.getInt("anyo"), resultado.getString("color"),
						resultado.getFloat("precio"), resultado.getInt("idFabricante")));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return listaVehiculos;
	}

	/**
	 * Gets the all vehiculos fabric.
	 *
	 * @param conexion the conexion
	 * @return the all vehiculos fabric
	 * @throws SQLException the SQL exception
	 */
	public List<Vehiculo> getAllVehiculosFabric(Connection conexion) throws SQLException {
		List<Vehiculo> listaVehiculos = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante " + " FROM "
							+ this.tabla + " WHERE idFabricante = ?");
			consulta.setInt(1, ListViewFabricante.getidFabricanteCrear());
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				listaVehiculos.add(new Vehiculo(resultado.getInt("idVehiculos"), resultado.getString("modelo"),
						resultado.getString("marca"), resultado.getInt("anyo"), resultado.getString("color"),
						resultado.getFloat("precio"), resultado.getInt("idFabricante")));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return listaVehiculos;
	}

	/**
	 * Gets the all vehiculos cliente.
	 *
	 * @param conexion the conexion
	 * @return the all vehiculos cliente
	 * @throws SQLException the SQL exception
	 */
	public List<Vehiculo> getAllVehiculosCliente(Connection conexion) throws SQLException {
		List<Vehiculo> listaVehiculos = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT v.idVenta, v.fechaHora, ve.idVehiculos, ve.Modelo, ve.Marca, ve.Anyo, ve.Color, ve.Precio, ve.idFabricante "
							+ "FROM venta v, vehiculo ve " + "WHERE v.idVehiculo = ve.idVehiculos "
							+ "AND v.idCliente = ?;");
			consulta.setInt(1, Login.getidClienteLogin());
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				listaVehiculos.add(new Vehiculo(resultado.getInt("idVehiculos"), resultado.getString("modelo"),
						resultado.getString("marca"), resultado.getInt("anyo"), resultado.getString("color"),
						resultado.getFloat("precio"), resultado.getInt("idFabricante")));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return listaVehiculos;
	}

}
