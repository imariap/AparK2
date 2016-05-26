package Exceptions;

public class MatriculaExistenteException extends Exception {
	
	public MatriculaExistenteException(){}
	
	@Override
	public String getMessage(){
        return "Ya existe un cliente con esa matrícula";
    }

}
