package Presentacion.GUILavadero;

import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class GUI_InterrumpirLavado {
		
		
		private static GUI_InterrumpirLavado instance = null;
		
		private JPanel root;
		private JLabel label;
		private JProgressBar bar;
		private JBotonMenu bt;
		private JBotonMenu bt2;
		private JFrame frame;
		
		public JProgressBar getBar() {
			return bar;
		}

		public void setBar(JProgressBar bar) {
			this.bar = bar;
		}
		
		
		public GUI_InterrumpirLavado(){
			create();
		}
		
		public static GUI_InterrumpirLavado getInstance(){
			if(instance == null){
				instance = new GUI_InterrumpirLavado();
			}
			return instance;
		}
		private void create(){
			// Declaracion del JPanel y su Layout
			root = new JPanel(new GridBagLayout());		
			GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(10,10,10,10);
	        
	        // Estilo del JPanel
	        root.setBackground(Color.WHITE);
			
			label = new JLabel("¿Está seguro que desea interrumpir el lavado?");
			bar = new JProgressBar();
			bt = new JBotonMenu("Interrumpir");
			bt2 = new JBotonMenu("Volver");
			
			// Añadimos todos los componentes a nuestro JPanel usando el Layout que hayamos definido
			gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
			root.add(label, gbc);
			
			gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.BOTH;
			root.add(bar, gbc);
			
			gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1; gbc.fill = GridBagConstraints.NONE;
			root.add(bt, gbc);
			
			gbc.gridx = 1; gbc.gridy = 2; gbc.gridwidth = 1;
			root.add(bt2, gbc);
			
			crearListener();
			frame = new VentanaEstandar(root, "images/icoLavadero.png");
		}
		public void crearListener(){
			bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Gestor_Lavadero.getInstance().finalizarLavado();								
				}
			});
			
			bt2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					GUI_Lavadero.getInstance().setVisible(true);
					}
				});
		}
		
		public void setVisible(boolean x){
			this.frame.setVisible(x);
		}
		
		public void mostrarAlerta(String texto){
			new JDialogOKOption(frame, texto, "¡Error!", new ImageIcon("images/warning2.png")).setVisible(true);
		}
		
		public void mostrarMensaje(String texto){
			new JDialogOKOption(frame, texto, "Atención", new ImageIcon("images/warning2.png")).setVisible(true);
		}
		
	
}
