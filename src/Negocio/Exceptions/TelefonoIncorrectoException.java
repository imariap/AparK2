package Negocio.Exceptions;

public class TelefonoIncorrectoException extends Exception {
	private static final long serialVersionUID = 1L;

	public TelefonoIncorrectoException(){}
	
	@Override
	public String getMessage(){
        return "Formato de teléfono incorrecto, deben ser 9 dígitos.";
    }

}
