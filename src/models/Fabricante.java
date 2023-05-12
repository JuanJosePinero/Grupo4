package models;

public class Fabricante {
	private Integer idFabricante;
	private String nombre,pais;
	public Fabricante(Integer idFabricante, String nombre, String pais) {
		super();
		this.idFabricante = idFabricante;
		this.nombre = nombre;
		this.pais = pais;
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
	@Override
	public String toString() {
		return "Fabricante [idFabricante=" + idFabricante + ", nombre=" + nombre + ", pais=" + pais + "]";
	}
	
}
