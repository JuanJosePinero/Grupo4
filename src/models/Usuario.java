package models;

public class Usuario {
	private Integer id;
	private String nombre,contraseña;
	
	public Usuario() {
		super();
	}

	public Usuario(Integer id, String nombreUsuario, String contraseña) {
		super();
		this.id = id;
		this.nombre = nombreUsuario;
		this.contraseña = contraseña;
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
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombre + ", contraseña=" + contraseña + "]";
	}
	
	

}