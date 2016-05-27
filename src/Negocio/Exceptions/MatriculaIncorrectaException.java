package Negocio.Exceptions;

public class MatriculaIncorrectaException extends Exception {
	
	public MatriculaIncorrectaException(){}
	
	@Override
	public String getMessage(){
        return "Formato de matrícula incorrecto. (Ej: 1234XXX)";
    }

}
