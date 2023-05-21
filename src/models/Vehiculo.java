package models;

// TODO: Auto-generated Javadoc
/**
 * The Class Vehiculo.
 */
public class Vehiculo {

	/** The id vehiculos. */
	private Integer idVehiculos;

	/** The marca. */
	private String modelo, marca;

	/** The anyo. */
	private int anyo;

	/** The color. */
	private String color;

	/** The precio. */
	private float precio;

	/** The id fabricante. */
	private Integer idFabricante;

	/** The ruta. */
	private String ruta;

	/** The numvaloraciones. */
	private int comprado = 0, alquilado = 0, numcomentarios = 0, numvaloraciones = 0;

	/**
	 * Gets the ruta.
	 *
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}

	/**
	 * Sets the ruta.
	 *
	 * @param ruta the new ruta
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	/**
	 * Gets the id vehiculos.
	 *
	 * @return the id vehiculos
	 */
	public Integer getIdVehiculos() {
		return idVehiculos;
	}

	/**
	 * Sets the id vehiculos.
	 *
	 * @param idVehiculo the new id vehiculos
	 */
	public void setIdVehiculos(Integer idVehiculo) {
		this.idVehiculos = idVehiculo;
	}

	/**
	 * Gets the modelo.
	 *
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Sets the modelo.
	 *
	 * @param modelo the new modelo
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Gets the marca.
	 *
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Sets the marca.
	 *
	 * @param marca the new marca
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Gets the anyo.
	 *
	 * @return the anyo
	 */
	public int getAnyo() {
		return anyo;
	}

	/**
	 * Sets the anyo.
	 *
	 * @param anyo the new anyo
	 */
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Gets the precio.
	 *
	 * @return the precio
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Sets the precio.
	 *
	 * @param precio the new precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

	/**
	 * Gets the id fabricante.
	 *
	 * @return the id fabricante
	 */
	public Integer getIdFabricante() {
		return idFabricante;
	}

	/**
	 * Sets the id fabricante.
	 *
	 * @param idFabricante the new id fabricante
	 */
	public void setIdFabricante(Integer idFabricante) {
		this.idFabricante = idFabricante;
	}

	/**
	 * Gets the comprado.
	 *
	 * @return the comprado
	 */
	public int getComprado() {
		return comprado;
	}

	/**
	 * Sets the comprado.
	 *
	 * @param comprado the new comprado
	 */
	public void setComprado(int comprado) {
		this.comprado = comprado;
	}

	/**
	 * Gets the numcomentarios.
	 *
	 * @return the numcomentarios
	 */
	public int getNumcomentarios() {
		return numcomentarios;
	}

	/**
	 * Sets the numcomentarios.
	 *
	 * @param numcomentarios the new numcomentarios
	 */
	public void setNumcomentarios(int numcomentarios) {
		this.numcomentarios = numcomentarios;
	}

	/**
	 * Gets the alquilado.
	 *
	 * @return the alquilado
	 */
	public int getAlquilado() {
		return alquilado;
	}

	/**
	 * Sets the alquilado.
	 *
	 * @param alquilado the new alquilado
	 */
	public void setAlquilado(int alquilado) {
		this.alquilado = alquilado;
	}

	/**
	 * Gets the numvaloraciones.
	 *
	 * @return the numvaloraciones
	 */
	public int getNumvaloraciones() {
		return numvaloraciones;
	}

	/**
	 * Sets the numvaloraciones.
	 *
	 * @param numvaloraciones the new numvaloraciones
	 */
	public void setNumvaloraciones(int numvaloraciones) {
		this.numvaloraciones = numvaloraciones;
	}

	/**
	 * Instantiates a new vehiculo.
	 */
	public Vehiculo() {
		super();
	}

	/**
	 * Instantiates a new vehiculo.
	 *
	 * @param idVehiculos  the id vehiculos
	 * @param modelo       the modelo
	 * @param marca        the marca
	 * @param anyo         the anyo
	 * @param color        the color
	 * @param precio       the precio
	 * @param idFabricante the id fabricante
	 * @param ruta         the ruta
	 */
	public Vehiculo(Integer idVehiculos, String modelo, String marca, int anyo, String color, float precio,
			Integer idFabricante, String ruta) {
		super();
		this.idVehiculos = idVehiculos;
		this.modelo = modelo;
		this.marca = marca;
		this.anyo = anyo;
		this.color = color;
		this.precio = precio;
		this.idFabricante = idFabricante;
		this.ruta = ruta;
	}

