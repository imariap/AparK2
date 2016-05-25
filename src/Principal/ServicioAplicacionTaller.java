package Principal;

import Exceptions.MatriculaIncorrectaException;
import SubSistemaGestorTaller.Gestor_de_Taller;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ServicioAplicacionTaller {
		/** 
		 * <!-- begin-UML-doc -->
		 * <!-- end-UML-doc -->
		 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
		 */
	private static ServicioAplicacionTaller instance = null;
	private DAO dao;
	
	public ServicioAplicacionTaller(){
		dao = new DAOTaller();
	}
	
	public static ServicioAplicacionTaller getInstance() {
			
			if(instance == null){
				instance = new ServicioAplicacionTaller();
			}
		
		return instance;
	}
	
	public TransferTaller ComprobarMatricula(TransferTaller datos) throws MatriculaIncorrectaException { 
		// Comprobaciones para la matrícula
		if(datos.getMatricula().length() != 7){
			throw new MatriculaIncorrectaException();
		}
		else if(!esNumero(datos.getMatricula().substring(0, 4))  ||  !sonLetras(datos.getMatricula().substring(4, 7))){
			throw new MatriculaIncorrectaException();
		}
		
		TransferTaller transfer = dao.SelectObtenerDatosAModificar(datos);		
		return transfer;
	}	
	
	public void GuardarFicha(TransferTaller datos) throws MatriculaIncorrectaException {
		// Comprobaciones para la matrícula
		if(datos.getMatricula().length() != 7){
			throw new MatriculaIncorrectaException();
		}
		else if(!esNumero(datos.getMatricula().substring(0, 4))  ||  !sonLetras(datos.getMatricula().substring(4, 7))){
			throw new MatriculaIncorrectaException();
		}
		
		dao.InsertDatosYaModificados(datos);
	}
	
	private boolean esNumero(String texto){
		try {
	            Integer.parseInt(texto);
	            return true;
	    } catch (NumberFormatException nfe) {
	    	
	    }
	    return false;
	}
	
	public boolean sonLetras(String name) {
	    char[] chars = name.toCharArray();

	    for (char c : chars) {
	        if(!Character.isLetter(c)) {
	            return false;
	        }
	    }

	    return true;
	}
}
	
