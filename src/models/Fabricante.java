package models;

// TODO: Auto-generated Javadoc
/**
 * The Class Fabricante.
 */
public class Fabricante {

	/** The id fabricante. */
	private Integer idFabricante;

	/** The pais. */
	private String nombre, pais;

	/** The id cliente. */
	private Integer idCliente;

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
	 * Gets the pais.
	 *
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Sets the pais.
	 *
	 * @param pais the new pais
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * Gets the id cliente.
	 *
	 * @return the id cliente
	 */
	public Integer getIdCliente() {
		return idCliente;
	}

	/**
	 * Sets the id cliente.
	 *
	 * @param idCliente the new id cliente
	 */
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * Instantiates a new fabricante.
	 */
	public Fabricante() {
		super();
	}

	/**
	 * Instantiates a new fabricante.
	 *
	 * @param idFabricante the id fabricante
	 * @param nombre       the nombre
	 * @param pais         the pais
	 * @param idCliente    the id cliente
	 */
	public Fabricante(Integer idFabricante, String nombre, String pais, Integer idCliente) {
		super();
		this.idFabricante = idFabricante;
		this.nombre = nombre;
		this.pais = pais;
		this.idCliente = idCliente;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Fabricante [idFabricante=" + idFabricante + ", nombre=" + nombre + ", pais=" + pais + "]";
	}

}
