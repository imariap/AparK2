package Principal;

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
	
	public TransferTaller ComprobarMatricula(TransferTaller datos) {
		TransferTaller transfer = dao.SelectObtenerDatosAModificar(datos);		
		return transfer;
	}	
	
	public void GuardarFicha(TransferTaller datos) {
		dao.InsertDatosYaModificados(datos);
	}
	
}