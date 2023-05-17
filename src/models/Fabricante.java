package models;

public class Fabricante {
	private Integer idFabricante;
	private String nombre,pais;
	private Integer idCliente;
	
	
	public Fabricante(Integer idFabricante, String nombre, String pais, Integer idCliente) {
		super();
		this.idFabricante = idFabricante;
		this.nombre = nombre;
		this.pais = pais;
		this.idCliente = idCliente;
	}
	public Fabricante() {
		super();
	}
	public Integer getIdFabricante() {
		return idFabricante;
	}
	public void setIdFabricante(Integer idFabricante) {
		this.idFabricante = idFabricante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	@Override
	public String toString() {
		return "Fabricante [idFabricante=" + idFabricante + ", nombre=" + nombre + ", pais=" + pais + "]";
	}
	
}
