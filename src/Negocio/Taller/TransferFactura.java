package Negocio.Taller;
import java.io.Serializable;
import java.util.ArrayList;

public class TransferFactura  implements Serializable {
	private static final long serialVersionUID = 1L;
	private String Nombre;
	private ArrayList<TransferPieza> Piezas;		
	private double Importe;
	private double ManoDeObra;
	private int IVAPorc;
	private double IVA;
	private double TOTAL;
			
	public ArrayList<TransferPieza> getPiezas() {
		return Piezas;
	}
	public void setPiezas(ArrayList<TransferPieza> piezas) {
		Piezas = piezas;
	}
	
	public void addPieza(String nombre, double precio){
		TransferPieza p = new TransferPieza();
		p.setNombre(nombre);
		p.setPrecio(precio);
		Piezas.add(p);
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public double getImporte() {
		return Importe;
	}
	public void setImporte(double importe) {
		Importe = importe;
	}
	public double getManoDeObra() {
		return ManoDeObra;
	}
	public void setManoDeObra(double manoDeObra) {
		ManoDeObra = manoDeObra;
	}
	public int getIVAPorc() {
		return IVAPorc;
	}
	public void setIVAPorc(int iVAPorc) {
		IVAPorc = iVAPorc;
	}
	public double getIVA() {
		return IVA;
	}
	public void setIVA(double iVA) {
		IVA = iVA;
	}
	public double getTOTAL() {
		return TOTAL;
	}
	public void setTOTAL(double tOTAL) {
		TOTAL = tOTAL;
	}		
}