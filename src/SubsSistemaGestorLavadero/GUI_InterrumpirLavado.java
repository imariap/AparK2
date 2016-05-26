package SubsSistemaGestorLavadero;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import Principal.TransferTaller;
import Principal.VentanaEstandar;
import SubSistemaGestorTaller.GUI_Taller;
import SubSistemaGestorTaller.Gestor_de_Taller;

public class GUI_InterrumpirLavado {
		
		
		private static GUI_InterrumpirLavado instance = null;
		
		private JPanel root;
		private JLabel label;
		private JProgressBar bar;
		private JButton bt;
		private JButton bt2;
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
			bt = new JButton("Interrumpir");
			bt2 = new JButton("Volver");
			
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
			frame = new VentanaEstandar(root, "iconoLavadero.png");
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
			JOptionPane.showMessageDialog(frame,
				    texto,
				    "Confirmación",
				    JOptionPane.INFORMATION_MESSAGE);
		}
		
	
}
