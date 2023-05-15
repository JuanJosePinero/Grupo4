package models;

import java.time.LocalDate;
import java.util.Date;

public class Venta {
	
	private Integer idVenta,idCliente,idVehiculo;
	private LocalDate fechaHora;
	
	public Venta() {
		super();
	}

	public Venta(Integer idVenta, Integer idCliente, Integer idVehiculo, LocalDate fechaHora) {
		super();
		this.idVenta = idVenta;
		this.idCliente = idCliente;
		this.idVehiculo = idVehiculo;
		this.fechaHora = fechaHora;
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

	public LocalDate getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDate fechaHora) {
		this.fechaHora = fechaHora;
	}

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", idCliente=" + idCliente + ", idVehiculo=" + idVehiculo + ", fechaHora="
				+ fechaHora + "]";
	}
	
	
	
	
	
	
}
