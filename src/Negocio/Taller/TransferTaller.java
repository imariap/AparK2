package Negocio.Taller;

import java.io.Serializable;
import java.util.ArrayList;

import Negocio.Transfer.Transfer;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class TransferTaller implements Transfer, Serializable {
	
	private String Nombre;
	private String Apellidos;
	private String DNI;
	private String Matricula;
	private String Telefono;
	private String  Observaciones;
	private ArrayList<TransferFactura> Facturas;
	
	public TransferTaller(){
		Nombre = "";
		Apellidos = "";
		DNI = "";
		Matricula = "";
		Telefono = "";
		Observaciones = "";
		Facturas = new ArrayList<TransferFactura>();
	}
	
	public TransferTaller(String matricula){
		Nombre = "";
		Apellidos = "";
		DNI = "";
		Matricula = matricula;
		Telefono = "";
		Observaciones = "";
		Facturas = new ArrayList<TransferFactura>();
	}
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void Crear_Tanfer() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void CogerDatos() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void LlenarTransferDatosFicha() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void RellenarTransferDatosAModificar() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void CambiarDatosEnTransferParaInsertar() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}
	
	public String getNombre(){
		return Nombre;
	}
	
	public String getApellidos(){
		return Apellidos;
	}
	
	public String getDNI(){
		return DNI;
	}
	
	public String getMatricula(){
		return Matricula;
	}
	
	public String getTelefono(){
		return Telefono;
	}
	
	public String getObservaciones(){
		return Observaciones;
	}
	
	public ArrayList<TransferFactura> getFacturas(){
		return Facturas;
	}
	
	public void setNombre(String n){
		Nombre = n;
	}
	
	public void setApellidos(String n){
		Apellidos = n;
	}
	
	public void setDNI(String n){
		DNI = n;
	}
	
	public void setMatricula(String n){
		Matricula = n;
	}
	
	public void setTelefono(String n){
		Telefono = n;
	}
	
	public void setObservaciones(String n){
		Observaciones = n;
	}
	
	public void setFacturas(ArrayList<TransferFactura> n){
		Facturas = n;
	}
	
	public void addFactura(String nombre, double importe, double manoDeObra, int ivaPorc, double IVA, double total, ArrayList<TransferPieza> piezas ){
		TransferFactura fact = new TransferFactura();
		fact.setImporte(importe);
		fact.setIVAPorc(ivaPorc);
		fact.setIVA(IVA);
		fact.setManoDeObra(manoDeObra);
		fact.setNombre(nombre);
		fact.setTOTAL(total);
		fact.setPiezas(piezas);
		Facturas.add(fact);
	}
}

