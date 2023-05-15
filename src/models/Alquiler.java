package models;

import java.time.LocalDate;
import java.util.Date;

public class Alquiler {
	private Integer idVenta,idCliente,idVehiculo;
	private LocalDate fechaInic,fechFin;
	
	public Alquiler() {
		super();
	}

	public Alquiler(Integer idVenta, Integer idCliente, Integer idVehiculo, LocalDate fechaInic) {
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

	public LocalDate getFechaInic() {
		return fechaInic;
	}

	public void setFechaInic(LocalDate fechaInic) {
		this.fechaInic = fechaInic;
	}

	public LocalDate getFechFin() {
		return fechFin;
	}

	public void setFechFin(LocalDate fechFin) {
		this.fechFin = fechFin;
	}

	@Override
	public String toString() {
		return "Alquiler [idVenta=" + idVenta + ", idCliente=" + idCliente + ", idVehiculo=" + idVehiculo
				+ ", fechaInic=" + fechaInic + ", fechFin=" + fechFin + "]";
	}
	
	
	
	

}
