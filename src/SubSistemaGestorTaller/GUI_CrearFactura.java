package SubSistemaGestorTaller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Principal.TransferTaller;
import Principal.VentanaEstandar;
import Principal.TransferTaller.Pieza;

class GUI_CrearFactura{

	private static final long serialVersionUID = 1L;

	private static GUI_ModificarFicha CrearFactura = null;
	
	private JPanel panelPiezas;
	private JList listaPiezas;
	private JLabel lb_nombre;
	private JLabel lb_piezas;
	private JLabel lb_importe;
	private JLabel lb_manodeobra;
	private JLabel lb_ivaporc;
	private JLabel lb_iva;
	private JLabel lb_total;
	private JLabel lb_nombrepieza;
	private JLabel lb_preciopieza;
	
	private JTextField txt_nombre;
	private JTextField txt_importe;
	private JTextField txt_manodeobra;
	private JTextField txt_ivaporc;
	private JTextField txt_iva;
	private JTextField txt_total;
	private JTextField txt_nombrereparacion;
	private JTextField txt_nombrepieza;
	private JTextField txt_preciopieza;
	
	private JButton bt_guardar;
	private JButton bt_cancelar;
	private JFrame frame;
	JScrollPane scrollPane;
	
	private TransferTaller transfer;
	
	private ArrayList<Pieza> piezas;
	private DefaultListModel<String> model;
	
	private static GUI_CrearFactura instance = null;
	
	public GUI_CrearFactura(){		
		piezas = new ArrayList<Pieza>();
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
				
				
		/* Panel para piezas */
		panelPiezas = new JPanel();
        lb_nombrepieza = new JLabel("Pieza:");
        lb_preciopieza = new JLabel("Precio:");
        txt_nombrepieza = new JTextField(10);
        txt_preciopieza = new JTextField(5);
        panelPiezas.add(lb_nombrepieza);    
        panelPiezas.add(txt_nombrepieza);
        panelPiezas.add(lb_preciopieza);    
        panelPiezas.add(txt_preciopieza);		
        
        JButton bt_anadirPieza = new JButton();
        bt_anadirPieza.setText("Añadir pieza");
        bt_anadirPieza.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txt_nombrepieza.setText("");
				txt_preciopieza.setText("");
				int result = JOptionPane.showConfirmDialog(frame, panelPiezas, 
			               "Introducir pieza:", JOptionPane.OK_CANCEL_OPTION);
			      if (result == JOptionPane.OK_OPTION) {
			         Pieza p = new Pieza();
			         p.setNombre(txt_nombrepieza.getText());
			         p.setPrecio(Double.parseDouble(txt_preciopieza.getText()));
			         piezas.add(p);	
			         txt_importe.setText(String.valueOf(Double.parseDouble(txt_importe.getText()) + p.getPrecio() ));
			         model.addElement(txt_nombrepieza.getText() + ":  " + txt_preciopieza.getText() + "€");		
			         txt_iva.setText(String.valueOf( (Double.parseDouble(txt_importe.getText()) * Integer.parseInt(txt_ivaporc.getText()) /100) + (Double.parseDouble(txt_manodeobra.getText()) * Integer.parseInt(txt_ivaporc.getText()) /100)));
			         txt_total.setText(String.valueOf( Double.parseDouble(txt_importe.getText()) + Double.parseDouble(txt_manodeobra.getText()) + Double.parseDouble(txt_iva.getText())));
			         miPanel.revalidate();
			         miPanel.repaint();
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
    	lb_nombrepieza = new JLabel("Nombre:");	;
    	lb_preciopieza = new JLabel("Precio:");	;
    	
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
    	txt_nombrereparacion = new JTextField(10);
    	
    	// Tratamiento especial para la mano de obra
    	// Ya que debe calcular el total solo cuando
    	// Pierda el focus.
    	txt_manodeobra.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				txt_iva.setText(String.valueOf( (Double.parseDouble(txt_importe.getText()) * Integer.parseInt(txt_ivaporc.getText()) /100) + (Double.parseDouble(txt_manodeobra.getText()) * Integer.parseInt(txt_ivaporc.getText()) /100)));
		         txt_total.setText(String.valueOf( Double.parseDouble(txt_importe.getText()) + Double.parseDouble(txt_manodeobra.getText()) + Double.parseDouble(txt_iva.getText())));
		         miPanel.revalidate();
		         miPanel.repaint();
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
    	
    	bt_guardar = new JButton("Guardar");
		bt_cancelar = new JButton("Cancelar");
				
		
		gbc.gridx = 0; gbc.gridy = 0;
		miPanel.add(lb_nombre, gbc);
		
		gbc.gridx = 1; gbc.gridy = 0;
		miPanel.add(txt_nombre, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		miPanel.add(lb_piezas, gbc);
		
		gbc.gridx = 1; gbc.gridy = 2;
		miPanel.add(bt_anadirPieza, gbc);
		
		gbc.gridx = 1; gbc.gridy = 1;
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(listaPiezas);
		scrollPane.setPreferredSize(new Dimension(150, 80));
        miPanel.add(scrollPane, gbc);
		
		gbc.gridx = 0; gbc.gridy = 3;
		miPanel.add(lb_importe, gbc);
		
		gbc.gridx = 1; gbc.gridy = 3;
		miPanel.add(txt_importe, gbc);
		
		gbc.gridx = 0; gbc.gridy = 4;
		miPanel.add(lb_manodeobra, gbc);
		
		gbc.gridx = 1; gbc.gridy = 4;
		miPanel.add(txt_manodeobra, gbc);
		
		gbc.gridx = 0; gbc.gridy = 5;
		miPanel.add(lb_ivaporc, gbc);
		
		gbc.gridx = 1; gbc.gridy = 5;
		miPanel.add(txt_ivaporc, gbc);
		
		gbc.gridx = 0; gbc.gridy = 6;
		miPanel.add(lb_iva, gbc);
		
		gbc.gridx = 1; gbc.gridy = 6;
		miPanel.add(txt_iva, gbc);
		
		gbc.gridx = 0; gbc.gridy = 7;
		miPanel.add(lb_total, gbc);
		
		gbc.gridx = 1; gbc.gridy = 7;
		miPanel.add(txt_total, gbc);
		
		gbc.gridx = 0; gbc.gridy = 8;
		miPanel.add(bt_guardar, gbc);
		
		gbc.gridx = 1; gbc.gridy = 8;
		miPanel.add(bt_cancelar, gbc);
		
		bt_guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				transfer.addFactura(txt_nombre.getText(), Double.parseDouble(txt_importe.getText()), Double.parseDouble(txt_manodeobra.getText()), Integer.parseInt(txt_ivaporc.getText()), Double.parseDouble(txt_iva.getText()), Double.parseDouble(txt_total.getText()), piezas);
				Gestor_de_Taller.getInstance().ModificarFichaVehiculo(transfer);
				setVisible(false);
				GUI_Taller.getInstance().setVisible(true);
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
		
		frame = new VentanaEstandar(miPanel);
	}
	
	public void setVisible(boolean x){
		this.frame.setVisible(x);
	}
	
	public void setTransfer(TransferTaller transfer){
		this.transfer = transfer;
	}
	
}