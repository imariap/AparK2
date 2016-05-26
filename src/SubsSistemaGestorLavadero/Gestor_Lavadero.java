/**
 * 
 */
package SubsSistemaGestorLavadero;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Gestor_Lavadero {
	
	private static Gestor_Lavadero instance = null;
	
	public Gestor_Lavadero(){}
	
	public static Gestor_Lavadero getInstance(){
		if (instance == null) {
			instance = new Gestor_Lavadero();
		}
		return instance;
	}
	
	public void empezarLavado (){
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
	}
	public void finalizarLavado(){
		GUI_SeleccionarTipo.getInstance().getWorker().cancel(true);
		GUI_InterrumpirLavado.getInstance().getBar().setValue(0);
	}
	
	public void comprobarLavadoIniciado() {
		if(GUI_InterrumpirLavado.getInstance().getBar().getValue() == 0){
			GUI_Lavadero.getInstance().setVisible(false);
			GUI_SeleccionarTipo.getInstance().setVisible(true);
		}
		else
			GUI_Lavadero.getInstance().mostrarAlerta("Ya hay un lavado en curso");			
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