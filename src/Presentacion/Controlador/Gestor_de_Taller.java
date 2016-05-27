/**
 * 
 */
package Presentacion.Controlador;

import java.util.Set;

import Negocio.Exceptions.CampoVacioException;
import Negocio.Exceptions.DNIIncorrectoException;
import Negocio.Exceptions.MatriculaExistenteException;
import Negocio.Exceptions.MatriculaIncorrectaException;
import Negocio.Exceptions.TelefonoIncorrectoException;
import Negocio.Taller.ServicioAplicacionTaller;
import Negocio.Taller.TransferFactura;
import Negocio.Taller.TransferTaller;
import Presentacion.GUITaller.GUI_BuscarParaCrearFactura;
import Presentacion.GUITaller.GUI_BuscarParaModificarFicha;
import Presentacion.GUITaller.GUI_CrearFactura;
import Presentacion.GUITaller.GUI_IngresoVehiculo;
import Presentacion.GUITaller.GUI_ModificarFicha;
import Presentacion.GUITaller.GUI_MostrarFacturas;
import Presentacion.GUITaller.GUI_Taller;

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
	
	private Set<TransferFactura> factura;

	public static Gestor_de_Taller getInstance() {
		
		if(instance == null){
			instance = new Gestor_de_Taller();
		}
	
	return instance;
	
}
	
	public void action(int num, Object datos){
		switch (num){
		case 1: TransferTaller tranferTaller = (TransferTaller) datos; 
		
				// Comprobamos que este bien formateada la matricula y la guardamos o lanzamos error
				TransferTaller resultado = null;
				try {
					resultado = ServicioAplicacionTaller.getInstance().ComprobarMatricula(tranferTaller);
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
				} catch (MatriculaIncorrectaException e) {
					// TODO Auto-generated catch block
					GUI_BuscarParaModificarFicha.getInstance().mostrarAlerta(e.getMessage());
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
		TransferTaller resultado = null;
		try {
			resultado = ServicioAplicacionTaller.getInstance().ComprobarMatricula(tranferTaller);
			if (resultado != null){
				// Comprobación correcta
				GUI_BuscarParaCrearFactura.getInstance().setVisible(false);
				GUI_CrearFactura.getInstance().setVisible(true);
				GUI_CrearFactura.getInstance().setTransfer(resultado);
			}
			else{
				//Incorrecto
				GUI_BuscarParaCrearFactura.getInstance().mostrarAlerta("¡Matrícula no encontrada!");
			}
		} catch (MatriculaIncorrectaException e) {
			// TODO Auto-generated catch block
			GUI_BuscarParaModificarFicha.getInstance().mostrarAlerta(e.getMessage());
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
		try {
			ServicioAplicacionTaller.getInstance().GuardarFicha(transfer);
			GUI_ModificarFicha.getInstance().mostrarMensaje("Datos modificados con éxito.");
			GUI_ModificarFicha.getInstance().setVisible(false);
			GUI_ModificarFicha.getInstance().limpiarCampos();
			GUI_Taller.getInstance().setVisible(true);
		} catch (MatriculaIncorrectaException | DNIIncorrectoException | MatriculaExistenteException | TelefonoIncorrectoException | CampoVacioException e) {
			// TODO Auto-generated catch block
			GUI_ModificarFicha.getInstance().mostrarAlerta(e.getMessage());
		}
		// end-user-code
	}

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void RegistrarIngresoVehiculo(TransferTaller transfer) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		try {
			ServicioAplicacionTaller.getInstance().registrarIngreso(transfer);
			GUI_IngresoVehiculo.getInstance().mostrarMensaje("Datos guardados con éxito.");
			GUI_IngresoVehiculo.getInstance().setVisible(false);
			GUI_IngresoVehiculo.getInstance().limpiarCampos();
			GUI_Taller.getInstance().setVisible(true);
		} catch (MatriculaIncorrectaException | DNIIncorrectoException | MatriculaExistenteException | TelefonoIncorrectoException | CampoVacioException e) {
			// TODO Auto-generated catch block
			GUI_IngresoVehiculo.getInstance().mostrarAlerta(e.getMessage());
		}
		// end-user-code
	}
	
	public void crearFactura(TransferTaller transfer) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		try {
			ServicioAplicacionTaller.getInstance().GuardarFactura(transfer);
			GUI_CrearFactura.getInstance().mostrarMensaje("Factura guardada con éxito.");
			GUI_CrearFactura.getInstance().setVisible(false);
			GUI_CrearFactura.getInstance().limpiarCampos();
			GUI_Taller.getInstance().setVisible(true);
		} catch (MatriculaIncorrectaException | DNIIncorrectoException | MatriculaExistenteException | TelefonoIncorrectoException | CampoVacioException e) {
			// TODO Auto-generated catch block
			GUI_CrearFactura.getInstance().mostrarAlerta(e.getMessage());
		}
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
	public void imprimeFactura(TransferTaller datos) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		TransferTaller tranferTaller = (TransferTaller) datos; 
		TransferTaller resultado = null;
		try {
			resultado = ServicioAplicacionTaller.getInstance().ComprobarMatricula(tranferTaller);
			if (resultado.getFacturas().size() == 0){
				// Sin facturas
				GUI_ModificarFicha.getInstance().mostrarAlerta("El cliente no tiene facturas.");
			}
			else{
				// Muestra facturas
				GUI_ModificarFicha.getInstance().setVisible(false);			
				GUI_MostrarFacturas.getInstance().actualizaDatos(resultado.getFacturas());
			}
		} catch (MatriculaIncorrectaException e) {
			// TODO Auto-generated catch block
			System.out.println("Error matricula");
		}
		
		
		
		// end-user-code
	}

}