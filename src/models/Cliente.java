package models;

import java.util.Arrays;

public class Cliente {

	private int idClientes;
    private String nombre,direccion;
    private String[] rol= {"Fabricante","Administrador","Cliente"};

    public int getIdClientes() {
        return idClientes;
    }
    public void setIdClientes(int idClientes) {
        this.idClientes = idClientes;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String[] getRol() {
        return rol;
    }
    public void setRol(String[] rol) {
        this.rol = rol;
    }
    public Cliente(int idClientes, String nombre, String direccion, String[] rol) {
        super();
        this.idClientes = idClientes;
        this.nombre = nombre;
        this.direccion = direccion;
        this.rol = rol;
    }
    public Cliente() {
        super();
    }
    @Override
    public String toString() {
        return "Cliente [idClientes=" + idClientes + ", nombre=" + nombre + ", direccion=" + direccion + ", rol="
                + Arrays.toString(rol) + "]";
    }
}
