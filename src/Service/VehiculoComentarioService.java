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

public class VehiculoComentarioService {
	
	public List<VehiculoConComentarios> getVehiculosConComentarios(Connection conexion) throws SQLException {
	    List<VehiculoConComentarios> vehiculosConComentarios = new ArrayList<>();
	    try {
	        PreparedStatement consulta = conexion.prepareStatement("SELECT v.idVehiculos, v.modelo, v.marca, v.anyo, v.color, v.precio, v.idFabricante, v.comprado, v.alquilado, c.idCliente, c.comentario"
	                + " FROM vehiculo v LEFT JOIN comentario c ON v.idVehiculos = c.idVehiculo ORDER BY numcomentarios DESC");
	        ResultSet resultado = consulta.executeQuery();
	        while (resultado.next()) {
	            int idVehiculo = resultado.getInt("idVehiculos");
	            Vehiculo vehiculo = new Vehiculo(idVehiculo, resultado.getString("modelo"), resultado.getString("marca"),
	                    resultado.getInt("anyo"), resultado.getString("color"), resultado.getFloat("precio"), resultado.getInt("idFabricante"),
	                    resultado.getInt("comprado"), resultado.getInt("alquilado"));
	            int idCliente = resultado.getInt("idCliente");
	            String comentario = resultado.getString("comentario");
	            Comentario comentarioObj = null;
	            if (idCliente != 0 && comentario != null) {
	                comentarioObj = new Comentario(idCliente, idVehiculo, comentario);
	            }

	            VehiculoConComentarios vehiculoConComentarios = null;
	            for (VehiculoConComentarios vc : vehiculosConComentarios) {
	                if (vc.getVehiculo().getIdVehiculos() == idVehiculo) {
	                    vehiculoConComentarios = vc;
	                    break;
	                }
	            }

	            if (vehiculoConComentarios == null) {
	                vehiculoConComentarios = new VehiculoConComentarios(vehiculo, new ArrayList<>());
	                vehiculosConComentarios.add(vehiculoConComentarios);
	            }

	            if (comentarioObj != null) {
	                vehiculoConComentarios.getComentarios().add(comentarioObj);
	            }
	        }
	    } catch (SQLException ex) {
	        throw new SQLException(ex);
	    }
	    return vehiculosConComentarios;
	}



}
