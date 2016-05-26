package SubsSistemaGestorLavadero;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import Principal.JMyComboBox;
import Principal.TransferTaller;
import Principal.VentanaEstandar;
import SubSistemaGestorTaller.Gestor_de_Taller;

public class GUI_SeleccionarTipo {

	private static GUI_SeleccionarTipo instance = null;

	private JPanel root;
	private JLabel lb_tipoAgua;
	private JLabel lb_tipoLavado;
	private JLabel lb_cristales;
	private JLabel lb_Llantas;
	private JMyComboBox op_agua;
	private JMyComboBox op_lavado;
	private JMyComboBox op_cristales;
	private JMyComboBox op_llantas;
	private JFrame frame;
	JButton bt_iniciarLavado;
	private SwingWorker worker;

	public GUI_SeleccionarTipo() {
		create();
	}

	public static GUI_SeleccionarTipo getInstance() {
		if (instance == null) {
			instance = new GUI_SeleccionarTipo();
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

		bt_iniciarLavado = new JButton("Iniciar lavado");
		lb_tipoAgua = new JLabel("Tipo de agua");
		lb_tipoLavado = new JLabel("Tipo de lavado");
		lb_cristales = new JLabel("Cristales");
		lb_Llantas = new JLabel("Llantas");

		op_agua = new JMyComboBox(null);
		op_agua.setPreferredSize(new Dimension(150, 24));
		op_lavado = new JMyComboBox(null);
		op_lavado.setPreferredSize(new Dimension(150, 24));
		op_cristales = new JMyComboBox(null);
		op_cristales.setPreferredSize(new Dimension(150, 24));
		op_llantas = new JMyComboBox(null);
		op_llantas.setPreferredSize(new Dimension(150, 24));

		op_agua.addItem("Agua fría");
		op_agua.addItem("Agua caliente");

		op_lavado.addItem("Lavado rápido");
		op_lavado.addItem("Lavado completo");

		op_cristales.addItem("Nada");
		op_cristales.addItem("Ecológico");
		op_cristales.addItem("Químico");

		op_llantas.addItem("Nada");
		op_llantas.addItem("Ecológico");
		op_llantas.addItem("Químico");

		crearListener();

		
		gbc.anchor = GridBagConstraints.EAST;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		root.add(lb_tipoAgua, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		root.add(lb_tipoLavado, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		root.add(lb_cristales, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		root.add(lb_Llantas, gbc);

		gbc.anchor = GridBagConstraints.CENTER;
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		root.add(op_agua, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		root.add(op_lavado, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		root.add(op_cristales, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		root.add(op_llantas, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		root.add(bt_iniciarLavado, gbc);

		frame = new VentanaEstandar(root, "iconoLavadero.png");

	}

	public void crearListener() {
		bt_iniciarLavado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// crear el thread
				worker = new SwingWorker() {

					@Override
					protected Object doInBackground() {
						Gestor_Lavadero.getInstance().empezarLavado(op_agua.getSelectedIndex(), op_lavado.getSelectedIndex(), op_cristales.getSelectedIndex(), op_llantas.getSelectedIndex());
						return null;
					}
				};
				worker.execute();
				mostrarMensaje("Lavado iniciado.");
				GUI_SeleccionarTipo.getInstance().setVisible(false);
				op_agua.setSelectedIndex(0);
				op_lavado.setSelectedIndex(0);
				op_cristales.setSelectedIndex(0);
				op_llantas.setSelectedIndex(0);				
				GUI_Lavadero.getInstance().setVisible(true);				
			}
		});
	}
	
	public SwingWorker getWorker() {
		return worker;
	}
	
	
	public void setVisible(boolean x) {
		this.frame.setVisible(x);
	}

	public void mostrarAlerta(String texto) {
		JOptionPane.showMessageDialog(frame, texto, "¡Error!", JOptionPane.OK_OPTION);
	}
	
	public void mostrarMensaje(String texto){
		JOptionPane.showMessageDialog(frame,
			    texto,
			    "Pago del lavado",
			    JOptionPane.INFORMATION_MESSAGE);
	}

}
