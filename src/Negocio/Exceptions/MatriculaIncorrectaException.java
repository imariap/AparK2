package Negocio.Exceptions;

public class MatriculaIncorrectaException extends Exception {
	private static final long serialVersionUID = 1L;

	public MatriculaIncorrectaException(){}
	
	@Override
	public String getMessage(){
        return "Formato de matrícula incorrecto. (Ej: 1234XXX)";
    }

}
