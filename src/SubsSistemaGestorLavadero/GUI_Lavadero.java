/**
 * 
 */
package SubsSistemaGestorLavadero;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Principal.Empleado;
import Principal.VentanaEstandar;
/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ivan
 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GUI_Lavadero {
	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Empleado empleado;
	private static GUI_Lavadero instance = null;
	private JButton bt_iniciarLavado;
	private JButton bt_interrumpirLavado;
	private JButton bt_finalizarLavado;
	private JFrame frame;
	
	public GUI_Lavadero() {
		create();
		
	}
	
	public static GUI_Lavadero getInstance(){
		if(instance == null){
			instance = new GUI_Lavadero();
		}
		return instance;
	}
	
	
	private void create() {
		// Declaracion del JPanel y su Layout
		JPanel miPanel = new JPanel(new GridBagLayout());		
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        
        // Estilo del JPanel
		miPanel.setBackground(Color.WHITE);
		
		bt_iniciarLavado = new JButton("Iniciar lavado");
		bt_interrumpirLavado = new JButton("Interrumpir lavado");
		bt_finalizarLavado = new JButton("Finalizar lavado");
		
		crearListeners();
		
		// Añadimos todos los componentes a nuestro JPanel usando el Layout que hayamos definido
		gbc.gridx = 0; gbc.gridy = 0;
		miPanel.add(bt_iniciarLavado, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		miPanel.add(bt_interrumpirLavado, gbc);
		
		gbc.gridx = 0; gbc.gridy = 2;
		miPanel.add(bt_finalizarLavado, gbc);
						
		

		// Creamos la instancia de ventana estandar pasandole como contenido nuestro panel central
		frame = new VentanaEstandar(miPanel);
	}
	
	public void crearListeners(){
		bt_iniciarLavado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				GUI_SeleccionarTipo.getInstance().setVisible(true);
			}
		});
		
		bt_interrumpirLavado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);;
				GUI_InterrumpirLavado.getInstance().setVisible(true);
			}
		});
	
		bt_finalizarLavado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				GUI_FinalizarLavado.getInstance().setVisible(true);
			}
		});
	}
	
	public void setVisible(boolean x){
		this.frame.setVisible(x);
	}


}