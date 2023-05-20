package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Comentario;
import models.Vehiculo;
import models.VehiculoConComentarios;
import models.VehiculoMejoresValoraciones;

public class MejoresValoracionesService {

	public List<VehiculoMejoresValoraciones> getVehiculosMejoresValoraciones(Connection conexion) throws SQLException {
        List<VehiculoMejoresValoraciones> vehiculosMejoresValoraciones = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT v.idVehiculos, v.modelo, v.marca, v.anyo, v.color, v.precio, v.idFabricante, v.comprado, v.alquilado, AVG(c.valoracion) AS media_valoracion"
                    + " FROM vehiculo v LEFT JOIN valoracion c ON v.idVehiculos = c.idVehiculo GROUP BY v.idVehiculos, v.modelo, v.marca, v.anyo, v.color, v.precio, v.idFabricante, v.comprado, v.alquilado");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                int idVehiculo = resultado.getInt("idVehiculos");
                Vehiculo vehiculo = new Vehiculo(idVehiculo, resultado.getString("modelo"), resultado.getString("marca"),
                        resultado.getInt("anyo"), resultado.getString("color"), resultado.getFloat("precio"), resultado.getInt("idFabricante"),
                        resultado.getInt("comprado"), resultado.getInt("alquilado"));
                float mediaValoracion = resultado.getFloat("media_valoracion");

                VehiculoMejoresValoraciones vehiculoMejoresValoraciones = new VehiculoMejoresValoraciones(vehiculo, new ArrayList<>());
                vehiculosMejoresValoraciones.add(vehiculoMejoresValoraciones);
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return vehiculosMejoresValoraciones;
    }
	
}
