package Presentacion.GUITaller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

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

import Main.Main;

public class GUI_ModificarFicha{
	
	private static GUI_ModificarFicha instance = null;
	
	private JLabel lb_nombre;
	private JLabel lb_apellidos;
	private JLabel lb_dni;
	private JLabel lb_matricula;
	private JLabel lb_telefono;
	private JLabel lb_observaciones;
	private JLabel lb_facturas;
	
	private JTextField txt_nombre;
	private JTextField txt_apellidos;
	private JTextField txt_dni;
	private JTextField txt_matricula;
	private JTextField txt_telefono;
	private JTextField txt_observaciones;
	
	private JBotonMenu bt_verFacturas;
	private JBotonMenu bt_guardar;
	private JBotonMenu bt_cancelar;
	
	private JFrame frame;
	
	
	
	
	public GUI_ModificarFicha(){
		create();
	}
	public static GUI_ModificarFicha getInstance(){
		if(instance == null){
			instance = new GUI_ModificarFicha();
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
		
		lb_nombre = new JLabel("Nombre:");
		lb_apellidos = new JLabel("Apellidos:");
		lb_dni = new JLabel("DNI:");
		lb_matricula = new JLabel("Matricula:");
		lb_telefono = new JLabel("Telefono:");
		lb_observaciones = new JLabel("Observaciones:");
		lb_facturas = new JLabel("Facturas:");
		
		
		txt_nombre = new JTextField();
		txt_nombre.setPreferredSize( new Dimension( 200, 24 ) );
		txt_apellidos = new JTextField();
		txt_apellidos.setPreferredSize( new Dimension( 200, 24 ) );
		txt_dni = new JTextField();
		txt_dni.setPreferredSize( new Dimension( 200, 24 ) );
		txt_matricula = new JTextField();
		txt_matricula.setEditable(false);
		txt_matricula.setPreferredSize( new Dimension( 200, 24 ) );
		txt_telefono = new JTextField();
		txt_telefono.setPreferredSize( new Dimension( 200, 24 ) );
		txt_observaciones = new JTextField();
		txt_observaciones.setPreferredSize( new Dimension( 200, 24 ) );
		
		
		bt_verFacturas = new JBotonMenu("Ver facturas");
		bt_guardar = new JBotonMenu("Guardar");
		bt_cancelar = new JBotonMenu("Cancelar");
		
		gbc.anchor = GridBagConstraints.EAST;
		
		gbc.gridx = 0; gbc.gridy = 0;
		miPanel.add(lb_nombre, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		miPanel.add(lb_apellidos, gbc);
		
		gbc.gridx = 0; gbc.gridy = 2;
		miPanel.add(lb_dni, gbc);
		
		gbc.gridx = 0; gbc.gridy = 3;
		miPanel.add(lb_matricula, gbc);
		
		gbc.gridx = 0; gbc.gridy = 4;
		miPanel.add(lb_telefono, gbc);
		
		gbc.gridx = 0; gbc.gridy = 5;
		miPanel.add(lb_observaciones, gbc);
		
		gbc.gridx = 0; gbc.gridy = 6;
		miPanel.add(lb_facturas, gbc);
		
		gbc.anchor = GridBagConstraints.WEST;
		
		gbc.gridx = 1; gbc.gridy = 0;
		miPanel.add(txt_nombre, gbc);
				
		gbc.gridx = 1; gbc.gridy = 1;
		miPanel.add(txt_apellidos, gbc);
		
		gbc.gridx = 1; gbc.gridy = 2;
		miPanel.add(txt_dni, gbc);
		
		gbc.gridx = 1; gbc.gridy = 3;
		miPanel.add(txt_matricula, gbc);
		
		gbc.gridx = 1; gbc.gridy = 4;
		miPanel.add(txt_telefono, gbc);
		
		gbc.gridx = 1; gbc.gridy = 5;
		miPanel.add(txt_observaciones, gbc);
		
		gbc.anchor = GridBagConstraints.CENTER;
		
		gbc.gridx = 1; gbc.gridy = 6;
		miPanel.add(bt_verFacturas, gbc);
		
		gbc.gridx = 0; gbc.gridy = 7;
		miPanel.add(bt_guardar, gbc);
		
		gbc.gridx = 1; gbc.gridy = 7;
		miPanel.add(bt_cancelar, gbc);
		
		bt_guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TransferTaller transfer = new TransferTaller();
				transfer.setApellidos(txt_apellidos.getText());
				//transfer.setAverias();
				transfer.setDNI(txt_dni.getText());
				//transfer.setFacturas(n);
				transfer.setMatricula(txt_matricula.getText());
				transfer.setNombre(txt_nombre.getText());
				transfer.setObservaciones(txt_observaciones.getText());
				transfer.setTelefono(txt_telefono.getText());
				Gestor_de_Taller.getInstance().ModificarFichaVehiculo(transfer);
			}
		});
		
		bt_cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				limpiarCampos();
				GUI_Taller.getInstance().setVisible(true);
			}
		});
		
		bt_verFacturas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TransferTaller transfer = new TransferTaller();
				transfer.setApellidos(txt_apellidos.getText());
				//transfer.setAverias();
				transfer.setDNI(txt_dni.getText());
				//transfer.setFacturas(n);
				transfer.setMatricula(txt_matricula.getText());
				transfer.setNombre(txt_nombre.getText());
				transfer.setObservaciones(txt_observaciones.getText());
				transfer.setTelefono(txt_telefono.getText());
				Gestor_de_Taller.getInstance().imprimeFactura(transfer);
			}
		});
		
		URL icoTaller = Main.class.getResource("/Presentacion/Images/icoTaller.png");
		frame = new VentanaEstandar(miPanel, icoTaller);
		
		frame.getRootPane().setDefaultButton(bt_guardar);
	}
	
	public void actualizaDatos(TransferTaller datos){
		txt_nombre.setText(datos.getNombre());
		txt_apellidos.setText(datos.getApellidos());
		txt_dni.setText(datos.getDNI());
		txt_matricula.setText(datos.getMatricula());
		txt_telefono.setText(datos.getTelefono());
		txt_observaciones.setText(datos.getObservaciones());
	}
	
	
	public void setVisible(boolean x){
		this.frame.setVisible(x);
		if (x) this.frame.toFront();
	}

	public void limpiarCampos(){
		 txt_nombre.setText("");
		 txt_apellidos.setText("");
		 txt_dni.setText("");
		 txt_telefono.setText("");
		 txt_matricula.setText("");
		 txt_observaciones.setText("");
	}
	
	public void mostrarAlerta(String texto){
		URL warning2 = Main.class.getResource("/Presentacion/Images/warning2.png");
		new JDialogOKOption(frame, texto, "ˇError!", new ImageIcon(warning2)).setVisible(true);
	}
	
	public void mostrarMensaje(String texto){
		URL iconoConfirmacion = Main.class.getResource("/Presentacion/Images/iconoConfirmacion.png");
		new JDialogOKOption(frame, texto, "Confirmación", new ImageIcon(iconoConfirmacion)).setVisible(true);
	}

}