package Presentacion.GUITaller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Negocio.Taller.TransferTaller;
import Presentacion.Controlador.Gestor_de_Taller;
import Presentacion.Generales.JBotonMenu;
import Presentacion.Generales.JDialogOKOption;
import Presentacion.Generales.VentanaEstandar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI_BuscarParaCrearFactura{
	
	private static GUI_BuscarParaCrearFactura instance = null;
	
	private JLabel lb_matricula;
	private JTextField txt_matricula;
	private JBotonMenu bt_siguiente;
	private JFrame frame;
	
	public GUI_BuscarParaCrearFactura(){
		create();
	}
	
	public static GUI_BuscarParaCrearFactura getInstance(){
		if(instance == null){
			instance = new GUI_BuscarParaCrearFactura();
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
		bt_siguiente = new JBotonMenu("Buscar");
		
		crearListener();
		
		gbc.gridx = 0; gbc.gridy = 0;
		miPanel.add(lb_matricula, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		miPanel.add(txt_matricula, gbc);
		
		gbc.gridx = 0; gbc.gridy = 2;
		miPanel.add(bt_siguiente, gbc);

		frame = new VentanaEstandar(miPanel, "images/icoTaller.png");
		
		frame.getRootPane().setDefaultButton(bt_siguiente);
		
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
			Gestor_de_Taller.getInstance().FacturarServicioPrestado(tranferTaller);
			}
		});
	}
	
	public void setVisible(boolean x){
		txt_matricula.setText("");
		this.frame.setVisible(x);
		if (x) this.frame.toFront();
	}
	
	public void mostrarAlerta(String texto){
		new JDialogOKOption(frame, texto, "¡Error!", new ImageIcon("images/warning2.png")).setVisible(true);
	}
	
}