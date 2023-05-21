package models;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class VehiculoMejoresValoraciones.
 */
public class VehiculoMejoresValoraciones {

	/** The vehiculo. */
	private Vehiculo vehiculo;

	/** The valoraciones. */
	private List<Valoracion> valoraciones;

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
	 * Gets the valoraciones.
	 *
	 * @return the valoraciones
	 */
	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}

	/**
	 * Sets the valoraciones.
	 *
	 * @param valoraciones the new valoraciones
	 */
	public void setValoraciones(List<Valoracion> valoraciones) {
		this.valoraciones = valoraciones;
	}

	/**
	 * Instantiates a new vehiculo mejores valoraciones.
	 *
	 * @param vehiculo     the vehiculo
	 * @param valoraciones the valoraciones
	 */
	public VehiculoMejoresValoraciones(Vehiculo vehiculo, List<Valoracion> valoraciones) {
		super();
		this.vehiculo = vehiculo;
		this.valoraciones = valoraciones;
	}

	/**
	 * Instantiates a new vehiculo mejores valoraciones.
	 */
	public VehiculoMejoresValoraciones() {
		super();
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "VehiculoMejoresValoraciones [vehiculo=" + vehiculo + ", valoraciones=" + valoraciones + "]";
	}
}
