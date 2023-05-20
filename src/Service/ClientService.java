package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Cliente;
import models.Vehiculo;

public class ClientService {
	 private final String tabla = "cliente";
	   
	 public void save(Connection conexion, Cliente cliente) throws SQLException{
	      try{
	         PreparedStatement consulta;
	         if(cliente.getIdClientes() == null){
	            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombre, direccion,rol,usuario,Contasenya,Activar,numCompras,numAlquileres,numcomentarios,numvaloraciones) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	            consulta.setString(1,cliente.getNombre());
	            consulta.setString(2, cliente.getDireccion());
	            consulta.setString(3, cliente.getRol());
	            consulta.setString(4, cliente.getNombreUsuario());
	            consulta.setString(5, cliente.getContrasena());
	            consulta.setInt(6, cliente.getActivar());
	            consulta.setInt(7, cliente.getNumCompras());
	            consulta.setInt(8, cliente.getNumAlquileres());
	            consulta.setInt(9, cliente.getNumComentarios());
	            consulta.setInt(10, cliente.getNumValoracion());
	            
	         }else{
	            consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET nombre = ?, direccion = ?,rol = ?, usuario = ?, Contasenya = ?, Activar = ?, numCompras = ?, numAlquileres = ?, numcomentarios = ?, numvaloraciones = ? WHERE idCliente = ?");
	            consulta.setString(1,cliente.getNombre());
	            consulta.setString(2, cliente.getDireccion());
	            consulta.setString(3, cliente.getRol());
	            consulta.setString(4, cliente.getNombreUsuario());
	            consulta.setString(5, cliente.getContrasena());
	            consulta.setInt(6, cliente.getActivar());
	            consulta.setInt(7, cliente.getNumCompras());
	            consulta.setInt(8, cliente.getNumAlquileres());
	            consulta.setInt(9, cliente.getNumComentarios());
	            consulta.setInt(10, cliente.getNumValoracion());
	            consulta.setInt(11, cliente.getIdClientes());
	         }
	         consulta.executeUpdate();
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	   }
	
