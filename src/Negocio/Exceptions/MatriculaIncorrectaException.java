package Negocio.Exceptions;

public class MatriculaIncorrectaException extends Exception {
	
	public MatriculaIncorrectaException(){}
	
	@Override
	public String getMessage(){
        return "Formato de matr�cula incorrecto. (Ej: 1234XXX)";
    }

}
