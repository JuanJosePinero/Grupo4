package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Comentario;


public class ComentarioService {

	private final String tabla= "comentario";
	
	  public void save(Connection conexion, Comentario comentario) throws SQLException{
	      try{
	         PreparedStatement consulta;
	         if(comentario.getIdCliente() == null){
	            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(idCliente,idVehiculo,comentario) VALUES(?, ?, ?)");
	            consulta.setInt(1, comentario.getIdCliente());
	            consulta.setInt(2, comentario.getIdVehiculo());
	            consulta.setString(3, comentario.getComentario());

	         }else{
	            consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET idCliente = ?, idVehiculo = ?, comentario  = ? WHERE idCliente = ?");
	            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(idCliente,idVehiculo,comentario) VALUES(?, ?, ?)");
	            consulta.setInt(1, comentario.getIdCliente());
	            consulta.setInt(2, comentario.getIdVehiculo());
	            consulta.setString(3, comentario.getComentario());
	         }
	         consulta.executeUpdate();
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	   }
	   
	   public Comentario getComentario(Connection conexion) throws SQLException {
		   Comentario comentario = null;
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT idVenta,idCliente,idVehiculo,comentario "
	                 + " FROM " + this.tabla + " WHERE idVenta = ?" );
	         ResultSet resultado = consulta.executeQuery();
	         while(resultado.next()){
	            comentario = new Comentario( resultado.getInt("idCliente"), resultado.getInt("idVehiculo"), resultado.getString("comentario"));
	         }
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	      return comentario;
	   }
	   
	   public void remove(Connection conexion, Comentario comentario) throws SQLException{
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " 
	      + this.tabla + " WHERE idCliente = ?");
	         consulta.setInt(1, comentario.getIdCliente());
	         consulta.executeUpdate();
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	   }
	   
	   public List<Comentario> getAllComentario(Connection conexion) throws SQLException{
	      List<Comentario> products = new ArrayList<>();
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT idCliente,idVehiculo,comentario "
	                 + " FROM " + this.tabla);
	         ResultSet resultado = consulta.executeQuery();
	         while(resultado.next()){
	            products.add(new Comentario(resultado.getInt("idCliente"), resultado.getInt("idVehiculo"), resultado.getString("comentario")));
	         }
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	      return products;
	   }
	
}
