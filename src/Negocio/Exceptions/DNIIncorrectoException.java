package Negocio.Exceptions;

public class DNIIncorrectoException extends Exception {
	private static final long serialVersionUID = 1L;

	public DNIIncorrectoException(){}
	
	@Override
	public String getMessage(){
        return "Formato de DNI incorrecto. (Ej: 12345678N)";
    }

}
