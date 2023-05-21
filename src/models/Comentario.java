package models;

public class Comentario {

	private Integer idCliente, idVehiculo;
	private String comentario;

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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Comentario() {
		super();
	}

	public Comentario(Integer idCliente, Integer idVehiculo, String comentario) {
		super();
		this.idCliente = idCliente;
		this.idVehiculo = idVehiculo;
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Comentario [idCliente=" + idCliente + ", idVehiculo=" + idVehiculo + ", comentario=" + comentario + "]";
	}
}
