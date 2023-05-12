package models;

public class Vehiculo {
	
	private Integer idVehiculo;
	private String modelo, marca;
	private int anyo;
	private String color;
	private float precio;
	
	public Vehiculo() {
		super();
	}

	public Vehiculo(int idVehiculo, String modelo, String marca, int anyo, String color, float precio) {
		super();
		this.idVehiculo = idVehiculo;
		this.modelo = modelo;
		this.marca = marca;
		this.anyo = anyo;
		this.color = color;
		this.precio = precio;
	}

	public Integer getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + idVehiculo + ", modelo=" + modelo + ", marca=" + marca + ", anyo=" + anyo + ", color=" + color
				+ ", precio=" + precio + "]";
	}
	
}
