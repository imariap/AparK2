package Presentacion.GUITaller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import Negocio.Taller.TransferPieza;
import Negocio.Taller.TransferTaller;
import Presentacion.Controlador.Gestor_de_Taller;
import Presentacion.Generales.JBotonMenu;
import Presentacion.Generales.JDialogOKOption;
import Presentacion.Generales.JDialogPiezas;
import Presentacion.Generales.VentanaEstandar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Main.Main;

public class GUI_CrearFactura{

	@SuppressWarnings("rawtypes")
	private JList listaPiezas;
	private JLabel lb_nombre;
	private JLabel lb_piezas;
	private JLabel lb_importe;
	private JLabel lb_manodeobra;
	private JLabel lb_ivaporc;
	private JLabel lb_iva;
	private JLabel lb_total;
	
	private JTextField txt_nombre;
	private JTextField txt_importe;
	private JTextField txt_manodeobra;
	private JTextField txt_ivaporc;
	private JTextField txt_iva;
	private JTextField txt_total;
	
	private JBotonMenu bt_guardar;
	private JBotonMenu bt_cancelar;
	private JFrame frame;
	JScrollPane scrollPane;
	
	private TransferTaller transfer;
	
	private ArrayList<TransferPieza> piezas;
	private DefaultListModel<String> model;
	
	private static GUI_CrearFactura instance = null;
	
