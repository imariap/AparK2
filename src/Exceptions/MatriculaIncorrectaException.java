package Exceptions;

public class MatriculaIncorrectaException extends Exception {
	
	public MatriculaIncorrectaException(){}
	
	public String excText(){
        return "Formato de matrícula incorrecto. (EJ: 1234XXX)";
    }

}
