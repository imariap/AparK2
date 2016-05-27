package Presentacion.Generales;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class MenuPrincipal {

	private static MenuPrincipal instance = null;

	private JButton botonTaller;
	private JFrame frame;
	
	public MenuPrincipal(){
		create();
		
		
	}
	
	public static MenuPrincipal getInstance(){
		if(instance == null){
			instance = new MenuPrincipal();
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
		
		// JLabels del formulario
		JLabel lb_1 = new JLabel("¡Bienvenido a ApparK2!");
		JLabel lb_2 = new JLabel("Por favor, seleccione una opción del menú de la izquierda.");
		lb_1.setFont(new java.awt.Font("Arial", 1, 13));
		lb_2.setFont(new java.awt.Font("Arial", 1, 13));
		
		// Añadimos todos los componentes a nuestro JPanel usando el Layout que hayamos definido
		gbc.gridx = 0; gbc.gridy = 0;
		miPanel.add(lb_1, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1;
		miPanel.add(lb_2, gbc);
		

		// Creamos la instancia de ventana estandar pasandole como contenido nuestro panel central	
		frame = new VentanaEstandar(miPanel, "iconoIni.png");
	}
	
	public void crearListeners(){
		botonTaller.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//MenuPrincipal.this.setVisible(false);
				//GUI_Taller.getInstance().setVisible(true);
			}
		});
	
	}
	
	public void setVisible(boolean x){
		this.frame.setVisible(x);
	}
}
