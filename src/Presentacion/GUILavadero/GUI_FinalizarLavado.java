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
		frame = new VentanaEstandar(root, "images/icoLavadero.png");

	}
		public void crearListener(){
			bt_tarjeta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarAviso("Introduzca su tarjeta");
				Gestor_Lavadero.getInstance().pagarLavado();
				mostrarMensaje("Pago correcto. ¡Gracias por su visita!");
				setVisible(false);
				GUI_Lavadero.getInstance().setVisible(true);
				
				}
			});
			bt_efectivo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					mostrarAviso("Por favor, pase por caja para finalizar el pago.");
					Gestor_Lavadero.getInstance().pagarLavado();
					setVisible(false);
					GUI_Lavadero.getInstance().setVisible(true);
					
					}
				});
		}
		
		public void setVisible(boolean x){
			lb2.setText("El importe del lavado es " + Gestor_Lavadero.getInstance().getPrecioTotal() + " €");
			this.frame.setVisible(x);
			if (x) this.frame.toFront();
		}
		
		public void mostrarMensaje(String texto){
			new JDialogOKOption(frame, texto, "Confirmación", new ImageIcon("images/iconoConfirmacion.png")).setVisible(true);
		}
		
		public void mostrarAviso(String texto){
			new JDialogOKOption(frame, texto, "Atención", new ImageIcon("images/warning2.png")).setVisible(true);
		}
		
	
}
