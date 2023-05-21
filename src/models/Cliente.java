package models;

// TODO: Auto-generated Javadoc
/**
 * The Class Cliente.
 */
public class Cliente {

	/** The id clientes. */
	private Integer idClientes;

	/** The direccion. */
	private String nombre, direccion;

	/** The rol. */
	private String rol;

	/** The contrasena. */
	private String nombreUsuario, contrasena;

	/** The num valoraciones. */
	public int activar, numCompras, numAlquileres, numComentarios, numValoraciones;

	/**
	 * Gets the num compras.
	 *
	 * @return the num compras
	 */
	public int getNumCompras() {
		return numCompras;
	}

	/**
	 * Sets the num compras.
	 *
	 * @param numCompras the new num compras
	 */
	public void setNumCompras(int numCompras) {
		this.numCompras = numCompras;
	}

	/**
	 * Gets the num alquileres.
	 *
	 * @return the num alquileres
	 */
	public int getNumAlquileres() {
		return numAlquileres;
	}

	/**
	 * Sets the num alquileres.
	 *
	 * @param numAlquileres the new num alquileres
	 */
	public void setNumAlquileres(int numAlquileres) {
		this.numAlquileres = numAlquileres;
	}

	/**
	 * Gets the id clientes.
	 *
	 * @return the id clientes
	 */
	public Integer getIdClientes() {
		return idClientes;
	}

	/**
	 * Sets the id clientes.
	 *
	 * @param idClientes the new id clientes
	 */
	public void setIdClientes(Integer idClientes) {
		this.idClientes = idClientes;
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the direccion.
	 *
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Sets the direccion.
	 *
	 * @param direccion the new direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Gets the rol.
	 *
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * Sets the rol.
	 *
	 * @param rol the new rol
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * Gets the nombre usuario.
	 *
	 * @return the nombre usuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * Sets the nombre usuario.
	 *
	 * @param nombreUsuario the new nombre usuario
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * Gets the contrasena.
	 *
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * Sets the contrasena.
	 *
	 * @param contrasena the new contrasena
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * Gets the activar.
	 *
	 * @return the activar
	 */
	public int getActivar() {
		return activar;
	}

	/**
	 * Sets the activar.
	 *
	 * @param activar the new activar
	 */
	public void setActivar(int activar) {
		this.activar = activar;
	}

	/**
	 * Gets the num comentarios.
	 *
	 * @return the num comentarios
	 */
	public int getNumComentarios() {
		return numComentarios;
	}

	/**
	 * Sets the num comentarios.
	 *
	 * @param numComentarios the new num comentarios
	 */
	public void setNumComentarios(int numComentarios) {
		this.numComentarios = numComentarios;
	}

	/**
	 * Gets the num valoraciones.
	 *
	 * @return the num valoraciones
	 */
	public int getNumValoraciones() {
		return numValoraciones;
	}

	/**
	 * Sets the num valoracion.
	 *
	 * @param numValoraciones the new num valoracion
	 */
	public void setNumValoracion(int numValoraciones) {
		this.numValoraciones = numValoraciones;
	}

	/**
	 * Instantiates a new cliente.
	 */
	public Cliente() {
		super();
	}

	/**
	 * Instantiates a new cliente.
	 *
	 * @param nombre        the nombre
	 * @param direccion     the direccion
	 * @param rol           the rol
	 * @param nombreUsuario the nombre usuario
	 * @param contrasena    the contrasena
	 * @param activar       the activar
	 */
	public Cliente(String nombre, String direccion, String rol, String nombreUsuario, String contrasena, int activar) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.rol = rol;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.activar = activar;
	}

	/**
	 * Instantiates a new cliente.
	 *
	 * @param idClientes    the id clientes
	 * @param nombre        the nombre
	 * @param direccion     the direccion
	 * @param rol           the rol
	 * @param nombreUsuario the nombre usuario
	 * @param contrasena    the contrasena
	 * @param activar       the activar
	 */
	public Cliente(Integer idClientes, String nombre, String direccion, String rol, String nombreUsuario,
			String contrasena, int activar) {
		super();
		this.idClientes = idClientes;
		this.nombre = nombre;
		this.direccion = direccion;
		this.rol = rol;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.activar = activar;
	}

