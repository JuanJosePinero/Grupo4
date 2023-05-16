package Service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Views.ListViewFabricante;
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
	                 + " FROM " + this.tabla + " WHERE idVehiculos = ?" );
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
	   
	   public List<Vehiculo> getAllVehiculosMarca(Connection conexion) throws SQLException {
		    List<Vehiculo> listaVehiculos = new ArrayList<>();
		    try {
		        PreparedStatement consulta = conexion.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante "
		                + " FROM " + this.tabla+" ORDER BY marca");
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
	   
	   public List<Vehiculo> getAllVehiculosModelo(Connection conexion) throws SQLException {
		    List<Vehiculo> listaVehiculos = new ArrayList<>();
		    try {
		        PreparedStatement consulta = conexion.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante "
		                + " FROM " + this.tabla+" ORDER BY modelo");
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
	   
	   public List<Vehiculo> getAllVehiculosAnyo(Connection conexion) throws SQLException {
		    List<Vehiculo> listaVehiculos = new ArrayList<>();
		    try {
		        PreparedStatement consulta = conexion.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante "
		                + " FROM " + this.tabla+" ORDER BY anyo");
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
	   
	   public List<Vehiculo> getAllVehiculosColor(Connection conexion) throws SQLException {
		    List<Vehiculo> listaVehiculos = new ArrayList<>();
		    try {
		        PreparedStatement consulta = conexion.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante "
		                + " FROM " + this.tabla+" ORDER BY color");
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
	   
	   public List<Vehiculo> getAllVehiculosPrecio(Connection conexion) throws SQLException {
		    List<Vehiculo> listaVehiculos = new ArrayList<>();
		    try {
		        PreparedStatement consulta = conexion.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante "
		                + " FROM " + this.tabla+" ORDER BY precio");
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
	   
	   public List<Vehiculo> getAllVehiculosidFabricante(Connection conexion) throws SQLException {
		    List<Vehiculo> listaVehiculos = new ArrayList<>();
		    try {
		        PreparedStatement consulta = conexion.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante "
		                + " FROM " + this.tabla+" ORDER BY idFabricante");
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
	   
	   public List<Vehiculo> getAllVehiculosFabric(Connection conexion) throws SQLException {
		    List<Vehiculo> listaVehiculos = new ArrayList<>();
		    try {
		        PreparedStatement consulta = conexion.prepareStatement("SELECT idVehiculos, modelo, marca, anyo, color, precio, idFabricante "
		                + " FROM " + this.tabla+" WHERE idFabricante = ?");
		        consulta.setInt(1, ListViewFabricante.getidFabricanteCrear());
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
