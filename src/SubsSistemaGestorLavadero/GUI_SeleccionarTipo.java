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
	private JComboBox<String> op_agua;
	private JComboBox<String> op_lavado;
	private JComboBox<String> op_cristales;
	private JComboBox<String> op_llantas;
	private JFrame frame;
	JButton bt_iniciarLavado;
	private SwingWorker worker;

	public SwingWorker getWorker() {
		return worker;
	}

	public void setWorker(SwingWorker worker) {
		this.worker = worker;
	}

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

		op_agua = new JComboBox<String>();
		op_agua.setPreferredSize(new Dimension(150, 24));
		op_lavado = new JComboBox<String>();
		op_lavado.setPreferredSize(new Dimension(150, 24));
		op_cristales = new JComboBox<String>();
		op_cristales.setPreferredSize(new Dimension(150, 24));
		op_llantas = new JComboBox<String>();
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

		frame = new VentanaEstandar(root);

	}

	public void crearListener() {
		bt_iniciarLavado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// crear el thread
				setVisible(false);
				op_agua.setSelectedIndex(0);
				op_lavado.setSelectedIndex(0);
				op_cristales.setSelectedIndex(0);
				op_llantas.setSelectedIndex(0);
				GUI_Lavadero.getInstance().setVisible(true);

				//
				worker = new SwingWorker() {

					@Override
					protected Object doInBackground() throws Exception {
						GUI_InterrumpirLavado.getInstance().getBar().setValue(0);
						while (GUI_InterrumpirLavado.getInstance().getBar().getValue() < 100) {
							GUI_InterrumpirLavado.getInstance().getBar()
									.setValue((int) (GUI_InterrumpirLavado.getInstance().getBar().getValue() + 1));
							GUI_InterrumpirLavado.getInstance().getBar().repaint();
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								//e.printStackTrace();
							}
						}
						return null;
					}
				};
				worker.execute();
			}
		});
	}
public void fin(){
	worker.cancel(true);
}
	public void setVisible(boolean x) {
		this.frame.setVisible(x);
	}

	public void mostrarAlerta(String texto) {
		JOptionPane.showMessageDialog(frame, texto, "¡Error!", JOptionPane.OK_OPTION);
	}

}
