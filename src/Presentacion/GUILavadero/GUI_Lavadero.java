/**
 * 
 */
package Presentacion.GUILavadero;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Presentacion.Controlador.Gestor_Lavadero;
import Presentacion.Generales.JBotonMenu;
import Presentacion.Generales.JDialogOKOption;
import Presentacion.Generales.VentanaEstandar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI_Lavadero {
	private static GUI_Lavadero instance = null;
	private JBotonMenu bt_iniciarLavado;
	private JBotonMenu bt_interrumpirLavado;
	private JBotonMenu bt_finalizarLavado;
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
		
		bt_iniciarLavado = new JBotonMenu("Iniciar lavado");
		bt_iniciarLavado.setPreferredSize(new Dimension(200, 50));
		bt_interrumpirLavado = new JBotonMenu("Interrumpir lavado");
		bt_interrumpirLavado.setPreferredSize(new Dimension(200, 50));
		bt_finalizarLavado = new JBotonMenu("Finalizar lavado");
		bt_finalizarLavado.setPreferredSize(new Dimension(200, 50));
		
		crearListeners();
		
		// Añadimos todos los componentes a nuestro JPanel usando el Layout que hayamos definido
		gbc.gridx = 0; gbc.gridy = 0;
		miPanel.add(bt_iniciarLavado, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		miPanel.add(bt_interrumpirLavado, gbc);
		
		gbc.gridx = 0; gbc.gridy = 2;
		miPanel.add(bt_finalizarLavado, gbc);
						
		

		// Creamos la instancia de ventana estandar pasandole como contenido nuestro panel central
		frame = new VentanaEstandar(miPanel, "images/icoLavadero.png");
	}
	
	public void crearListeners(){
		bt_iniciarLavado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Gestor_Lavadero.getInstance().getPrecioTotal() == 0){
					Gestor_Lavadero.getInstance().comprobarLavadoIniciado();
				}
				else{
					mostrarAlerta("Debe finalizar el lavado antes de empezar uno nuevo.");
				}				
			}
		});
		
		bt_interrumpirLavado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(GUI_InterrumpirLavado.getInstance().getBar().getValue() != 0){
					setVisible(false);
					GUI_InterrumpirLavado.getInstance().setVisible(true);
				}
				else{				
					GUI_InterrumpirLavado.getInstance().setVisible(false);
					mostrarAlerta("No hay ningún lavado en curso");
				}
				
			}
		});
	
		bt_finalizarLavado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GUI_InterrumpirLavado.getInstance().setVisible(false);
				if(GUI_InterrumpirLavado.getInstance().getBar().getValue() != 0){
					mostrarAlerta("El lavado aun está en curso.");
				}
				else if(Gestor_Lavadero.getInstance().getPrecioTotal() == 0){
					mostrarAlerta("Todavia no ha iniciado el lavado.");
				}
				else{
					frame.setVisible(false);
					GUI_FinalizarLavado.getInstance().setVisible(true);
				}
				
			}
		});
	}
	
	public void mostrarAlerta(String texto){
		new JDialogOKOption(frame, texto, "¡Error!", new ImageIcon("images/warning2.png")).setVisible(true);
	}
	
	public void setVisible(boolean x){
		this.frame.setVisible(x);
	}


}