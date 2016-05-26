package Principal;

import Exceptions.CampoVacioException;
import Exceptions.DNIIncorrectoException;
import Exceptions.MatriculaExistenteException;
import Exceptions.MatriculaIncorrectaException;
import Exceptions.TelefonoIncorrectoException;
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
		dao = new DAOImp();
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
	
	public void GuardarFicha(TransferTaller datos) throws MatriculaIncorrectaException, DNIIncorrectoException, MatriculaExistenteException, TelefonoIncorrectoException, CampoVacioException {
		compruebaTransfer(datos);
		dao.InsertDatosYaModificados(datos);		
	}
	
	public void GuardarFactura(TransferTaller datos) throws MatriculaIncorrectaException, DNIIncorrectoException, MatriculaExistenteException, TelefonoIncorrectoException, CampoVacioException {
		if(datos.getFacturas().get(datos.getFacturas().size() - 1).getNombre().isEmpty()){
			throw new CampoVacioException("Nombre");
		}
		dao.InsertDatosYaModificados(datos);		
	}
	
	public void registrarIngreso(TransferTaller datos) throws MatriculaIncorrectaException, DNIIncorrectoException, MatriculaExistenteException, TelefonoIncorrectoException, CampoVacioException {
		compruebaTransfer(datos);
		
		TransferTaller resultado = null;
		resultado = ComprobarMatricula(datos);
		if(resultado == null){
			dao.InsertDatosYaModificados(datos);
		}
		else{
			throw new MatriculaExistenteException();
		}
		
	}
	
	private void compruebaTransfer(TransferTaller datos) throws MatriculaIncorrectaException, DNIIncorrectoException, TelefonoIncorrectoException, CampoVacioException{
		//Comprobaciones para el nombre y apellidos
		if(datos.getNombre().isEmpty()){
			throw new CampoVacioException("Nombre");
		}
		if(datos.getApellidos().isEmpty()){
			throw new CampoVacioException("Apellidos");
		}
		
		// Comprobaciones para el DNI		
		if(datos.getDNI().length() != 9){
			throw new DNIIncorrectoException();
		}
		else if(!esNumero(datos.getDNI().substring(0, 8))  ||  !sonLetras(datos.getDNI().substring(8, 9))){
			throw new DNIIncorrectoException();
		}
		
		// Comprobaciones para la matrícula
		if(datos.getMatricula().length() != 7){
			throw new MatriculaIncorrectaException();
		}
		else if(!esNumero(datos.getMatricula().substring(0, 4))  ||  !sonLetras(datos.getMatricula().substring(4, 7))){
			throw new MatriculaIncorrectaException();
		}
				
		// Comprobaciones para el Teléfono		
		if(datos.getTelefono().length() != 9){
			throw new TelefonoIncorrectoException();
		}
		else if(!esNumero(datos.getTelefono().substring(0, 9))){
			throw new TelefonoIncorrectoException();
		}
	}
	
	private boolean esNumero(String texto){
		try {
	            Integer.parseInt(texto);
	            return true;
	    } catch (NumberFormatException nfe) {
	    	
	    }
	    return false;
	}
	
	private boolean sonLetras(String name) {
	    char[] chars = name.toCharArray();

	    for (char c : chars) {
	        if(!Character.isLetter(c)) {
	            return false;
	        }
	    }

	    return true;
	}
}
	
