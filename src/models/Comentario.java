package models;

public class Comentario {

	private int idCliente, idVehiculo;
	private String comentario;
	
	public Comentario() {
		super();
	}

	public Comentario(int idCliente, int idVehiculo, String comentario) {
		super();
		this.idCliente = idCliente;
		this.idVehiculo = idVehiculo;
		this.comentario = comentario;
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Comentario [idCliente=" + idCliente + ", idVehiculo=" + idVehiculo + ", comentario=" + comentario + "]";
	}
}
