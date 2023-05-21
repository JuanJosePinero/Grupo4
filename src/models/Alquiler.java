package models;

import java.util.Date;

public class Alquiler {

	private Integer idAlquiler, idCliente, idVehiculo;
	private Date fechaInic, fechFin;

	public Integer getIdAlquiler() {
		return idAlquiler;
	}

	public void setIdAlquiler(Integer idVenta) {
		this.idAlquiler = idVenta;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Date getFechaInic() {
		return fechaInic;
	}

	public void setFechaInic(Date fechaInic) {
		this.fechaInic = fechaInic;
	}

	public Date getFechFin() {
		return fechFin;
	}

	public void setFechFin(Date fechFin) {
		this.fechFin = fechFin;
	}

	public Alquiler() {
		super();
	}

	public Alquiler(Integer idVenta, Integer idCliente, Integer idVehiculo, Date fechaInic, Date fechaFin) {
		super();
		this.idAlquiler = idVenta;
		this.idCliente = idCliente;
		this.idVehiculo = idVehiculo;
		this.fechaInic = fechaInic;
		this.fechFin = fechaFin;
	}

	@Override
	public String toString() {
		return "Alquiler [idVenta=" + idAlquiler + ", idCliente=" + idCliente + ", idVehiculo=" + idVehiculo
				+ ", fechaInic=" + fechaInic + ", fechFin=" + fechFin + "]";
	}

}
