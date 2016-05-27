package Negocio.Exceptions;

public class MatriculaExistenteException extends Exception {
	private static final long serialVersionUID = 1L;

	public MatriculaExistenteException(){}
	
	@Override
	public String getMessage(){
        return "Ya existe un cliente con esa matrícula";
    }

}
