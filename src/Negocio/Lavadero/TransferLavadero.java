package Negocio.Lavadero;

import java.io.Serializable;
import java.util.ArrayList;

public class TransferLavadero implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public ArrayList<Double> getPrecioTipoAgua() {
		return PrecioTipoAgua;
	}
	public void setPrecioTipoAgua(ArrayList<Double> precioTipoAgua) {
		PrecioTipoAgua = precioTipoAgua;
	}
	public ArrayList<Double> getPrecioTipoLavado() {
		return PrecioTipoLavado;
	}
	public void setPrecioTipoLavado(ArrayList<Double> precioTipoLavado) {
		PrecioTipoLavado = precioTipoLavado;
	}
	public ArrayList<Double> getPrecioCristales() {
		return PrecioCristales;
	}
	public void setPrecioCristales(ArrayList<Double> precioCristales) {
		PrecioCristales = precioCristales;
	}
	public ArrayList<Double> getPrecioLlantas() {
		return PrecioLlantas;
	}
	public void setPrecioLlantas(ArrayList<Double> precioLlantas) {
		PrecioLlantas = precioLlantas;
	}

	private ArrayList<Double> PrecioTipoAgua;
	private ArrayList<Double> PrecioTipoLavado;
	private ArrayList<Double> PrecioCristales;
	private ArrayList<Double> PrecioLlantas;
	
	public TransferLavadero(){
		PrecioTipoAgua = new ArrayList<Double>();
		PrecioTipoLavado = new ArrayList<Double>();
		PrecioCristales = new ArrayList<Double>();
		PrecioLlantas = new ArrayList<Double>();
	}
}