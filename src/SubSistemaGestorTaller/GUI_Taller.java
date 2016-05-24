/**
 * 
 */
package SubSistemaGestorTaller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


















/*
 * crearFactura
 * imprimirFactura
 * introducirMatricula si existe se puede modificar datos, si no se añaden
 * ModificarFicha
 */
import Principal.Empleado;
import Principal.Factura;
import Principal.MenuPrincipal;
import Principal.TransferTaller;
import Principal.TransferTaller.Pieza;
import Principal.VentanaEstandar;

public class GUI_Taller{

	private static GUI_Taller instance = null;
	private JButton bt_registrarIngreso;
	private JButton bt_modificarFicha;
	private JButton bt_crearFactura;
	private JFrame frame;
	
	public GUI_Taller(){
		create();
		
	}
	
	public static GUI_Taller getInstance(){
		if(instance == null){
			instance = new GUI_Taller();
		}
		return instance;
	}
	
	
	private void create() {
		// Declaracion del JPanel y su Layout
		JPanel miPanel = new JPanel(new GridBagLayout());		
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        
        // Estilo del JPanel
		miPanel.setBackground(Color.WHITE);
		
		bt_registrarIngreso = new JButton("Registrar ingreso de vehiculo");
		bt_modificarFicha = new JButton("Modificar ficha de vehiculo");
		bt_crearFactura = new JButton("Facturar servicio prestado");
		
		crearListeners();
		
		// Añadimos todos los componentes a nuestro JPanel usando el Layout que hayamos definido
		gbc.gridx = 0; gbc.gridy = 0;
		miPanel.add(bt_registrarIngreso, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		miPanel.add(bt_modificarFicha, gbc);
		
		gbc.gridx = 0; gbc.gridy = 2;
		miPanel.add(bt_crearFactura, gbc);
						
		

		// Creamos la instancia de ventana estandar pasandole como contenido nuestro panel central
		frame = new VentanaEstandar(miPanel);
	}
	
	public void crearListeners(){
		bt_registrarIngreso.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				ModificarFicha.getInstance().setVisible(true);
			}
		});
		
		bt_modificarFicha.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);;
				BuscarParaModificarFicha.getInstance().setVisible(true);
			}
		});
	
		bt_crearFactura.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
				BuscarParaCrearFactura.getInstance().setVisible(true);
			}
		});
	}
	
	public void setVisible(boolean x){
		this.frame.setVisible(x);
	}
	
}

class ModificarFicha{
	
	private static ModificarFicha instance = null;
	
	private JPanel root;
	private JLabel lb_nombre;
	private JLabel lb_apellidos;
	private JLabel lb_dni;
	private JLabel lb_matricula;
	private JLabel lb_telefono;
	private JLabel lb_observaciones;
	private JLabel lb_averia;
	
	private JTextField txt_nombre;
	private JTextField txt_apellidos;
	private JTextField txt_dni;
	private JTextField txt_matricula;
	private JTextField txt_telefono;
	private JTextField txt_observaciones;
	private JTextField txt_averia;
	
	private JButton bt_guardar;
	private JButton bt_cancelar;
	
