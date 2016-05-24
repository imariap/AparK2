package SubSistemaGestorTaller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.sound.sampled.ReverbType;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import Principal.Factura;
import Principal.TransferTaller;
import Principal.VentanaEstandar;
import Principal.TransferTaller.Pieza;

class GUI_MostrarFacturas{
	
	private static final long serialVersionUID = 1L;

	private static GUI_ModificarFicha GUI_MostrarFacturas = null;
	
	private JPanel root;
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
	
	private JLabel txt_nombre;
	private JLabel txt_importe;
	private JLabel txt_manodeobra;
	private JLabel txt_ivaporc;
	private JLabel txt_iva;
	private JLabel txt_total;
	private JLabel txt_nombrereparacion;
	private JLabel txt_nombrepieza;
	private JLabel txt_preciopieza;
	
	private JButton bt_guardar;
	private JButton bt_cancelar;
	private JFrame frame;
	private JScrollPane scrollPane;
	
	private TransferTaller transfer;
	
	private ArrayList<Pieza> piezas;
	private ArrayList<Factura> facturas;
	private DefaultListModel<String> model;
	
	private static GUI_MostrarFacturas instance = null;
	
	public GUI_MostrarFacturas(){		
		piezas = new ArrayList<Pieza>();
		model = new DefaultListModel<String>();
		listaPiezas = new JList<String>(model);
		create();		
	}
	
	
	public static GUI_MostrarFacturas getInstance(){
		if(instance == null){
			instance = new GUI_MostrarFacturas();
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
				
				
		/* Panel para piezas */
		panelPiezas = new JPanel();
        lb_nombrepieza = new JLabel("Pieza:");
        lb_preciopieza = new JLabel("Precio:");
        txt_nombrepieza = new JLabel();
        txt_preciopieza = new JLabel();
        panelPiezas.add(lb_nombrepieza);    
        panelPiezas.add(txt_nombrepieza);
        panelPiezas.add(lb_preciopieza);    
        panelPiezas.add(txt_preciopieza);		
				
        lb_nombre = new JLabel("Nombre:");	;
    	lb_piezas = new JLabel("Piezas:");	;
    	lb_importe = new JLabel("Importe:");	;
    	lb_manodeobra = new JLabel("Mano de obra:");	;
    	lb_ivaporc = new JLabel("Porcentaje de IVA (%):");	;
    	lb_iva = new JLabel("Total de IVA:");	;
    	lb_total = new JLabel("TOTAL:");	;
    	lb_nombrepieza = new JLabel("Nombre:");	;
    	lb_preciopieza = new JLabel("Precio:");	;
    	
    	txt_nombre = new JLabel();
    	txt_importe = new JLabel();
    	txt_manodeobra = new JLabel();
    	txt_ivaporc = new JLabel();
    	txt_iva = new JLabel();
    	txt_total = new JLabel();
    	txt_nombrereparacion = new JLabel();
    	
    	bt_guardar = new JButton("Guardar");
		bt_cancelar = new JButton("Cancelar");
				
		
		gbc.gridx = 0; gbc.gridy = 0;
		root.add(lb_nombre, gbc);
		
		gbc.gridx = 1; gbc.gridy = 0;
		root.add(txt_nombre, gbc);
		
		gbc.gridx = 2; gbc.gridy = 0;
		root.add(lb_piezas, gbc);
		
		gbc.gridx = 2; gbc.gridy = 1;
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(listaPiezas);
		scrollPane.setPreferredSize(new Dimension(150, 800));
		root.add(scrollPane, gbc);
		
		gbc.gridx = 0; gbc.gridy = 2;
		root.add(lb_importe, gbc);
		
		gbc.gridx = 1; gbc.gridy = 2;
		root.add(txt_importe, gbc);
		
		gbc.gridx = 0; gbc.gridy = 3;
		root.add(lb_manodeobra, gbc);
		
		gbc.gridx = 1; gbc.gridy = 3;
		root.add(txt_manodeobra, gbc);
		
		gbc.gridx = 0; gbc.gridy = 4;
		root.add(lb_ivaporc, gbc);
		
		gbc.gridx = 1; gbc.gridy = 4;
		root.add(txt_ivaporc, gbc);
		
		gbc.gridx = 0; gbc.gridy = 5;
		root.add(lb_iva, gbc);
		
		gbc.gridx = 1; gbc.gridy = 5;
		root.add(txt_iva, gbc);
		
		gbc.gridx = 0; gbc.gridy = 6;
		root.add(lb_total, gbc);
		
		gbc.gridx = 1; gbc.gridy = 6;
		root.add(txt_total, gbc);
		
		gbc.gridx = 0; gbc.gridy = 7;
		root.add(bt_guardar, gbc);
		
		gbc.gridx = 1; gbc.gridy = 7;
		root.add(bt_cancelar, gbc);
		
		bt_guardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				transfer.addFactura(txt_nombre.getText(), Double.parseDouble(txt_importe.getText()), Double.parseDouble(txt_manodeobra.getText()), Integer.parseInt(txt_ivaporc.getText()), Double.parseDouble(txt_iva.getText()), Double.parseDouble(txt_total.getText()), piezas);
				Gestor_de_Taller.getInstance().ModificarFichaVehiculo(transfer);
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
		
		frame = new VentanaEstandar(root);
	}
	
	public void setVisible(boolean x){
		this.frame.setVisible(x);
	}
	
	public void setTransfer(TransferTaller transfer){
		this.transfer = transfer;
	}
	
	public void actualizaDatos(ArrayList<Factura> facturas){		
		this.facturas = facturas;
		
		txt_importe.setText(String.valueOf(facturas.get(0).getImporte()) + " �");
		txt_iva.setText(String.format("%.2f", facturas.get(0).getIVA()) + " �");  
		txt_ivaporc.setText(String.valueOf(facturas.get(0).getIVAPorc()) + " %");
		txt_manodeobra.setText(String.valueOf(facturas.get(0).getManoDeObra()) + " �");
		txt_nombre.setText(String.valueOf(facturas.get(0).getNombre()) + " �");
		txt_total.setText(String.valueOf(facturas.get(0).getTOTAL()) + " �");
		for(int i = 0; i < facturas.get(0).getPiezas().size(); i++){
			model.addElement(facturas.get(0).getPiezas().get(i).getNombre() + ":  " + facturas.get(0).getPiezas().get(i).getPrecio() + " �");
		}				
		
		root.revalidate();
		root.repaint();
		setVisible(true);
	}
}