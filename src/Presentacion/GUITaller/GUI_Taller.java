package Presentacion.GUITaller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Main.Main;
import Presentacion.Generales.JBotonMenu;
import Presentacion.Generales.VentanaEstandar;
public class GUI_Taller{

	private static GUI_Taller instance = null;
	private JBotonMenu bt_registrarIngreso;
	private JBotonMenu bt_modificarFicha;
	private JBotonMenu bt_crearFactura;
	private JFrame frame;
	
	public GUI_Taller(){
		create();
		
	}
	
	public static GUI_Taller getInstance(){
		if(instance == null){
			instance = new GUI_Taller();
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
		
		bt_registrarIngreso = new JBotonMenu("Registrar ingreso de vehiculo");
		bt_registrarIngreso.setPreferredSize(new Dimension(200, 50));
		bt_modificarFicha = new JBotonMenu("Ver/Modificar ficha de vehiculo");
		bt_modificarFicha.setPreferredSize(new Dimension(200, 50));
		bt_crearFactura = new JBotonMenu("Facturar servicio prestado");
		bt_crearFactura.setPreferredSize(new Dimension(200, 50));
		
		crearListeners();
		
		// Añadimos todos los componentes a nuestro JPanel usando el Layout que hayamos definido
		gbc.gridx = 0; gbc.gridy = 0;
		miPanel.add(bt_registrarIngreso, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		miPanel.add(bt_modificarFicha, gbc);
		
		gbc.gridx = 0; gbc.gridy = 2;
		miPanel.add(bt_crearFactura, gbc);
						
		

		// Creamos la instancia de ventana estandar pasandole como contenido nuestro panel central
		URL icoTaller = Main.class.getResource("/Presentacion/Images/icoTaller.png");
		frame = new VentanaEstandar(miPanel, icoTaller);
	}
	
	public void crearListeners(){
		bt_registrarIngreso.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				GUI_IngresoVehiculo.getInstance().setVisible(true);
			}
		});
		
		bt_modificarFicha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);;
				GUI_BuscarParaModificarFicha.getInstance().setVisible(true);
			}
		});
	
		bt_crearFactura.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				GUI_BuscarParaCrearFactura.getInstance().setVisible(true);
			}
		});
	}
	
	public void setVisible(boolean x){
		this.frame.setVisible(x);
		if (x) this.frame.toFront();
	}
	
}

