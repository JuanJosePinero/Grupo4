package models;

import java.util.Date;

public class Alquiler {
	private Integer idVenta,idCliente,idVehiculo;
	private Date fechaInic,fechFin;
	
	public Alquiler() {
		super();
	}

	public Alquiler(Integer idVenta, Integer idCliente, Integer idVehiculo, Date fechaInic) {
		super();
		this.idVenta = idVenta;
		this.idCliente = idCliente;
		this.idVehiculo = idVehiculo;
		this.fechaInic = fechaInic;
	}

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
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

	@Override
	public String toString() {
		return "Alquiler [idVenta=" + idVenta + ", idCliente=" + idCliente + ", idVehiculo=" + idVehiculo
				+ ", fechaInic=" + fechaInic + ", fechFin=" + fechFin + "]";
	}
	
	
	
	

}
