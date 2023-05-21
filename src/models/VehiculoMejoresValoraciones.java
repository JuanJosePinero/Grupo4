package models;

import java.util.List;

public class VehiculoMejoresValoraciones {

	private Vehiculo vehiculo;
	private List<Valoracion> valoraciones;

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}

	public void setValoraciones(List<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}

	public VehiculoMejoresValoraciones(Vehiculo vehiculo, List<Valoracion> valoraciones) {
		super();
		this.vehiculo = vehiculo;
		this.valoraciones = valoraciones;
	}

	public VehiculoMejoresValoraciones() {
		super();
	}

	@Override
	public String toString() {
		return "VehiculoMejoresValoraciones [vehiculo=" + vehiculo + ", valoraciones=" + valoraciones + "]";
	}
}
