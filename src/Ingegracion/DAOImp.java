package Ingegracion;

import Almacen.ALMACEN;
import Negocio.Lavadero.TransferLavadero;
import Negocio.Taller.TransferTaller;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOImp implements DAO {

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
	public TransferLavadero obtenerPrecios() {
		// TODO Auto-generated method stub
		return ALMACEN.getInstance().obtenerPreciosLavadero();
	}
}