package Negocio.Exceptions;

public class TelefonoIncorrectoException extends Exception {
	private static final long serialVersionUID = 1L;

	public TelefonoIncorrectoException(){}
	
	@Override
	public String getMessage(){
        return "Formato de tel�fono incorrecto, deben ser 9 d�gitos.";
    }

}
