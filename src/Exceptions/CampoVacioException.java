package Exceptions;

public class CampoVacioException extends Exception {
	private String campo;
	
	public CampoVacioException(String campo){
		this.campo = campo;
	}
	
	@Override
	public String getMessage(){
        return "El campo '" + campo + "' no  puede estar vacio.";
    }

}
