package Exceptions;

public class MatriculaIncorrectaException extends Exception {
	
	public MatriculaIncorrectaException(){}
	
	public String excText(){
        return "Formato de matr�cula incorrecto. (EJ: 1234XXX)";
    }

}
