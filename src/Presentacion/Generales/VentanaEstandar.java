package Presentacion.Generales;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

import Almacen.ALMACEN;
import Presentacion.GUILavadero.*;
import Presentacion.GUITaller.GUI_Taller;
   
public class VentanaEstandar extends JFrame{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color colorNaraja = new Color(230, 136, 1);
	   
      public VentanaEstandar(JPanel miPanel, String icono) {
    	  
         super ("AparK2");
         
         // GridBagLayout al contenedor
         //this.setDefaultCloseOperation(salir());
         this.setUndecorated(true);
         this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
         this.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, colorNaraja));
         this.getContentPane().setLayout(new GridBagLayout());
         GridBagConstraints constraints = new GridBagConstraints();
         
         
         // Panel de opciones (iquierdo)
         JPanel panelOpciones = new JPanel(new BorderLayout()); 
         panelOpciones.setBackground(colorNaraja);
         panelOpciones.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, colorNaraja));

         // Panel central (derecho)
         JPanel panelCentral = new JPanel(new BorderLayout());
         panelCentral.setBackground(Color.WHITE);
         panelCentral.setBorder(BorderFactory.createMatteBorder(2,2,2,2, colorNaraja));
         
         JPanel f = new JPanel(new BorderLayout());
         f.setBackground(Color.WHITE);
         f.setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.WHITE));
         f.add(panelCentral);
         
         // Label que contiene el logo en el panel de opciones (izquierdo)
         JLabel labelLogoOpciones = new JLabel(new ImageIcon("images/logoOpciones.png"));
         
         // Añadimos al panel de opciones (iquierdo) el logo y el panel con los botones de opciones
         panelOpciones.add(labelLogoOpciones, BorderLayout.NORTH);
         panelOpciones.add(panelOpcionesBotones(), BorderLayout.CENTER);
         
         // Añadimos al panel central el logo principal y el panel especifico para cada ventana (miPanel)
         panelCentral.add(panelLogoPrincipal(icono), BorderLayout.NORTH);
         panelCentral.add(miPanel, BorderLayout.CENTER); //********************************************************** PANEL PERSONALIZADO
         
         // Añadimos el panel de opciones al contenedor
         constraints.gridx = 0; 
         constraints.gridy = 0; 
         constraints.gridwidth = 1;
         constraints.gridheight = 0; 
         constraints.weightx = 0.0; 
         constraints.weighty = 1.0;
         constraints.fill = GridBagConstraints.BOTH;
         this.getContentPane().add (panelOpciones, constraints); 
          
         // Añadimos el panel central al contenedor 
         constraints.gridx = 1; 
         constraints.gridy = 0; 
         constraints.gridwidth = 2; 
         constraints.gridheight = 1; 
         constraints.weightx = 2.0;
         constraints.weighty = 1.0;
         constraints.fill = GridBagConstraints.BOTH;
         this.getContentPane().add (f, constraints); 
         
         // Tamaño, localizacion y visibilidad
         this.setSize(1000, 550);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
      }
      
	JPanel panelLogoPrincipal(String icono) {

		JPanel jp = new JPanel(new BorderLayout());
		jp.setBackground(Color.WHITE);
		JLabel lb = new JLabel(new ImageIcon("images/logoPrincipal.png"));	
		JLabel lbI = new JLabel(new ImageIcon(icono));	
		jp.add(lbI, BorderLayout.WEST);
		jp.add(lb, BorderLayout.EAST);

		return jp;
	}
		
	JPanel panelOpcionesBotones() {

		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(4, 1));		
		jp.setBackground(colorNaraja);
		
		ImageIcon ii_inicio = new ImageIcon("images/inicio.png");
		JButton b1 = botonNaranja(ii_inicio);
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				MenuPrincipal.getInstance().setVisible(true);
			}
		});
		jp.add(b1);
		
		ImageIcon ii_taller = new ImageIcon("images/taller.png");
		JButton b2 = botonNaranja(ii_taller);
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				GUI_Taller.getInstance().setVisible(true);
			}
		});
		jp.add(b2);
		
		ImageIcon ii_lavadero = new ImageIcon("images/lavadero.png");
		JButton b3 = botonNaranja(ii_lavadero);
		b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				GUI_Lavadero.getInstance().setVisible(true);
				
			}
		});
		jp.add(b3);
		
		ImageIcon ii_salir = new ImageIcon("images/salir.png");
		JButton b4 = botonNaranja(ii_salir);
		b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				salir();
			}
		});
		jp.add(b4);
		
		return jp;

	}
		
	// Boton personalizado
	JButton botonNaranja(ImageIcon img){
		
		JButton bt = new JButton(img);
		bt.setBackground(colorNaraja);
		bt.setForeground(Color.WHITE);
		bt.setBorder(new LineBorder(Color.WHITE, 1));
		
		return(bt);
	}	
	
	public int salir(){
		ALMACEN.getInstance().saveOnClose();	
		System.exit(0);
		
		return 0;
	}
}
