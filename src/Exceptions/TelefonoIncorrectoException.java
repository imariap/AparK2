package Exceptions;

public class TelefonoIncorrectoException extends Exception {
	
	public TelefonoIncorrectoException(){}
	
	@Override
	public String getMessage(){
        return "Formato de tel�fono incorrecto, deben ser 9 d�gitos.";
    }

}
