package models;

import java.util.List;

public class VehiculoConComentarios {
	private Vehiculo vehiculo;
	private List<Comentario> comentarios;

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public VehiculoConComentarios(Vehiculo vehiculo, List<Comentario> comentarios) {
		this.vehiculo = vehiculo;
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "VehiculoConComentarios [vehiculo=" + vehiculo + ", comentarios=" + comentarios + "]";
	}

}
