package Presentacion.Generales;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;
import javax.swing.border.LineBorder;

import Almacen.ALMACEN;
import Main.Main;
import Presentacion.GUILavadero.*;
import Presentacion.GUITaller.GUI_Taller;
   
public class VentanaEstandar extends JFrame{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color colorNaraja = new Color(230, 136, 1);
	   
      public VentanaEstandar(JPanel miPanel, URL iconoIni) {
    	  
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
         URL logoOpciones = Main.class.getResource("/Presentacion/Images/logoOpciones.png");
         JLabel labelLogoOpciones = new JLabel(new ImageIcon(logoOpciones));
         
         // A�adimos al panel de opciones (iquierdo) el logo y el panel con los botones de opciones
         panelOpciones.add(labelLogoOpciones, BorderLayout.NORTH);
         panelOpciones.add(panelOpcionesBotones(), BorderLayout.CENTER);
         
         // A�adimos al panel central el logo principal y el panel especifico para cada ventana (miPanel)
         panelCentral.add(panelLogoPrincipal(iconoIni), BorderLayout.NORTH);
         panelCentral.add(miPanel, BorderLayout.CENTER); //********************************************************** PANEL PERSONALIZADO
         
         // A�adimos el panel de opciones al contenedor
         constraints.gridx = 0; 
         constraints.gridy = 0; 
         constraints.gridwidth = 1;
         constraints.gridheight = 0; 
         constraints.weightx = 0.0; 
         constraints.weighty = 1.0;
         constraints.fill = GridBagConstraints.BOTH;
         this.getContentPane().add (panelOpciones, constraints); 
          
         // A�adimos el panel central al contenedor 
         constraints.gridx = 1; 
         constraints.gridy = 0; 
         constraints.gridwidth = 2; 
         constraints.gridheight = 1; 
         constraints.weightx = 2.0;
         constraints.weighty = 1.0;
         constraints.fill = GridBagConstraints.BOTH;
         this.getContentPane().add (f, constraints); 
         
         // Tama�o, localizacion y visibilidad
         this.setSize(1000, 550);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
      }
      
	JPanel panelLogoPrincipal(URL iconoIni) {

		JPanel jp = new JPanel(new BorderLayout());
		jp.setBackground(Color.WHITE);
		URL logoPrincipal = Main.class.getResource("/Presentacion/Images/logoPrincipal.png");
		JLabel lb = new JLabel(new ImageIcon(logoPrincipal));	
		JLabel lbI = new JLabel(new ImageIcon(iconoIni));	
		jp.add(lbI, BorderLayout.WEST);
		jp.add(lb, BorderLayout.EAST);

		return jp;
	}
		
	JPanel panelOpcionesBotones() {

		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(4, 1));		
		jp.setBackground(colorNaraja);
		
		URL inicio = Main.class.getResource("/Presentacion/Images/inicio.png");
		ImageIcon ii_inicio = new ImageIcon(inicio);
		JButton b1 = botonNaranja(ii_inicio);
		b1.setBorder(BorderFactory.createMatteBorder(1,1,0,1, Color.WHITE));
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
		
		URL taller = Main.class.getResource("/Presentacion/Images/taller.png");
		ImageIcon ii_taller = new ImageIcon(taller);
		JButton b2 = botonNaranja(ii_taller);
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.setBorder(BorderFactory.createMatteBorder(1,1,0,1, Color.WHITE));
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				GUI_Taller.getInstance().setVisible(true);
			}
		});
		jp.add(b2);
		
		URL lavadero = Main.class.getResource("/Presentacion/Images/lavadero.png");
		ImageIcon ii_lavadero = new ImageIcon(lavadero);
		JButton b3 = botonNaranja(ii_lavadero);
		b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b3.setBorder(BorderFactory.createMatteBorder(1,1,0,1, Color.WHITE));
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				GUI_Lavadero.getInstance().setVisible(true);
				
			}
		});
		jp.add(b3);
		
		URL salir = Main.class.getResource("/Presentacion/Images/salir.png");
		ImageIcon ii_salir = new ImageIcon(salir);
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
