package models;

// TODO: Auto-generated Javadoc
/**
 * The Class Valoracion.
 */
public class Valoracion {

	/** The id vehiculo. */
	private Integer idCliente, idVehiculo;

	/** The valoracion. */
	private int valoracion;

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
	 * Gets the id vehiculo.
	 *
	 * @return the id vehiculo
	 */
	public Integer getIdVehiculo() {
		return idVehiculo;
	}

	/**
	 * Sets the id vehiculo.
	 *
	 * @param idVehiculo the new id vehiculo
	 */
	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	/**
	 * Gets the valoracion.
	 *
	 * @return the valoracion
	 */
	public int getValoracion() {
		return valoracion;
	}

	/**
	 * Sets the valoracion.
	 *
	 * @param valoracion the new valoracion
	 */
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	/**
	 * Instantiates a new valoracion.
	 */
	public Valoracion() {
		super();
	}

	/**
	 * Instantiates a new valoracion.
	 *
	 * @param idCliente  the id cliente
	 * @param idVehiculo the id vehiculo
	 * @param valoracion the valoracion
	 */
	public Valoracion(Integer idCliente, Integer idVehiculo, int valoracion) {
		super();
		this.idCliente = idCliente;
		this.idVehiculo = idVehiculo;
		this.valoracion = valoracion;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Valoracion [idCliente=" + idCliente + ", idVehiculo=" + idVehiculo + ", valoracion=" + valoracion + "]";
	}

}
