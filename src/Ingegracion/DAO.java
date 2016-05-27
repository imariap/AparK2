package Ingegracion;

import Negocio.Lavadero.TransferLavadero;
import Negocio.Taller.TransferTaller;
public interface DAO {
	
	public TransferLavadero obtenerPrecios();
	public TransferTaller SelectObtenerDatosAModificar(TransferTaller datos);
	public void InsertDatosYaModificados(TransferTaller transfer);
}