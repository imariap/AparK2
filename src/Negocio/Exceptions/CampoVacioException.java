package Negocio.Exceptions;

public class CampoVacioException extends Exception {
	private static final long serialVersionUID = 1L;
	private String campo;
	
	public CampoVacioException(String campo){
		this.campo = campo;
	}
	
	@Override
	public String getMessage(){
        return "El campo '" + campo + "' no  puede estar vacio.";
    }

}
