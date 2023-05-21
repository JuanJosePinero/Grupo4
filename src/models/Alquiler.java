package models;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Alquiler.
 */
public class Alquiler {

	/** The id vehiculo. */
	private Integer idAlquiler, idCliente, idVehiculo;

	/** The fech fin. */
	private Date fechaInic, fechFin;

	/**
	 * Gets the id alquiler.
	 *
	 * @return the id alquiler
	 */
	public Integer getIdAlquiler() {
		return idAlquiler;
	}

	/**
	 * Sets the id alquiler.
	 *
	 * @param idVenta the new id alquiler
	 */
	public void setIdAlquiler(Integer idVenta) {
		this.idAlquiler = idVenta;
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
	 * Gets the fecha inic.
	 *
	 * @return the fecha inic
	 */
	public Date getFechaInic() {
		return fechaInic;
	}

	/**
	 * Sets the fecha inic.
	 *
	 * @param fechaInic the new fecha inic
	 */
	public void setFechaInic(Date fechaInic) {
		this.fechaInic = fechaInic;
	}

	/**
	 * Gets the fech fin.
	 *
	 * @return the fech fin
	 */
	public Date getFechFin() {
		return fechFin;
	}

	/**
	 * Sets the fech fin.
	 *
	 * @param fechFin the new fech fin
	 */
	public void setFechFin(Date fechFin) {
		this.fechFin = fechFin;
	}

	/**
	 * Instantiates a new alquiler.
	 */
	public Alquiler() {
		super();
	}

	/**
	 * Instantiates a new alquiler.
	 *
	 * @param idVenta    the id venta
	 * @param idCliente  the id cliente
	 * @param idVehiculo the id vehiculo
	 * @param fechaInic  the fecha inic
	 * @param fechaFin   the fecha fin
	 */
	public Alquiler(Integer idVenta, Integer idCliente, Integer idVehiculo, Date fechaInic, Date fechaFin) {
		super();
		this.idAlquiler = idVenta;
		this.idCliente = idCliente;
		this.idVehiculo = idVehiculo;
		this.fechaInic = fechaInic;
		this.fechFin = fechaFin;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Alquiler [idVenta=" + idAlquiler + ", idCliente=" + idCliente + ", idVehiculo=" + idVehiculo
				+ ", fechaInic=" + fechaInic + ", fechFin=" + fechFin + "]";
	}

}
