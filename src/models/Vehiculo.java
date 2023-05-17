package models;


public class Vehiculo {
	
	private Integer idVehiculos;
	private String modelo, marca;
	private int anyo;
	private String color;
	private float precio;
	private Integer idFabricante;
	private String ruta;
	private int comprado=0;
	


	public Vehiculo() {
		super();
	}

	public Vehiculo(Integer idVehiculos, String modelo, String marca, int anyo, String color, float precio,
			Integer idFabricante, int compra) {
		super();
		this.idVehiculos = idVehiculos;
		this.modelo = modelo;
		this.marca = marca;
		this.anyo = anyo;
		this.color = color;
		this.precio = precio;
		this.idFabricante = idFabricante;
		this.comprado=compra;
	}



	public Vehiculo(Integer idVehiculos, String modelo, String marca, int anyo, String color, float precio,
			Integer idFabricante) {
		super();
		this.idVehiculos = idVehiculos;
		this.modelo = modelo;
		this.marca = marca;
		this.anyo = anyo;
		this.color = color;
		this.precio = precio;
		this.idFabricante = idFabricante;
	}
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Integer getIdVehiculos() {
		return idVehiculos;
	}

	public void setIdVehiculos(Integer idVehiculo) {
		this.idVehiculos = idVehiculo;
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

	public Integer getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(Integer idFabricante) {
		this.idFabricante = idFabricante;
	}
	public int getComprado() {
		return comprado;
	}

	public void setComprado(int comprado) {
		this.comprado = comprado;
	}

	@Override
	public String toString() {
		return "Vehiculo [idVehiculos=" + idVehiculos + ", modelo=" + modelo + ", marca=" + marca + ", anyo=" + anyo
				+ ", color=" + color + ", precio=" + precio + ", idFabricante=" + idFabricante + ", ruta=" + ruta + "]";
	}
	
}
