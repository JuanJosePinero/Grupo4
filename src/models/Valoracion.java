package models;

public class Valoracion {
	private int idCliente,idVehiculo,valoracion;

	public Valoracion() {
		super();
	}

	public Valoracion(int idCliente, int idVehiculo, int valoracion) {
		super();
		this.idCliente = idCliente;
		this.idVehiculo = idVehiculo;
		this.valoracion = valoracion;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	@Override
	public String toString() {
		return "Valoracion [idCliente=" + idCliente + ", idVehiculo=" + idVehiculo + ", valoracion=" + valoracion + "]";
	}
	
	
}