	public GUI_CrearFactura(){		
		piezas = new ArrayList<TransferPieza>();
		model = new DefaultListModel<String>();
		listaPiezas = new JList<String>(model);
		create();		
	}
	
	
	public static GUI_CrearFactura getInstance(){
		if(instance == null){
			instance = new GUI_CrearFactura();
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
				
		JBotonMenu bt_anadirPieza = new JBotonMenu("Añadir pieza");
        //bt_anadirPieza.setText();
        bt_anadirPieza.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				URL iconoPiezas = Main.class.getResource("/Presentacion/Images/iconoPiezas.png");
				ArrayList<String> campos = new JDialogPiezas(frame, "Introducir pieza:", "Introducir nueva pieza:", new ImageIcon(iconoPiezas)).showDialog();
				if(campos.size() > 0){
			         
			         if(campos.get(0).isEmpty()){
			        	 mostrarAlerta("El campo 'Nombre' de la pieza no puede estar vacio.");
			        	 bt_anadirPieza.doClick();
			         }
			         else{
			        	 TransferPieza p = new TransferPieza();  
							p.setNombre(campos.get(0));
			        	 try{
				        	 p.setPrecio(Double.parseDouble(campos.get(1)));
				        	 piezas.add(p);	
					         txt_importe.setText(String.valueOf(Double.parseDouble(txt_importe.getText()) + p.getPrecio() ));
					         model.addElement(campos.get(0) + ":  " + campos.get(1) + "€");		
					         txt_iva.setText(String.format("%.2f", (Double.parseDouble(txt_importe.getText()) * Integer.parseInt(txt_ivaporc.getText()) /100) + (Double.parseDouble(txt_manodeobra.getText()) * Integer.parseInt(txt_ivaporc.getText()) /100)));
					         txt_iva.setText(txt_iva.getText().replace(',', '.'));
					         txt_total.setText(String.format("%.2f", Double.parseDouble(txt_importe.getText()) + Double.parseDouble(txt_manodeobra.getText()) + Double.parseDouble(txt_iva.getText())));
					         txt_total.setText(txt_total.getText().replace(',', '.'));
					         miPanel.revalidate();
					         miPanel.repaint();
					      } catch (NumberFormatException a){
								mostrarAlerta("El precio debe ser un número. (Ej: 12.30)");
								bt_anadirPieza.doClick();
							}
				         
			         }	
				}
			}
		});
        
        
				
        lb_nombre = new JLabel("Nombre:");	;
    	lb_piezas = new JLabel("Piezas:");	;
    	lb_importe = new JLabel("Importe:");	;
    	lb_manodeobra = new JLabel("Mano de obra:");	;
    	lb_ivaporc = new JLabel("Porcentaje de IVA (%):");	;
    	lb_iva = new JLabel("Total de IVA:");	;
    	lb_total = new JLabel("TOTAL:");	;
    	
    	txt_nombre = new JTextField(10);
    	txt_importe = new JTextField(10);
    	txt_importe.setText("0");
    	txt_importe.setEditable(false);
    	txt_manodeobra = new JTextField(10);
    	txt_manodeobra.setText("0");
    	txt_ivaporc = new JTextField(10);
    	txt_ivaporc.setText("21");
    	txt_ivaporc.setEditable(false);
    	txt_iva = new JTextField(10);
    	txt_iva.setText("0");
    	txt_iva.setEditable(false);
    	txt_total = new JTextField(10);
    	txt_total.setText("0");
    	txt_total.setEditable(false);
    	new JTextField(10);
    	
    	// Tratamiento especial para la mano de obra
    	// Ya que debe calcular el total solo cuando
    	// Pierda el focus.
    	txt_manodeobra.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				try{
					// TODO Auto-generated method stub
					txt_iva.setText(String.format("%.2f", (Double.parseDouble(txt_importe.getText()) * Integer.parseInt(txt_ivaporc.getText()) /100) + (Double.parseDouble(txt_manodeobra.getText()) * Integer.parseInt(txt_ivaporc.getText()) /100)));
					txt_iva.setText(txt_iva.getText().replace(',', '.'));
					txt_total.setText(String.format("%.2f", Double.parseDouble(txt_importe.getText()) + Double.parseDouble(txt_manodeobra.getText()) + Double.parseDouble(txt_iva.getText())));
			        txt_total.setText(txt_total.getText().replace(',', '.'));
			        miPanel.revalidate();
			         miPanel.repaint();
				} catch (NumberFormatException a){
					System.out.println(a.getMessage());
					mostrarAlerta("La mano de obra debe ser un número. (Ej: 12.30)");
					txt_manodeobra.setText("0");
				}
				
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
    	
    	bt_guardar = new JBotonMenu("Guardar");
		bt_cancelar = new JBotonMenu("Cancelar");
				
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0; gbc.gridy = 0;
		miPanel.add(lb_nombre, gbc);
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1; gbc.gridy = 0;
		miPanel.add(txt_nombre, gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0; gbc.gridy = 1;
		miPanel.add(lb_piezas, gbc);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1; gbc.gridy = 2;
		miPanel.add(bt_anadirPieza, gbc);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1; gbc.gridy = 1;
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(listaPiezas);
		scrollPane.setPreferredSize(new Dimension(150, 80));
        miPanel.add(scrollPane, gbc);
		
        gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0; gbc.gridy = 3;
		miPanel.add(lb_importe, gbc);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1; gbc.gridy = 3;
		miPanel.add(txt_importe, gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0; gbc.gridy = 4;
		miPanel.add(lb_manodeobra, gbc);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1; gbc.gridy = 4;
		miPanel.add(txt_manodeobra, gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0; gbc.gridy = 5;
		miPanel.add(lb_ivaporc, gbc);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1; gbc.gridy = 5;
		miPanel.add(txt_ivaporc, gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0; gbc.gridy = 6;
		miPanel.add(lb_iva, gbc);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1; gbc.gridy = 6;
		miPanel.add(txt_iva, gbc);
		
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0; gbc.gridy = 7;
		miPanel.add(lb_total, gbc);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 1; gbc.gridy = 7;
		miPanel.add(txt_total, gbc);
		

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 0; gbc.gridy = 8;
		miPanel.add(bt_guardar, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx = 1; gbc.gridy = 8;
		miPanel.add(bt_cancelar, gbc);
		
		bt_guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				transfer.addFactura(txt_nombre.getText(), Double.parseDouble(txt_importe.getText()), Double.parseDouble(txt_manodeobra.getText()), Integer.parseInt(txt_ivaporc.getText()), Double.parseDouble(txt_iva.getText()), Double.parseDouble(txt_total.getText()), piezas);
				Gestor_de_Taller.getInstance().crearFactura(transfer);				
			}
		});
		
		bt_cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				GUI_Taller.getInstance().setVisible(true);
			}
		});
		
		URL icoTaller = Main.class.getResource("/Presentacion/Images/icoTaller.png");
		frame = new VentanaEstandar(miPanel, icoTaller);
		
		frame.getRootPane().setDefaultButton(bt_guardar);
	}
	
	public void setVisible(boolean x){
		limpiarCampos();
		this.frame.setVisible(x);
		if (x) this.frame.toFront();
	}
	
	public void setTransfer(TransferTaller transfer){
		this.transfer = transfer;
	}


	public void limpiarCampos() {
		// TODO Auto-generated method stub
		txt_nombre.setText("");
    	txt_importe.setText("0");
    	txt_manodeobra.setText("0");
    	txt_ivaporc.setText("21");
    	txt_iva.setText("0");
    	txt_total.setText("0");
    	model.removeAllElements();
	}
	
	public void mostrarAlerta(String texto){
		URL warning2 = Main.class.getResource("/Presentacion/Images/warning2.png");
		new JDialogOKOption(frame, texto, "¡Error!", new ImageIcon(warning2)).setVisible(true);
	}
	
	public void mostrarMensaje(String texto){
		URL iconoConfirmacion = Main.class.getResource("/Presentacion/Images/iconoConfirmacion.png");
		new JDialogOKOption(frame, texto, "Confirmación", new ImageIcon(iconoConfirmacion)).setVisible(true);
	}

	
}