package Service;


import java.sql.*;
import java.util.*;

import models.Vehiculo;

public class VehiculoService {

	   private final String tabla = "vehiculo";
	   
	   public void save(Connection conexion, Vehiculo vehiculo) throws SQLException{
	      try{
	         PreparedStatement consulta;
	         if(vehiculo.getIdVehiculos() == null){
	            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(modelo, marca, anyo, color, precio, idFabricante) VALUES(?, ?, ?, ?, ?, ?)");
	            consulta.setString(1, vehiculo.getModelo());
	            consulta.setString(2, vehiculo.getMarca());
	            consulta.setInt(3, vehiculo.getAnyo());     
	            consulta.setString(4, vehiculo.getColor());
	            consulta.setFloat(5, vehiculo.getPrecio());
	            consulta.setInt(6, vehiculo.getIdFabricante());
	         }else{
	            consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET modelo = ?, marca = ?, anyo = ?, color = ?, precio = ?, idFabricante = ? WHERE idVehiculos = ?");
	            consulta.setString(1, vehiculo.getModelo());
	            consulta.setString(2, vehiculo.getMarca());
	            consulta.setInt(3, vehiculo.getAnyo());     
	            consulta.setString(4, vehiculo.getColor());
	            consulta.setFloat(5, vehiculo.getPrecio());
	            consulta.setInt(6, vehiculo.getIdFabricante());
	            consulta.setInt(7, vehiculo.getIdVehiculos());
	         }
	         consulta.executeUpdate();
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	   }
	   
	   public Vehiculo getVehiculo(Connection conexion) throws SQLException {
		   Vehiculo vehiculo = null;
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante"
	                 + " FROM " + this.tabla + " WHERE id = ?" );
	         ResultSet resultado = consulta.executeQuery();
	         while(resultado.next()){
	        	 vehiculo = new Vehiculo(resultado.getInt("idVehiculos"), resultado.getString("modelo"), resultado.getString("marca"), 
	                    resultado.getInt("anyo"), resultado.getString("color"), resultado.getFloat("precio"), resultado.getInt("idFabricante"));
	         }
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	      return vehiculo;
	   }
	   
	   public void remove(Connection conexion, Vehiculo vehiculo) throws SQLException{
	      try{
	         PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " 
	      + this.tabla + " WHERE idVehiculos = ?");
	         consulta.setInt(1, vehiculo.getIdVehiculos());
	         consulta.executeUpdate();
	      }catch(SQLException ex){
	         throw new SQLException(ex);
	      }
	   }
	   
	   public List<Vehiculo> getAllVehiculos(Connection conexion) throws SQLException {
		    List<Vehiculo> listaVehiculos = new ArrayList<>();
		    try {
		        PreparedStatement consulta = conexion.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante "
		                + " FROM " + this.tabla);
		        ResultSet resultado = consulta.executeQuery();
		        while (resultado.next()) {
		            listaVehiculos.add(new Vehiculo(resultado.getInt("idVehiculos"), resultado.getString("modelo"), resultado.getString("marca"), 
		                    resultado.getInt("anyo"), resultado.getString("color"), resultado.getFloat("precio"), resultado.getInt("idFabricante")));
		        }
		    } catch (SQLException ex) {
		        throw new SQLException(ex);
		    }
		    return listaVehiculos;
		}

	}
