package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Fabricante;



public class FabricantesService {

	private final String tabla= "fabricante";
	
	  public void save(Connection conexion, Fabricante fabricante) throws SQLException{
	      try{
	         PreparedStatement consulta;
	         if(fabricante.getIdFabricante() == null){
	            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombre, pais) VALUES(?, ?)");
	            consulta.setString(1, fabricante.getNombre());
	            consulta.setString(2, fabricante.getPais());
	         }else{
	            consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET nombre = ?, pais = ? WHERE idFabricante = ?");
	            consulta.setString(1, fabricante.getNombre());
	            consulta.setString(2, fabricante.getPais());
	            consulta.setInt(3, fabricante.getIdFabricante());
	         }
	         consulta.executeUpdate();
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	   }
	   
	   public Fabricante getFabricantes(Connection conexion, int id) throws SQLException {
	      Fabricante fabricante = null;
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT idFabricante,nombre,pais "
	                 + " FROM " + this.tabla + " WHERE idFabricante = ?" );
	         consulta.setInt(1, id);
	         ResultSet resultado = consulta.executeQuery();
	         while(resultado.next()){
	            fabricante = new Fabricante(id, resultado.getString("nombre"), 
	                    resultado.getString("pais"));
	         }
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	      return fabricante;
	   }
	   
	   public void remove(Connection conexion, Fabricante fabricante) throws SQLException{
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " 
	      + this.tabla + " WHERE idFabricante = ?");
	         consulta.setInt(1, fabricante.getIdFabricante());
	         consulta.executeUpdate();
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	   }
	   
	   public List<Fabricante> getAllFabricantes(Connection conexion) throws SQLException{
	      List<Fabricante> fabricante = new ArrayList<>();
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT idFabricante,nombre,pais "
	                 + " FROM " + this.tabla);
	         ResultSet resultado = consulta.executeQuery();
	         while(resultado.next()){
	        	 fabricante.add(new Fabricante(resultado.getInt("idFabricante"), resultado.getString("nombre"), 
	                    resultado.getString("pais")));
	         }
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	      return fabricante;
	   }
	
}
