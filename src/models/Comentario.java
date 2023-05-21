package models;

// TODO: Auto-generated Javadoc
/**
 * The Class Comentario.
 */
public class Comentario {

	/** The id vehiculo. */
	private Integer idCliente, idVehiculo;

	/** The comentario. */
	private String comentario;

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
	 * Gets the comentario.
	 *
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * Sets the comentario.
	 *
	 * @param comentario the new comentario
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * Instantiates a new comentario.
	 */
	public Comentario() {
		super();
	}

	/**
	 * Instantiates a new comentario.
	 *
	 * @param idCliente  the id cliente
	 * @param idVehiculo the id vehiculo
	 * @param comentario the comentario
	 */
	public Comentario(Integer idCliente, Integer idVehiculo, String comentario) {
		super();
		this.idCliente = idCliente;
		this.idVehiculo = idVehiculo;
		this.comentario = comentario;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Comentario [idCliente=" + idCliente + ", idVehiculo=" + idVehiculo + ", comentario=" + comentario + "]";
	}
}
