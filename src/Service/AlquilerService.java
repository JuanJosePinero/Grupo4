package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Alquiler;

public class AlquilerService {

	private final String tabla= "alquiler";
	
	  public void save(Connection conexion, Alquiler alquiler) throws SQLException{
	      try{
	         PreparedStatement consulta;
	         if(alquiler.getIdAlquiler() == null){
	            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(idCliente,idVehiculo,fechaInic,fechFin) VALUES(?, ?, ?, ?)");
	            consulta.setInt(1, alquiler.getIdCliente());
	            consulta.setInt(2, alquiler.getIdVehiculo());
//	            consulta.setDate(3, alquiler.getFechaInic());
//	            consulta.setDate(4, alquiler.getFechaFin());
	         }else{
	            consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET idCliente = ?, idVehiculo = ?, fechaInic  = ?, fechFin  = ? WHERE idAlquiler = ?");
	            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(idCliente,idVehiculo,fechaInic,fechFin) VALUES(?, ?, ?, ?)");
	            consulta.setInt(1, alquiler.getIdCliente());
	            consulta.setInt(2, alquiler.getIdVehiculo());
//	            consulta.setDate(3, alquiler.getFechaInic());
//	            consulta.setDate(4, alquiler.getFechaFin());
	            consulta.setInt(5, alquiler.getIdAlquiler());
	         }
	         consulta.executeUpdate();
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	   }
	   
	   public Alquiler getAlquiler(Connection conexion) throws SQLException {
		   Alquiler alquiler = null;
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT idAlquiler,idCliente,idVehiculo,fechaInic,fechFin "
	                 + " FROM " + this.tabla + " WHERE idAlquiler = ?" );
	         ResultSet resultado = consulta.executeQuery();
	         while(resultado.next()){
	        	 alquiler = new Alquiler(resultado.getInt("idAlquiler"), resultado.getInt("idCliente"), 
	            		resultado.getInt("idVehiculo"), resultado.getDate("fechaInic"), resultado.getDate("fechaFin"));
	         }
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	      return alquiler;
	   }
	   
	   public void remove(Connection conexion, Alquiler alquiler) throws SQLException{
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " 
	      + this.tabla + " WHERE idVenta = ?");
	         consulta.setInt(1, alquiler.getIdAlquiler());
	         consulta.executeUpdate();
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	   }
	   
	   public List<Alquiler> getAllAlquileres(Connection conexion) throws SQLException{
	      List<Alquiler> products = new ArrayList<>();
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT idAlquiler,idCliente,idVehiculo,fechaInic,fechFin "
	                 + " FROM " + this.tabla);
	         ResultSet resultado = consulta.executeQuery();
	         while(resultado.next()){
	            products.add(new Alquiler(resultado.getInt("idAlquiler"), resultado.getInt("idCliente"), 
	            		resultado.getInt("idVehiculo"), resultado.getDate("fechaInic"), resultado.getDate("fechaFin")));
	         }
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	      return products;
	   }
	
}