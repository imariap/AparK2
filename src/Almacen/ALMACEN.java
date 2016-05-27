package Almacen;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Negocio.Lavadero.TransferLavadero;
import Negocio.Taller.TransferTaller;

public class ALMACEN{
	
	private static ALMACEN instance = null;
	private ArrayList<TransferTaller> datosTaller;
	private static String nombreArchivo = "BaseDeDatos";
	private TransferLavadero preciosLavadero;
	
	@SuppressWarnings("unchecked")
	public ALMACEN(){
		datosTaller = new ArrayList<TransferTaller>();
		preciosLavadero = new TransferLavadero();
		
		/* Datos que contiene la base de datos para el lavadero
		preciosLavadero.getPrecioTipoAgua().add(1.0); // Agua fria
		preciosLavadero.getPrecioTipoAgua().add(1.5); // Agua caliente
		preciosLavadero.getPrecioTipoLavado().add(3.0); // Lavado rapido
		preciosLavadero.getPrecioTipoLavado().add(4.0); // Lavado completo
		preciosLavadero.getPrecioCristales().add(0.0); // Cristales - nada
		preciosLavadero.getPrecioCristales().add(1.0); // Cristales - eco
		preciosLavadero.getPrecioCristales().add(1.5); // Cristales - quimico
		preciosLavadero.getPrecioLlantas().add(0.0); // Llantas - nada
		preciosLavadero.getPrecioLlantas().add(1.0); // Llantas - eco
		preciosLavadero.getPrecioLlantas().add(1.5); // Llantas - quimico */
		
		// Cargamos todos los datos al inicializarlo
		FileInputStream fis;
		try {
			fis = new FileInputStream(nombreArchivo);
			ObjectInputStream ois = new ObjectInputStream(fis);
			datosTaller = (ArrayList<TransferTaller>) ois.readObject();
			preciosLavadero = (TransferLavadero) ois.readObject();
			ois.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ALMACEN getInstance(){
		if(instance == null){
			instance = new ALMACEN();
		}
		return instance;
	}
	
	public void saveOnClose(){
		// Guardamos todos los datos
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(nombreArchivo);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(datosTaller);
			oos.writeObject(preciosLavadero);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public TransferTaller consultarMatricula(TransferTaller datos) {
		
		for(int i = 0; i < datosTaller.size(); i++){
			if(datosTaller.get(i).getMatricula().equals(datos.getMatricula())){				
				return datosTaller.get(i);		
			}
		}
		
		return null;		
	}

	public TransferLavadero obtenerPreciosLavadero() {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		return preciosLavadero;
		// end-user-code
	}

	public void guardaFicha(TransferTaller transfer) {
		// begin-user-code
		// TODO Apéndice de método generado automáticamente
		int index = -1;
		for(int i = 0; i < datosTaller.size(); i++){
			if(datosTaller.get(i).getMatricula().equals(transfer.getMatricula())){	
				index = i;
			}
		}
		
		if(index != -1){
			datosTaller.remove(index);
			datosTaller.add(transfer);
		}
		else{
			datosTaller.add(transfer);
		}
		// end-user-code	
	}	
}