	private JFrame frame;
	
	
	
	
	public ModificarFicha(){
		create();
	}
	public static ModificarFicha getInstance(){
		if(instance == null){
			instance = new ModificarFicha();
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
		lb_averia = new JLabel("Averia:");
		
		
		txt_nombre = new JTextField();
		txt_nombre.setPreferredSize( new Dimension( 200, 24 ) );
		txt_apellidos = new JTextField();
		txt_apellidos.setPreferredSize( new Dimension( 200, 24 ) );
		txt_dni = new JTextField();
		txt_dni.setPreferredSize( new Dimension( 200, 24 ) );
		txt_matricula = new JTextField();
		txt_matricula.setPreferredSize( new Dimension( 200, 24 ) );
		txt_telefono = new JTextField();
		txt_telefono.setPreferredSize( new Dimension( 200, 24 ) );
		txt_observaciones = new JTextField();
		txt_observaciones.setPreferredSize( new Dimension( 200, 24 ) );
		txt_averia = new JTextField();
		txt_averia.setPreferredSize( new Dimension( 200, 24 ) );
		
	
		bt_guardar = new JButton("Guardar");
		bt_cancelar = new JButton("Cancelar");
		
		
		gbc.gridx = 0; gbc.gridy = 0;
		miPanel.add(lb_nombre, gbc);
		
		gbc.gridx = 1; gbc.gridy = 0;
		miPanel.add(txt_nombre, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		miPanel.add(lb_apellidos, gbc);
		
		gbc.gridx = 1; gbc.gridy = 1;
		miPanel.add(txt_apellidos, gbc);
		
		gbc.gridx = 0; gbc.gridy = 2;
		miPanel.add(lb_dni, gbc);
		
		gbc.gridx = 1; gbc.gridy = 2;
		miPanel.add(txt_dni, gbc);
		
		gbc.gridx = 0; gbc.gridy = 3;
		miPanel.add(lb_matricula, gbc);
		
		gbc.gridx = 1; gbc.gridy = 3;
		miPanel.add(txt_matricula, gbc);
		
		gbc.gridx = 0; gbc.gridy = 4;
		miPanel.add(lb_telefono, gbc);
		
		gbc.gridx = 1; gbc.gridy = 4;
		miPanel.add(txt_telefono, gbc);
		
		gbc.gridx = 0; gbc.gridy = 5;
		miPanel.add(lb_observaciones, gbc);
		
		gbc.gridx = 1; gbc.gridy = 5;
		miPanel.add(txt_observaciones, gbc);
		
		gbc.gridx = 0; gbc.gridy = 6;
		miPanel.add(lb_averia, gbc);
		
		gbc.gridx = 1; gbc.gridy = 6;
		miPanel.add(txt_averia, gbc);
		
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
				setVisible(false);
				limpiarCampos();
				MenuPrincipal.getInstance().setVisible(true);
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
		
		frame = new VentanaEstandar(miPanel);
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
	}

	public void limpiarCampos(){
		 txt_nombre.setText("");
		 txt_apellidos.setText("");
		 txt_dni.setText("");
		 txt_telefono.setText("");
		 txt_matricula.setText("");
		 txt_observaciones.setText("");
	}

}

class BuscarParaModificarFicha{
	
	private static final long serialVersionUID = 1L;

	private static BuscarParaModificarFicha instance = null;
	
	private JPanel root;
	private JLabel lb_matricula;
	private JTextField txt_matricula;
	private JButton bt_siguiente;
	private JFrame frame;
	
	public BuscarParaModificarFicha(){
		create();
	}
	
	public static BuscarParaModificarFicha getInstance(){
		if(instance == null){
			instance = new BuscarParaModificarFicha();
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
			txt_matricula.setText("");
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

class CrearFactura{

	private static final long serialVersionUID = 1L;

	private static ModificarFicha CrearFactura = null;
	
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
	
	private TransferTaller transfer;
	
	private ArrayList<Pieza> piezas;
	private DefaultListModel<String> model;
	
	private static CrearFactura instance = null;
	
	public CrearFactura(){		
		piezas = new ArrayList<Pieza>();
		model = new DefaultListModel<String>();
		listaPiezas = new JList<String>(model);
		create();		
	}
	
	
	public static CrearFactura getInstance(){
		if(instance == null){
			instance = new CrearFactura();
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
			         model.addElement("Pieza: " + txt_nombrepieza.getText() + " Precio: " + txt_preciopieza.getText());		
			         txt_iva.setText(String.valueOf(Double.parseDouble(txt_importe.getText()) * Integer.parseInt(txt_ivaporc.getText())/100));
			         
			         miPanel.revalidate();
			         miPanel.repaint();
			      }
			}
		});
        
        
				
        lb_nombre = new JLabel("Nombre:");	;
    	lb_piezas = new JLabel("Piezas:");	;
    	lb_importe = new JLabel("Importe:");	;
    	lb_manodeobra = new JLabel("Mano de obra:");	;
    	lb_ivaporc = new JLabel("IVA:");	;
    	lb_iva = new JLabel("Total de IVA:");	;
    	lb_total = new JLabel("TOTAL:");	;
    	lb_nombrepieza = new JLabel("Nombre:");	;
    	lb_preciopieza = new JLabel("Precio:");	;
    	
    	txt_nombre = new JTextField(10);
    	txt_importe = new JTextField(10);
    	txt_importe.setText("0");
    	txt_importe.setEditable(false);
    	txt_manodeobra = new JTextField(10);
    	txt_ivaporc = new JTextField(10);
    	txt_iva = new JTextField(10);
    	txt_total = new JTextField(10);
    	txt_nombrereparacion = new JTextField(10);
    	
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
        miPanel.add(listaPiezas, gbc);
		
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

class BuscarParaCrearFactura{
	
	private static final long serialVersionUID = 1L;

	private static BuscarParaCrearFactura instance = null;
	
	private JPanel root;
	private JLabel lb_matricula;
	private JTextField txt_matricula;
	private JButton bt_siguiente;
	private JFrame frame;
	
	public BuscarParaCrearFactura(){
		create();
	}
	
	public static BuscarParaCrearFactura getInstance(){
		if(instance == null){
			instance = new BuscarParaCrearFactura();
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
			Gestor_de_Taller.getInstance().FacturarServicioPrestado(tranferTaller);
			txt_matricula.setText("");
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


