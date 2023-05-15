package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Cliente;

public class ClientService {
	 private final String tabla = "cliente";
	   
	 public void save(Connection conexion, Cliente cliente) throws SQLException{
	      try{
	         PreparedStatement consulta;
	         if(cliente.getIdClientes() == null){
	            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombre, direccion,rol,usuario,Contasenya,Activar) VALUES(?, ?, ?, ?, ?, ?)");
	            consulta.setString(1,cliente.getNombre());
	            consulta.setString(2, cliente.getDireccion());
	            consulta.setString(3, cliente.getRol());
	            consulta.setString(4, cliente.getNombreUsuario());
	            consulta.setString(5, cliente.getContrasena());
	            consulta.setInt(6, cliente.getActivar());
	         }else{
	            consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET nombre = ?, direccion = ?,rol = ?, usuario = ?, Contasenya = ? Activar = ? WHERE idCliente = ?");
	            consulta.setString(1,cliente.getNombre());
	            consulta.setString(2, cliente.getDireccion());
	            consulta.setString(3, cliente.getRol());
	            consulta.setString(4, cliente.getNombreUsuario());
	            consulta.setString(5, cliente.getContrasena());
	            consulta.setInt(6, cliente.getActivar());
	            consulta.setInt(7, cliente.getIdClientes());
	         }
	         consulta.executeUpdate();
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	   }
	
	 
	 public Cliente getCliente(Connection conexion, String nombreUsuario) throws SQLException {
		   Cliente cliente = null;
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT idCliente,nombre, direccion,rol,usuario,Contasenya,Activar "
	                 + " FROM " + this.tabla + " WHERE usuario = ?" );
	         consulta.setString(1, nombreUsuario);
	         ResultSet resultado = consulta.executeQuery();
	         while(resultado.next()){
	        	 cliente = new Cliente(resultado.getInt("idCliente"), resultado.getString("nombre"), 
	                    resultado.getString("direccion"),resultado.getString("rol"),resultado.getString("usuario"),resultado.getString("Contasenya"));
	         }
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	      return cliente;
	   }
	 
	 public Cliente getClienteId(Connection conexion,int id) throws SQLException {
		   Cliente cliente = null;
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT idCliente, nombre, direccion,rol,usuario,Contasenya,Activar "
	                 + " FROM " + this.tabla + " WHERE idCliente = ?" );
	         ResultSet resultado = consulta.executeQuery();
	         consulta.setInt(1, id);
	         while(resultado.next()){
	        	 cliente = new Cliente(resultado.getInt("idCliente"),resultado.getString("nombre"), 
	                    resultado.getString("direccion"),resultado.getString("rol"),resultado.getString("usuario"),resultado.getString("Contasenya"));
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
	         PreparedStatement consulta = conexion.prepareStatement("SELECT idCliente,nombre,direccion ,rol,usuario,contasenya,Activar"
	                 + " FROM " + this.tabla);
	         ResultSet resultado = consulta.executeQuery();
	         while(resultado.next()){
	        	 cliente.add(new Cliente(resultado.getString("nombre"), 
	                    resultado.getString("direccion"),resultado.getString("rol"),resultado.getString("usuario"),resultado.getString("contasenya")));
	         }
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	      return cliente;
	   }
	   
}
