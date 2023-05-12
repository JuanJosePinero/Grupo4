package models;

public class Usuario {
	private Integer id;
	private String nombre,contrasena;
	
	public Usuario() {
		super();
	}

	public Usuario(Integer id, String nombreUsuario, String contraseña) {
		super();
		this.id = id;
		this.nombre = nombreUsuario;
		this.contrasena = contraseña;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombre;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombre = nombreUsuario;
	}

	public String getContraseña() {
		return contrasena;
	}

	public void setContraseña(String contraseña) {
		this.contrasena = contraseña;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombre + ", contraseña=" + contrasena + "]";
	}
	
	

}