	/**
	 * Instantiates a new vehiculo.
	 *
	 * @param idVehiculos  the id vehiculos
	 * @param modelo       the modelo
	 * @param marca        the marca
	 * @param anyo         the anyo
	 * @param color        the color
	 * @param precio       the precio
	 * @param idFabricante the id fabricante
	 * @param compra       the compra
	 * @param alqui        the alqui
	 */
	public Vehiculo(Integer idVehiculos, String modelo, String marca, int anyo, String color, float precio,
			Integer idFabricante, int compra, int alqui) {
		super();
		this.idVehiculos = idVehiculos;
		this.modelo = modelo;
		this.marca = marca;
		this.anyo = anyo;
		this.color = color;
		this.precio = precio;
		this.idFabricante = idFabricante;
		this.comprado = compra;
		this.alquilado = alqui;
	}

	/**
	 * Instantiates a new vehiculo.
	 *
	 * @param idVehiculos  the id vehiculos
	 * @param modelo       the modelo
	 * @param marca        the marca
	 * @param anyo         the anyo
	 * @param color        the color
	 * @param precio       the precio
	 * @param idFabricante the id fabricante
	 */
	public Vehiculo(Integer idVehiculos, String modelo, String marca, int anyo, String color, float precio,
			Integer idFabricante) {
		super();
		this.idVehiculos = idVehiculos;
		this.modelo = modelo;
		this.marca = marca;
		this.anyo = anyo;
		this.color = color;
		this.precio = precio;
		this.idFabricante = idFabricante;
	}

	/**
	 * Instantiates a new vehiculo.
	 *
	 * @param idVehiculos  the id vehiculos
	 * @param modelo       the modelo
	 * @param marca        the marca
	 * @param anyo         the anyo
	 * @param color        the color
	 * @param precio       the precio
	 * @param idFabricante the id fabricante
	 * @param compra       the compra
	 * @param alqui        the alqui
	 * @param numcom       the numcom
	 * @param numval       the numval
	 */
	public Vehiculo(Integer idVehiculos, String modelo, String marca, int anyo, String color, float precio,
			Integer idFabricante, int compra, int alqui, int numcom, int numval) {
		super();
		this.idVehiculos = idVehiculos;
		this.modelo = modelo;
		this.marca = marca;
		this.anyo = anyo;
		this.color = color;
		this.precio = precio;
		this.idFabricante = idFabricante;
		this.comprado = compra;
		this.alquilado = alqui;
		this.numcomentarios = numcom;
		this.numvaloraciones = numval;
	}

	/**
	 * Instantiates a new vehiculo.
	 *
	 * @param modelo the modelo
	 * @param marca  the marca
	 * @param anyo   the anyo
	 * @param color  the color
	 * @param precio the precio
	 */
	public Vehiculo(String modelo, String marca, int anyo, String color, float precio) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.anyo = anyo;
		this.color = color;
		this.precio = precio;
	}

	/**
	 * Instantiates a new vehiculo.
	 *
	 * @param idVehiculos     the id vehiculos
	 * @param modelo          the modelo
	 * @param marca           the marca
	 * @param anyo            the anyo
	 * @param color           the color
	 * @param precio          the precio
	 * @param idFabricante    the id fabricante
	 * @param ruta            the ruta
	 * @param comprado        the comprado
	 * @param alquilado       the alquilado
	 * @param numcomentarios  the numcomentarios
	 * @param numvaloraciones the numvaloraciones
	 */
	public Vehiculo(Integer idVehiculos, String modelo, String marca, int anyo, String color, float precio,
			Integer idFabricante, String ruta, int comprado, int alquilado, int numcomentarios, int numvaloraciones) {
		super();
		this.idVehiculos = idVehiculos;
		this.modelo = modelo;
		this.marca = marca;
		this.anyo = anyo;
		this.color = color;
		this.precio = precio;
		this.idFabricante = idFabricante;
		this.ruta = ruta;
		this.comprado = comprado;
		this.alquilado = alquilado;
		this.numcomentarios = numcomentarios;
		this.numvaloraciones = numvaloraciones;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Vehiculo [idVehiculos=" + idVehiculos + ", modelo=" + modelo + ", marca=" + marca + ", anyo=" + anyo
				+ ", color=" + color + ", precio=" + precio + ", idFabricante=" + idFabricante + ", ruta=" + ruta + "]";
	}

}
