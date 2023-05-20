package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Views.Login;
import models.Comentario;
import models.Valoracion;

public class ValoracionService {

	private final String tabla= "valoracion";
	
	  public void save(Connection conexion, Valoracion valoracion) throws SQLException{
	      try{
	         PreparedStatement consulta;
	         if(valoracion.getIdCliente() == null){
	            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(idCliente,idVehiculo,valoracion) VALUES(?, ?, ?)");
	            consulta.setInt(1, valoracion.getIdCliente());
	            consulta.setInt(2, valoracion.getIdVehiculo());
	            consulta.setInt(3, valoracion.getValoracion());

	         }else{
	            consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET idCliente = ?, idVehiculo = ?, valoracion  = ? WHERE idCliente = ?");
	            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(idCliente,idVehiculo,valoracion) VALUES(?, ?, ?)");
	            consulta.setInt(1, valoracion.getIdCliente());
	            consulta.setInt(2, valoracion.getIdVehiculo());
	            consulta.setInt(3, valoracion.getValoracion());
	         }
	         consulta.executeUpdate();
	      }catch(SQLException ex){
	     JOptionPane.showMessageDialog(null, "Ya has enviado una valoracion");
	      }
	   }
	   
	   public Valoracion getValoracion(Connection conexion) throws SQLException {
		   Valoracion valoracion = null;
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT idVenta,idCliente,idVehiculo,valoracion "
	                 + " FROM " + this.tabla + " WHERE idVenta = ?" );
	         ResultSet resultado = consulta.executeQuery();
	         while(resultado.next()){
	        	 valoracion = new Valoracion( resultado.getInt("idCliente"), resultado.getInt("idVehiculo"), resultado.getInt("valoracion"));
	         }
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	      return valoracion;
	   }
	   
	   public void remove(Connection conexion, Valoracion valoracion) throws SQLException{
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " 
	      + this.tabla + " WHERE idCliente = ?");
	         consulta.setInt(1, valoracion.getIdCliente());
	         consulta.executeUpdate();
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	   }
	   public List<Valoracion> getAllValoracionId(Connection conexion) throws SQLException{
		      List<Valoracion> products = new ArrayList<>();
		      try{
		         PreparedStatement consulta = conexion.prepareStatement("SELECT idCliente,idVehiculo,valoracion "
		                 + " FROM " + this.tabla+ " WHERE idVehiculo = ?");
		         consulta.setInt(1, Login.getidVehiculo());
		         ResultSet resultado = consulta.executeQuery();
		         while(resultado.next()){
		            products.add(new Valoracion(resultado.getInt("idCliente"), resultado.getInt("idVehiculo"), resultado.getInt("valoracion")));
		         }
		      }catch(SQLException ex){
		         throw new SQLException(ex);
		      }
		      return products;
		   }
	   
	   public List<Valoracion> getAllValoracion(Connection conexion) throws SQLException{
	      List<Valoracion> products = new ArrayList<>();
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT idCliente,idVehiculo,valoracion "
	                 + " FROM " + this.tabla);
	         ResultSet resultado = consulta.executeQuery();
	         while(resultado.next()){
	            products.add(new Valoracion(resultado.getInt("idCliente"), resultado.getInt("idVehiculo"), resultado.getInt("valoracion")));
	         }
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	      return products;
	   }
	
}
