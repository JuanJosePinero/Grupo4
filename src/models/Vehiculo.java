package models;


public class Vehiculo {
	
	private Integer idVehiculos;
	private String modelo, marca;
	private int anyo;
	private String color;
	private float precio;
	private Integer idFabricante;
	private String ruta;
	private int comprado=0,alquilado=0,numcomentarios=0,numvaloraciones=0;
	
	


	

	public Vehiculo() {
		super();
	}

	public Vehiculo(Integer idVehiculos, String modelo, String marca, int anyo, String color, float precio,
			Integer idFabricante, String ruta) {
		super();
		this.idVehiculos = idVehiculos;
		this.modelo = modelo;
		this.marca = marca;
		this.anyo = anyo;
		this.color = color;
		this.precio = precio;
		this.idFabricante = idFabricante;
		this.ruta = ruta;
	}



	public Vehiculo(Integer idVehiculos, String modelo, String marca, int anyo, String color, float precio,
			Integer idFabricante, int compra, int alqui) {
		super();
		this.idVehiculos = idVehiculos;
		this.modelo = modelo;
		this.marca = marca;
		this.anyo = anyo;
		this.color = color;
		this.precio = precio;
		this.idFabricante = idFabricante;
		this.comprado=compra;
		this.alquilado = alqui;
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
	public Vehiculo(Integer idVehiculos, String modelo, String marca, int anyo, String color, float precio,
			Integer idFabricante, int compra, int alqui,int numcom,int numval) {
		super();
		this.idVehiculos = idVehiculos;
		this.modelo = modelo;
		this.marca = marca;
		this.anyo = anyo;
		this.color = color;
		this.precio = precio;
		this.idFabricante = idFabricante;
		this.comprado=compra;
		this.alquilado = alqui;
		this.numcomentarios=numcom;
		this.numvaloraciones=numval;
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
	
	public int getNumcomentarios() {
		return numcomentarios;
	}

	public void setNumcomentarios(int numcomentarios) {
		this.numcomentarios = numcomentarios;
	}

	public int getAlquilado() {
		return alquilado;
	}

	public void setAlquilado(int alquilado) {
		this.alquilado = alquilado;
	}
	

	public int getNumvaloraciones() {
		return numvaloraciones;
	}

	public void setNumvaloraciones(int numvaloraciones) {
		this.numvaloraciones = numvaloraciones;
	}

	@Override
	public String toString() {
		return "Vehiculo [idVehiculos=" + idVehiculos + ", modelo=" + modelo + ", marca=" + marca + ", anyo=" + anyo
				+ ", color=" + color + ", precio=" + precio + ", idFabricante=" + idFabricante + ", ruta=" + ruta + "]";
	}
	
}
