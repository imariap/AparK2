/**
 * 
 */
package SubSistemaGestorTaller;

import java.util.Set;

import Principal.CuentaBancaria;
import Principal.Factura;
import Principal.ServicioAplicacionTaller;
import Principal.TransferTaller;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Gestor_de_Taller {
	
	private static Gestor_de_Taller instance = null;
		
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Set<CuentaBancaria> cuentaBancaria;
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Set<Factura> factura;

	public static Gestor_de_Taller getInstance() {
		
		if(instance == null){
			instance = new Gestor_de_Taller();
		}
	
	return instance;
	
}
	
	public void action(int num, Object datos){
		switch (num){
		case 1: TransferTaller tranferTaller = (TransferTaller) datos; 
				TransferTaller resultado = ServicioAplicacionTaller.getInstance().ComprobarMatricula(tranferTaller);
				if (resultado != null){
					// Comprobación correcta
					GUI_BuscarParaModificarFicha.getInstance().setVisible(false);
					GUI_ModificarFicha.getInstance().setVisible(true);
					GUI_ModificarFicha.getInstance().actualizaDatos(resultado);
				}
				else{
					//Incorrecto
					GUI_BuscarParaModificarFicha.getInstance().mostrarAlerta("¡Matrícula no encontrada!");
				}
				
				break;
		}
	}
	
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void FacturarServicioPrestado(TransferTaller datos) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		TransferTaller tranferTaller = (TransferTaller) datos; 
		TransferTaller resultado = ServicioAplicacionTaller.getInstance().ComprobarMatricula(tranferTaller);
		if (resultado != null){
			// Comprobación correcta
			GUI_BuscarParaCrearFactura.getInstance().setVisible(false);
			GUI_CrearFactura.getInstance().setVisible(true);
			GUI_CrearFactura.getInstance().setTransfer(resultado);
		}
		else{
			//Incorrecto
			GUI_BuscarParaModificarFicha.getInstance().mostrarAlerta("¡Matrícula no encontrada!");
		}
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void ModificarFichaVehiculo(TransferTaller transfer) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		ServicioAplicacionTaller.getInstance().GuardarFicha(transfer);
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void RegistrarIngresoVehiculo() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void Datosmatrícula() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void Login() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void ingresoVehiculo() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void crearFactura() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente

		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void imprimeFactura(TransferTaller datos) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		TransferTaller tranferTaller = (TransferTaller) datos; 
		TransferTaller resultado = ServicioAplicacionTaller.getInstance().ComprobarMatricula(tranferTaller);
		if (resultado.getFacturas().size() == 0){
			// Sin facturas
			GUI_ModificarFicha.getInstance().mostrarAlerta("El cliente no tiene facturas.");
		}
		else{
			// Muestra facturas
			GUI_ModificarFicha.getInstance().setVisible(false);			
			GUI_MostrarFacturas.getInstance().actualizaDatos(resultado.getFacturas());
		}
		
		// end-user-code
	}
}