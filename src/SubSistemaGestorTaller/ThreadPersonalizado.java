package SubSistemaGestorTaller;


public class ThreadPersonalizado extends Thread {

    
    public ThreadPersonalizado() {
        
    }
    
    public void run() {
       while(!Thread.interrupted()){
        	// Aqui haces lo que quieras
    	   // Por ejemplo el buble del sleep
    	   
    	   // Al acabar termina, o puedes terminarlo desde fuera llamando a interrupt() o algo asi.    	   
        	this.interrupt();
        }        
    }
}
