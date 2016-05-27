package Negocio.Lavadero;

import Ingegracion.DAO;
import Ingegracion.DAOImp;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ServicioAplicacionLavadero {
	
	private static ServicioAplicacionLavadero instance = null;
	
	public static ServicioAplicacionLavadero getInstance() {
		
		if(instance == null){
			instance = new ServicioAplicacionLavadero();
		}
	
		return instance;
	}
	
	public TransferLavadero obtenerPrecios(){
		DAO dao = new DAOImp();
		return dao.obtenerPrecios();
	}
}