package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Fabricante;

// TODO: Auto-generated Javadoc
/**
 * The Class FabricantesService.
 */
public class FabricantesService {

	/** The tabla. */
	private final String tabla = "fabricante";

	/**
	 * Save.
	 *
	 * @param conexion   the conexion
	 * @param fabricante the fabricante
	 * @throws SQLException the SQL exception
	 */
	public void save(Connection conexion, Fabricante fabricante) throws SQLException {
		try {
			PreparedStatement consulta;
			if (fabricante.getIdFabricante() == null) {
				consulta = conexion
						.prepareStatement("INSERT INTO " + this.tabla + "(nombre, pais, idCliente) VALUES(?, ?, ?)");
				consulta.setString(1, fabricante.getNombre());
				consulta.setString(2, fabricante.getPais());
				consulta.setInt(3, fabricante.getIdCliente());
			} else {
				consulta = conexion.prepareStatement(
						"UPDATE " + this.tabla + " SET nombre = ?, pais = ?, idCliente = ? WHERE idFabricante = ?");
				consulta.setString(1, fabricante.getNombre());
				consulta.setString(2, fabricante.getPais());
				consulta.setInt(3, fabricante.getIdCliente());
				consulta.setInt(4, fabricante.getIdFabricante());
			}
			consulta.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	/**
	 * Gets the fabricantes.
	 *
	 * @param conexion the conexion
	 * @param id       the id
	 * @return the fabricantes
	 * @throws SQLException the SQL exception
	 */
	public Fabricante getFabricantes(Connection conexion, int id) throws SQLException {
		Fabricante fabricante = null;
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT idFabricante,nombre,pais,idCliente " + " FROM " + this.tabla + " WHERE idFabricante = ?");
			consulta.setInt(1, id);
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				fabricante = new Fabricante(id, resultado.getString("nombre"), resultado.getString("pais"),
						resultado.getInt("idCliente"));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return fabricante;
	}

	/**
	 * Gets the fabricantes cliente.
	 *
	 * @param conexion the conexion
	 * @param id       the id
	 * @return the fabricantes cliente
	 * @throws SQLException the SQL exception
	 */
	public Fabricante getFabricantesCliente(Connection conexion, int id) throws SQLException {
		Fabricante fabricante = null;
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT idFabricante,nombre,pais,idCliente " + " FROM " + this.tabla + " WHERE idCliente = ?");
			consulta.setInt(1, id);
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				fabricante = new Fabricante(id, resultado.getString("nombre"), resultado.getString("pais"),
						resultado.getInt("idFabricante"));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return fabricante;
	}

	/**
	 * Removes the.
	 *
	 * @param conexion   the conexion
	 * @param fabricante the fabricante
	 * @throws SQLException the SQL exception
	 */
	public void remove(Connection conexion, Fabricante fabricante) throws SQLException {
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("DELETE FROM " + this.tabla + " WHERE idFabricante = ?");
			consulta.setInt(1, fabricante.getIdFabricante());
			consulta.executeUpdate();
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
	}

	/**
	 * Gets the all fabricantes.
	 *
	 * @param conexion the conexion
	 * @return the all fabricantes
	 * @throws SQLException the SQL exception
	 */
	public List<Fabricante> getAllFabricantes(Connection conexion) throws SQLException {
		List<Fabricante> fabricante = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion
					.prepareStatement("SELECT idFabricante,nombre,pais,idCliente " + " FROM " + this.tabla);
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				fabricante.add(new Fabricante(resultado.getInt("idFabricante"), resultado.getString("nombre"),
						resultado.getString("pais"), resultado.getInt("idCliente")));
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return fabricante;
	}
}
