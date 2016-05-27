package Negocio.Exceptions;

public class DNIIncorrectoException extends Exception {
	
	public DNIIncorrectoException(){}
	
	@Override
	public String getMessage(){
        return "Formato de DNI incorrecto. (Ej: 12345678N)";
    }

}
