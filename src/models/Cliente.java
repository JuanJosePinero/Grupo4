package models;

public class Cliente {

	private int idClientes;
	private String nombre,direccion;
	
	public int getIdClientes() {
		return idClientes;
	}
	public void setIdClientes(int idClientes) {
		this.idClientes = idClientes;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Cliente(int idClientes, String nombre, String direccion) {
		super();
		this.idClientes = idClientes;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	public Cliente() {
		super();
	}
	@Override
	public String toString() {
		return "Cliente id=" + idClientes + ", nombre=" + nombre + ", direccion=" + direccion + "";
	}
}
