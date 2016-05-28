package Presentacion.Generales;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.xml.transform.OutputKeys;

import Negocio.Taller.TransferPieza;

public class JDialogPiezas extends JDialog {
    private static final long serialVersionUID = 1L;
    private Color colorNaraja = new Color(230, 136, 1);
    private JBotonMenu bt_aceptar;
    private JBotonMenu bt_cancelar;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JLabel lb_icono;
    private javax.swing.JLabel lb_texto;
    private JPanel panel;
	private JLabel lb_nombrepieza;
	private JLabel lb_preciopieza;
	private JTextField txt_nombrepieza;
	private JTextField txt_preciopieza;
	private String texto;
	private String Titulo;
	private ImageIcon icono;
	private JFrame frame;
	private ArrayList<String> campos;

    public JDialogPiezas(JFrame frame, String texto, String Titulo, ImageIcon icono) {
    	super(frame);
    	//frame.setOpacity(0.50f)
    	this.campos = new ArrayList<String>();
    	this.frame = frame;
    	this.texto = texto;
    	this.Titulo = Titulo;
    	this.icono = icono;
    	
    	DropShadowBorder b = new
      			 DropShadowBorder(Color.BLACK, 0,4, 0.4f, 10, true, true, true,
      			 true); getRootPane().setBorder(b); // borde exterior
       	
       	panel = new JPanel(new GridBagLayout());
       	
       	lb_nombrepieza = new JLabel("Nombre:");
           lb_preciopieza = new JLabel("Precio:");
           txt_nombrepieza = new JTextField(10);
           txt_preciopieza = new JTextField(5);
           panel.add(lb_nombrepieza);    
           panel.add(txt_nombrepieza);
           panel.add(lb_preciopieza);    
           panel.add(txt_preciopieza);	
       	
       	JPanel cabecera = new JPanel(new GridBagLayout());
       	cabecera.setBackground(colorNaraja);
       	cabecera.setOpaque(true);
       	lb_titulo = new javax.swing.JLabel(Titulo);
       	lb_titulo.setFont(new java.awt.Font("Arial", 1, 17));
       	lb_titulo.setForeground(Color.WHITE);
       	lb_icono = new JLabel(icono);
       	lb_icono.setPreferredSize(new Dimension(50 ,50));
       	    	
       	lb_texto = new javax.swing.JLabel(texto);
       	lb_texto.setFont(new java.awt.Font("Arial", 1, 12));
       	lb_texto.setHorizontalAlignment(SwingConstants.CENTER);
       	bt_aceptar = new JBotonMenu("Añadir");
       	bt_cancelar = new JBotonMenu("Cancelar");

       	panel.setBackground(new java.awt.Color(255, 255, 255));
          // bt_aceptar.setText();
           
           bt_aceptar.addActionListener(new ActionListener() {
   			
   			@Override
   			public void actionPerformed(ActionEvent e) {
   				// TODO Auto-generated method stub
   				campos.add(txt_nombrepieza.getText());
   				campos.add(txt_preciopieza.getText());
   				setVisible(false);   				
   				dispose();
   			}
   		});
           
           bt_cancelar.addActionListener(new ActionListener() {
      			
      			@Override
      			public void actionPerformed(ActionEvent e) {
      				// TODO Auto-generated method stub
      				campos = new ArrayList<String>();
      				setVisible(false);   				
      				dispose();
      			}
      		});
           
           GridBagConstraints gbc = new GridBagConstraints();
           
           gbc.insets = new Insets(0,0,0,0);
           gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 1; gbc.anchor = GridBagConstraints.WEST;
           cabecera.add(lb_icono, gbc);
   		
           gbc.insets = new Insets(0,5,0,0);
   		gbc.gridx = 1; gbc.gridy = 0;  gbc.gridwidth = 1; gbc.fill = GridBagConstraints.BOTH;
   		cabecera.add(lb_titulo, gbc);
   				     
   		gbc.insets = new Insets(-18,0,0,0);
           gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 4; 
           panel.add(cabecera, gbc);
   		
           gbc.insets = new Insets(10,10,10,10); 
   		gbc.gridx = 0; gbc.gridy = 1; gbc.gridheight = 1;  gbc.gridwidth = 1;
   		panel.add(lb_nombrepieza, gbc);
   		
   		gbc.gridx = 1; gbc.gridy = 1; gbc.gridheight = 1;  gbc.gridwidth = 1;
   		panel.add(txt_nombrepieza, gbc);
   		
   		gbc.gridx = 2; gbc.gridy = 1; gbc.gridheight = 1;  gbc.gridwidth = 1;
   		panel.add(lb_preciopieza, gbc);
   		
   		gbc.gridx = 3; gbc.gridy = 1; gbc.gridheight = 1;  gbc.gridwidth = 1;
   		panel.add(txt_preciopieza, gbc);		
   		
   		 gbc.insets = new Insets(0,10,10,10);
   		gbc.gridx = 0; gbc.gridy = 3; gbc.gridheight = 1;  gbc.gridwidth = 2; gbc.fill = GridBagConstraints.NONE; gbc.anchor = GridBagConstraints.CENTER;
   		panel.add(bt_aceptar, gbc);
   		
   		gbc.gridx = 2; gbc.gridy = 3; gbc.gridheight = 1;  gbc.gridwidth = 2; gbc.fill = GridBagConstraints.NONE; gbc.anchor = GridBagConstraints.CENTER;
   		panel.add(bt_cancelar, gbc);
           
           panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, colorNaraja));
           this.add(panel);
           this.setUndecorated(true);
           this.pack();
           Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
           int x = (dim.width+300)/2-this.getSize().width/2;
           int y = dim.height/2-this.getSize().height/2;
           this.setLocation(x, y);
           this.setAlwaysOnTop(true);
           this.setModalityType(ModalityType.APPLICATION_MODAL);
    }
    
    public ArrayList<String> showDialog(){
    	  setVisible(true); // when this is called the dialog will show up
    	  return campos;
    }

}
