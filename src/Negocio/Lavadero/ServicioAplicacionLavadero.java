package Negocio.Lavadero;

import Ingegracion.DAO;
import Ingegracion.DAOImp;

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