package models;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class VehiculoConComentarios.
 */
public class VehiculoConComentarios {

	/** The vehiculo. */
	private Vehiculo vehiculo;

	/** The comentarios. */
	private List<Comentario> comentarios;

	/**
	 * Gets the vehiculo.
	 *
	 * @return the vehiculo
	 */
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	/**
	 * Sets the vehiculo.
	 *
	 * @param vehiculo the new vehiculo
	 */
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	/**
	 * Gets the comentarios.
	 *
	 * @return the comentarios
	 */
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	/**
	 * Sets the comentarios.
	 *
	 * @param comentarios the new comentarios
	 */
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	/**
	 * Instantiates a new vehiculo con comentarios.
	 *
	 * @param vehiculo    the vehiculo
	 * @param comentarios the comentarios
	 */
	public VehiculoConComentarios(Vehiculo vehiculo, List<Comentario> comentarios) {
		this.vehiculo = vehiculo;
		this.comentarios = comentarios;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "VehiculoConComentarios [vehiculo=" + vehiculo + ", comentarios=" + comentarios + "]";
	}

}
