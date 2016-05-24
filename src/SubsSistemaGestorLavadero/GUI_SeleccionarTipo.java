package SubsSistemaGestorLavadero;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JTextField;

import Principal.TransferTaller;
import Principal.VentanaEstandar;
import SubSistemaGestorTaller.Gestor_de_Taller;

public class GUI_SeleccionarTipo {
		
		
		private static GUI_SeleccionarTipo instance = null;
		
		private JPanel root;
		private JLabel lb_matricula;
		private JTextField txt_matricula;
		private JButton bt_siguiente;
		private JFrame frame;
		
		public GUI_SeleccionarTipo(){
			create();
		}
		
		public static GUI_SeleccionarTipo getInstance(){
			if(instance == null){
				instance = new GUI_SeleccionarTipo();
			}
			return instance;
		}
		private void create(){
			// Declaracion del JPanel y su Layout
			JPanel miPanel = new JPanel(new GridBagLayout());		
			GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(10,10,10,10);
	        
	        // Estilo del JPanel
			miPanel.setBackground(Color.WHITE);
			
			lb_matricula = new JLabel("Matricula:");
			txt_matricula = new JTextField();
			txt_matricula.setPreferredSize( new Dimension( 200, 24 ) );
			bt_siguiente = new JButton("Buscar");
			
			crearListener();
			
			gbc.gridx = 0; gbc.gridy = 0;
			miPanel.add(lb_matricula, gbc);
			
			gbc.gridx = 0; gbc.gridy = 1;
			miPanel.add(txt_matricula, gbc);
			
			gbc.gridx = 0; gbc.gridy = 2;
			miPanel.add(bt_siguiente, gbc);

			frame = new VentanaEstandar(miPanel);
			
		}
		public void crearListener(){
			bt_siguiente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*
				 * ¿¿Tenemos que usar el transfer??
				 * 
				 * */
				TransferTaller tranferTaller = new TransferTaller(txt_matricula.getText());
				Gestor_de_Taller.getInstance().action(1, tranferTaller);
				}
			});
		}
		
		public void setVisible(boolean x){
			this.frame.setVisible(x);
		}
		
		public void mostrarAlerta(String texto){
			JOptionPane.showMessageDialog(frame,
				    texto,
				    "¡Error!",
				    JOptionPane.OK_OPTION);
		}
		
	
}
