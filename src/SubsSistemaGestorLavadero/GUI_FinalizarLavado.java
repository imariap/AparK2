package SubsSistemaGestorLavadero;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Principal.JBotonMenu;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import Principal.TransferTaller;
import Principal.VentanaEstandar;
import SubSistemaGestorTaller.Gestor_de_Taller;

public class GUI_FinalizarLavado {
		
		
		private static GUI_FinalizarLavado instance = null;
		
		private JPanel root;
		private JLabel lb;
		private JLabel lb2;
		private JBotonMenu bt_tarjeta;
		private JBotonMenu bt_efectivo;
		private JFrame frame;
		
		public GUI_FinalizarLavado(){
			create();
		}
		
		public static GUI_FinalizarLavado getInstance(){
			if(instance == null){
				instance = new GUI_FinalizarLavado();
			}
			return instance;
		}

	private void create() {

		// Declaracion del JPanel y su Layout
		root = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		// Estilo del JPanel
		root.setBackground(Color.WHITE);

		lb = new JLabel("Su lavado ha finalizado correctamente.");
		lb2 = new JLabel("El importe del lavado es " + Gestor_Lavadero.getInstance().getPrecioTotal() + " €");
		
		bt_tarjeta = new JBotonMenu("Tarjeta");
		bt_efectivo = new JBotonMenu("Efectivo");

		// Añadimos todos los componentes a nuestro JPanel usando el Layout que
		// hayamos definido
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		root.add(lb, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		root.add(lb2, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		root.add(bt_tarjeta, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		root.add(bt_efectivo, gbc);

		crearListener();
		frame = new VentanaEstandar(root, "icoLavadero.png");

	}
		public void crearListener(){
			bt_tarjeta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarAlerta("Introduzca su tarjeta");
				Gestor_Lavadero.getInstance().pagarLavado();
				mostrarAlerta("Pago correcto. ¡Gracias por su visita!");
				setVisible(false);
				GUI_Lavadero.getInstance().setVisible(true);
				
				}
			});
			bt_efectivo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					mostrarAlerta("Por favor, pase por caja para finalizar el pago.");
					Gestor_Lavadero.getInstance().pagarLavado();
					setVisible(false);
					GUI_Lavadero.getInstance().setVisible(true);
					
					}
				});
		}
		
		public void setVisible(boolean x){
			lb2.setText("El importe del lavado es " + Gestor_Lavadero.getInstance().getPrecioTotal() + " €");
			this.frame.setVisible(x);
		}
		
		public void mostrarAlerta(String texto){
			JOptionPane.showMessageDialog(frame,
				    texto,
				    "Pago del lavado",
				    JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		
	
}
