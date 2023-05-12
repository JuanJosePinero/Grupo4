package models;


public class Cliente {

	private Integer idClientes;
    private String nombre,direccion;
    private String rol;
    private String nombreUsuario,contrasena;
	public Integer getIdClientes() {
		return idClientes;
	}
	public void setIdClientes(Integer idClientes) {
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
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public Cliente(String nombre, String direccion, String rol, String nombreUsuario,
			String contrasena) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.rol = rol;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}
	public Cliente() {
		super();
	}
	@Override
	public String toString() {
		return "Cliente [idClientes=" + idClientes + ", nombre=" + nombre + ", direccion=" + direccion + ", rol=" + rol
				+ ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + "]";
	}
    
	

    
}
