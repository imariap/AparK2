package Principal;
/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOTaller implements DAO {

	@Override
	public void SelectComprobaDatos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InsertDatosYaModificados(TransferTaller transfer) {
		// TODO Auto-generated method stub
		ALMACEN.getInstance().guardaFicha(transfer);
	}

	@Override
	public TransferTaller SelectObtenerDatosAModificar(TransferTaller datos) {
		// TODO Auto-generated method stub
		TransferTaller transfer = ALMACEN.getInstance().consultarMatricula(datos);
		return transfer;
	}

	@Override
	public void Insert_Guerdar_Fecha() {
		// TODO Auto-generated method stub
		
	}
}