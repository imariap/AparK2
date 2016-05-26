/**
 * 
 */
package SubsSistemaGestorLavadero;

import Principal.ServicioAplicacionLavadero;
import Principal.TransferLavadero;
import SubSistemaGestorTaller.GUI_Taller;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Gestor_Lavadero {
	
	private double precioTotal;
	
	private static Gestor_Lavadero instance = null;
	
	public Gestor_Lavadero(){
		precioTotal = 0;
	}
	
	public static Gestor_Lavadero getInstance(){
		if (instance == null) {
			instance = new Gestor_Lavadero();
		}
		return instance;
	}
	
	public void empezarLavado (int TipoAgua, int TipoLavado, int cristales, int llantas){
		// Calculamos el precio
		TransferLavadero precios = ServicioAplicacionLavadero.getInstance().obtenerPrecios();
		switch (TipoAgua){
			case 0: precioTotal += precios.getPrecioTipoAgua().get(0);
					break;
			case 1: precioTotal += precios.getPrecioTipoAgua().get(1);
					break;			
		}
		
		switch (TipoLavado){
			case 0: precioTotal += precios.getPrecioTipoLavado().get(0);
					break;
			case 1: precioTotal += precios.getPrecioTipoLavado().get(1);
					break;
		}
		
		switch (cristales){
			case 0: precioTotal += precios.getPrecioCristales().get(0);
					break;
			case 1: precioTotal += precios.getPrecioCristales().get(1);
					break;
			case 2: precioTotal += precios.getPrecioCristales().get(2);
					break;
		}
		
		switch (llantas){
			case 0: precioTotal += precios.getPrecioLlantas().get(0);
					break;
			case 1: precioTotal += precios.getPrecioLlantas().get(1);
					break;
			case 2: precioTotal += precios.getPrecioLlantas().get(2);
					break;
		}		
		
		GUI_InterrumpirLavado.getInstance().setVisible(false);
		GUI_InterrumpirLavado.getInstance().getBar().setValue(0);
		while (GUI_InterrumpirLavado.getInstance().getBar().getValue() < 100 && !GUI_SeleccionarTipo.getInstance().getWorker().isCancelled()) {
			GUI_InterrumpirLavado.getInstance().getBar()
					.setValue((int) (GUI_InterrumpirLavado.getInstance().getBar().getValue() + 1));
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
		GUI_InterrumpirLavado.getInstance().getBar().setValue(0);
		
	}
	public void finalizarLavado(){
		if(GUI_InterrumpirLavado.getInstance().getBar().getValue() != 0){
			GUI_InterrumpirLavado.getInstance().mostrarAlerta("Lavado interrumpido con éxito");
			GUI_SeleccionarTipo.getInstance().getWorker().cancel(true);
			GUI_InterrumpirLavado.getInstance().getBar().setValue(0);			
		}
		else{
			GUI_InterrumpirLavado.getInstance().mostrarAlerta("El lavado ya habia finalizado, no se ha podido interrumpir.");
		}
		GUI_InterrumpirLavado.getInstance().setVisible(false);
		GUI_Lavadero.getInstance().setVisible(true);
	}
	
	public void comprobarLavadoIniciado() {
		if(GUI_InterrumpirLavado.getInstance().getBar().getValue() == 0){
			GUI_Lavadero.getInstance().setVisible(false);
			GUI_SeleccionarTipo.getInstance().setVisible(true);
		}
		else
			GUI_Lavadero.getInstance().mostrarAlerta("Ya hay un lavado en curso");			
	}
	
	public double getPrecioTotal(){
		return precioTotal;
	}
	
	public void pagarLavado(){
		precioTotal = 0;
	}
	
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void Comprueba_Disponibilidad() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void Gestionar_Lavado() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void Comprobar_Lavado_Finalizado() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void Pagar_En_Efectivo() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void Pagar_Con_Tarjeta() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void Interrumpir_Lavado() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void Iniciar_Lavado() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}
}