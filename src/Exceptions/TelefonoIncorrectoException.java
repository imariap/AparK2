package Exceptions;

public class TelefonoIncorrectoException extends Exception {
	
	public TelefonoIncorrectoException(){}
	
	@Override
	public String getMessage(){
        return "Formato de teléfono incorrecto, deben ser 9 dígitos.";
    }

}
