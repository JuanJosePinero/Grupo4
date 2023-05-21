package models;

public class Valoracion {

	private Integer idCliente, idVehiculo;
	private int valoracion;

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

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public Valoracion() {
		super();
	}

	public Valoracion(Integer idCliente, Integer idVehiculo, int valoracion) {
		super();
		this.idCliente = idCliente;
		this.idVehiculo = idVehiculo;
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "Valoracion [idCliente=" + idCliente + ", idVehiculo=" + idVehiculo + ", valoracion=" + valoracion + "]";
	}

}