	/**
	 * Instantiates a new cliente.
	 *
	 * @param idClientes      the id clientes
	 * @param nombre          the nombre
	 * @param direccion       the direccion
	 * @param nombreUsuario   the nombre usuario
	 * @param contrasena      the contrasena
	 * @param numComentarios  the num comentarios
	 * @param numValoraciones the num valoraciones
	 */
	public Cliente(Integer idClientes, String nombre, String direccion, String nombreUsuario, String contrasena,
			int numComentarios, int numValoraciones) {
		super();
		this.idClientes = idClientes;
		this.nombre = nombre;
		this.direccion = direccion;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.numComentarios = numComentarios;
		this.numValoraciones = numValoraciones;
	}

	/**
	 * Instantiates a new cliente.
	 *
	 * @param idClientes    the id clientes
	 * @param nombre        the nombre
	 * @param direccion     the direccion
	 * @param rol           the rol
	 * @param nombreUsuario the nombre usuario
	 * @param contrasena    the contrasena
	 * @param activar       the activar
	 * @param numCompras    the num compras
	 */
	public Cliente(Integer idClientes, String nombre, String direccion, String rol, String nombreUsuario,
			String contrasena, int activar, int numCompras) {
		super();
		this.idClientes = idClientes;
		this.nombre = nombre;
		this.direccion = direccion;
		this.rol = rol;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.activar = activar;
		this.numCompras = numCompras;
	}

	/**
	 * Instantiates a new cliente.
	 *
	 * @param idClientes    the id clientes
	 * @param nombre        the nombre
	 * @param direccion     the direccion
	 * @param rol           the rol
	 * @param nombreUsuario the nombre usuario
	 * @param contrasena    the contrasena
	 * @param activar       the activar
	 * @param numCompras    the num compras
	 * @param numAlquileres the num alquileres
	 */
	public Cliente(Integer idClientes, String nombre, String direccion, String rol, String nombreUsuario,
			String contrasena, int activar, int numCompras, int numAlquileres) {
		super();
		this.idClientes = idClientes;
		this.nombre = nombre;
		this.direccion = direccion;
		this.rol = rol;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.activar = activar;
		this.numCompras = numCompras;
		this.numAlquileres = numAlquileres;

	}

	/**
	 * Instantiates a new cliente.
	 *
	 * @param idClientes      the id clientes
	 * @param nombre          the nombre
	 * @param direccion       the direccion
	 * @param rol             the rol
	 * @param nombreUsuario   the nombre usuario
	 * @param contrasena      the contrasena
	 * @param activar         the activar
	 * @param numCompras      the num compras
	 * @param numAlquileres   the num alquileres
	 * @param numComentarios  the num comentarios
	 * @param numValoraciones the num valoraciones
	 */
	public Cliente(Integer idClientes, String nombre, String direccion, String rol, String nombreUsuario,
			String contrasena, int activar, int numCompras, int numAlquileres, int numComentarios,
			int numValoraciones) {
		super();
		this.idClientes = idClientes;
		this.nombre = nombre;
		this.direccion = direccion;
		this.rol = rol;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.activar = activar;
		this.numCompras = numCompras;
		this.numAlquileres = numAlquileres;
		this.numComentarios = numComentarios;
		this.numValoraciones = numValoraciones;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Cliente [idClientes=" + idClientes + ", nombre=" + nombre + ", direccion=" + direccion + ", rol=" + rol
				+ ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + ", activar=" + activar
				+ ", numCompras=" + numCompras + ", numAlquileres=" + numAlquileres + ", numComentarios="
				+ numComentarios + ", numValoraciones=" + numValoraciones + "]";
	}

}
