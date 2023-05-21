package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Valoracion;
import models.Vehiculo;
import models.VehiculoMejoresValoraciones;

public class MejoresValoracionesService {

	public List<VehiculoMejoresValoraciones> getVehiculosMejoresValoraciones(Connection conexion) throws SQLException {
		List<VehiculoMejoresValoraciones> vehiculosMejoresValoraciones = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion.prepareStatement(
					"SELECT v.idVehiculos, v.modelo, v.marca, v.anyo, v.color, v.precio, v.idFabricante, v.comprado, v.alquilado, "
							+ "(SELECT AVG(valoracion) FROM valoracion WHERE idVehiculo = v.idVehiculos) AS media_valoracion "
							+ "FROM vehiculo v "
							+ "GROUP BY v.idVehiculos, v.modelo, v.marca, v.anyo, v.color, v.precio, v.idFabricante, v.comprado, v.alquilado "
							+ "ORDER BY media_valoracion DESC");

			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				int idVehiculo = resultado.getInt("idVehiculos");
				Vehiculo vehiculo = new Vehiculo(idVehiculo, resultado.getString("modelo"),
						resultado.getString("marca"), resultado.getInt("anyo"), resultado.getString("color"),
						resultado.getFloat("precio"), resultado.getInt("idFabricante"), resultado.getInt("comprado"),
						resultado.getInt("alquilado"));
				float mediaValoracion = resultado.getFloat("media_valoracion");

				List<Valoracion> valoraciones = getValoracionesVehiculo(conexion, idVehiculo);

				VehiculoMejoresValoraciones vehiculoMejoresValoraciones = new VehiculoMejoresValoraciones(vehiculo,
						valoraciones);
				vehiculosMejoresValoraciones.add(vehiculoMejoresValoraciones);
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return vehiculosMejoresValoraciones;
	}

	private List<Valoracion> getValoracionesVehiculo(Connection conexion, int idVehiculo) throws SQLException {
		List<Valoracion> valoraciones = new ArrayList<>();
		try {
			PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM valoracion WHERE idVehiculo = ?");
			consulta.setInt(1, idVehiculo);
			ResultSet resultado = consulta.executeQuery();
			while (resultado.next()) {
				int idCliente = resultado.getInt("idCliente");
				int idVehiculo1 = resultado.getInt("idVehiculo");
				int valor = resultado.getInt("Valoracion");
				Valoracion valoracion = new Valoracion(idCliente, idVehiculo1, valor);
				valoraciones.add(valoracion);
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		}
		return valoraciones;
	}

}
