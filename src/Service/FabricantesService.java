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
	            consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET nombre = ?, pais = ? WHERE id = ?");
	            consulta.setString(1, fabricante.getNombre());
	            consulta.setString(2, fabricante.getPais());
	            consulta.setInt(3, fabricante.getIdFabricante());
	         }
	         consulta.executeUpdate();
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	   }
	   
	   public Fabricante getProduct(Connection conexion, int id) throws SQLException {
	      Fabricante fabricante = null;
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT nombre,pais "
	                 + " FROM " + this.tabla + " WHERE id = ?" );
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
	      + this.tabla + " WHERE id = ?");
	         consulta.setInt(1, fabricante.getIdFabricante());
	         consulta.executeUpdate();
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	   }
	   
	   public List<Fabricante> getAllProducts(Connection conexion) throws SQLException{
	      List<Fabricante> products = new ArrayList<>();
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT id,nombre,precio "
	                 + " FROM " + this.tabla);
	         ResultSet resultado = consulta.executeQuery();
	         while(resultado.next()){
	            products.add(new Fabricante(resultado.getInt("id"), resultado.getString("nombre"), 
	                    resultado.getString("pais")));
	         }
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	      return products;
	   }
	
}
