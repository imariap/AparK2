package Negocio.Taller;

import java.io.Serializable;

public class TransferPieza implements Serializable{
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