	 public Cliente getCliente(Connection conexion, String nombreUsuario) throws SQLException {
		   Cliente cliente = null;
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT idCliente,nombre, direccion,rol,usuario,Contasenya,Activar,numCompras,numAlquileres,numcomentarios,numvaloraciones "
	                 + " FROM " + this.tabla + " WHERE usuario = ?" );
	         consulta.setString(1, nombreUsuario);
	         ResultSet resultado = consulta.executeQuery();
	         while(resultado.next()){
	        	 cliente = new Cliente(resultado.getInt("idCliente"), resultado.getString("nombre"), 
	                    resultado.getString("direccion"),resultado.getString("rol"),resultado.getString("usuario"),resultado.getString("Contasenya"),resultado.getInt("Activar"),
	                    resultado.getInt("numCompras"),resultado.getInt("numAlquileres"),resultado.getInt("numcomentarios"),resultado.getInt("numvaloraciones"));
	         }
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	      return cliente;
	   }
	 public Cliente getClienteId(Connection conexion, int id) throws SQLException {
		   Cliente cliente = null;
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT idCliente,nombre, direccion,rol,usuario,Contasenya,Activar,numCompras,numAlquileres,numcomentarios,numvaloraciones "
	                 + " FROM " + this.tabla + " WHERE idCliente = ?" );
	         consulta.setInt(1, id);
	         ResultSet resultado = consulta.executeQuery();
	         while(resultado.next()){
	        	 cliente = new Cliente(resultado.getInt("idCliente"), resultado.getString("nombre"), 
		                    resultado.getString("direccion"),resultado.getString("rol"),resultado.getString("usuario"),resultado.getString("Contasenya"),resultado.getInt("Activar"),
		                    resultado.getInt("numCompras"),resultado.getInt("numAlquileres"),resultado.getInt("numcomentarios"),resultado.getInt("numvaloraciones"));
	         }
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	      return cliente;
	   }
	 
	 
	
	 
	 public void remove(Connection conexion, Cliente cliente) throws SQLException{
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " 
	      + this.tabla + " WHERE id = ?");
	         consulta.setInt(1, cliente.getIdClientes());
	         consulta.executeUpdate();
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	   }
	 
	 public List<Cliente> getAllCliente(Connection conexion) throws SQLException{
	      List<Cliente> cliente = new ArrayList<>();
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT idCliente,nombre,direccion ,rol,usuario,contasenya,Activar,numCompras,numAlquileres"
	                 + " FROM " + this.tabla);
	         ResultSet resultado = consulta.executeQuery();
	         while(resultado.next()){
	        	 cliente.add(new Cliente(resultado.getInt("idCliente"),resultado.getString("nombre"), 
	                    resultado.getString("direccion"),resultado.getString("rol"),resultado.getString("usuario"),resultado.getString("contasenya"),resultado.getInt("Activar")));
	         }
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	      return cliente;
	   }
	 
	 public List<Cliente> getAllRolCliente(Connection conexion) throws SQLException{
	      List<Cliente> cliente = new ArrayList<>();
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT idCliente,nombre,direccion,rol,usuario,contasenya,Activar"
	                 + " FROM " + this.tabla+ " WHERE rol = 'Cliente'");
	         ResultSet resultado = consulta.executeQuery();
	         while(resultado.next()){
	        	 cliente.add(new Cliente(resultado.getInt("idCliente"),resultado.getString("nombre"), 
	                    resultado.getString("direccion"),resultado.getString("rol"),resultado.getString("usuario"),resultado.getString("contasenya"),resultado.getInt("Activar")));
	         }
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	      return cliente;
	   }
	 
	 public List<Cliente> getComprasCliente(Connection conexion) throws SQLException {
		    List<Cliente> cliente = new ArrayList<>();
		    try {
		    	 PreparedStatement consulta = conexion.prepareStatement(
		    	            "SELECT cliente.idCliente, cliente.nombre, cliente.direccion, cliente.rol, cliente.usuario, cliente.contasenya, cliente.Activar, " +
		    	            "(SELECT COUNT(idCliente) FROM venta WHERE venta.idCliente = cliente.idCliente) AS numCompras, " +
		    	            "(SELECT COUNT(idCliente) FROM alquiler WHERE alquiler.idCliente = cliente.idCliente) AS numAlquileres " +
		    	            "FROM " + this.tabla +
		    	            " WHERE cliente.rol = 'Cliente' " +
		    	            "ORDER BY numCompras DESC"
		    	        );
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
		            cliente.add(new Cliente(id, nombre, direccion, rol, usuario, contrasenya, activar, numCompras, numAlquileres));
		        }
		    } catch (SQLException ex) {
		        throw new SQLException(ex);
		    }
		    return cliente;
		}
	 
	 public List<Cliente> getAlquileresCliente(Connection conexion) throws SQLException {
		    List<Cliente> cliente = new ArrayList<>();
		    try {
		        PreparedStatement consulta = conexion.prepareStatement("SELECT cliente.idCliente, cliente.nombre, cliente.direccion, cliente.rol, cliente.usuario, cliente.contasenya, cliente.Activar, COUNT(venta.idCliente) AS numCompras, COUNT(alquiler.idCliente) AS numAlquileres " +
		        		"FROM " + this.tabla +
		                " LEFT JOIN venta ON cliente.idCliente = venta.idCliente LEFT JOIN alquiler ON cliente.idCliente = alquiler.idCliente" +
		                "WHERE cliente.rol = 'Cliente' " +
		                "GROUP BY cliente.idCliente " +
		                "ORDER BY numAlquileres DESC");
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
		            cliente.add(new Cliente(id, nombre, direccion, rol, usuario, contrasenya, activar, numCompras, numAlquileres));
		        }
		    } catch (SQLException ex) {
		        throw new SQLException(ex);
		    }
		    return cliente;
		}
	 
	   
}
