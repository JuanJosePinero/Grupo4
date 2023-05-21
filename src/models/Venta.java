package models;

import java.sql.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Venta.
 */
public class Venta {

	/** The id vehiculo. */
	private Integer idVenta, idCliente, idVehiculo;

	/** The fecha hora. */
	private Date fechaHora;

	/**
	 * Gets the id venta.
	 *
	 * @return the id venta
	 */
	public Integer getIdVenta() {
		return idVenta;
	}

	/**
	 * Sets the id venta.
	 *
	 * @param idVenta the new id venta
	 */
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
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
	 * Gets the fecha hora.
	 *
	 * @return the fecha hora
	 */
	public Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * Sets the fecha hora.
	 *
	 * @param fechaHora the new fecha hora
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * Instantiates a new venta.
	 */
	public Venta() {
		super();
	}

	/**
	 * Instantiates a new venta.
	 *
	 * @param idVenta    the id venta
	 * @param idCliente  the id cliente
	 * @param idVehiculo the id vehiculo
	 * @param fechaHora  the fecha hora
	 */
	public Venta(Integer idVenta, Integer idCliente, Integer idVehiculo, Date fechaHora) {
		super();
		this.idVenta = idVenta;
		this.idCliente = idCliente;
		this.idVehiculo = idVehiculo;
		this.fechaHora = fechaHora;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", idCliente=" + idCliente + ", idVehiculo=" + idVehiculo + ", fechaHora="
				+ fechaHora + "]";
	}

}
