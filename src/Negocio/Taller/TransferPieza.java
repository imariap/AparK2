package Negocio.Taller;

import java.io.Serializable;

public class TransferPieza implements Serializable{
	private static final long serialVersionUID = 1L;
	String Nombre;
	double Precio;
	
	public TransferPieza(){}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	
}