package Principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class JDialogOKOption extends JDialog {
    private static final long serialVersionUID = 1L;
    private Color colorNaraja = new Color(230, 136, 1);
    private javax.swing.JButton bt_aceptar;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JLabel lb_icono;
    private javax.swing.JLabel lb_texto;
    private JPanel panel;

    public JDialogOKOption(JFrame frame, String texto, String Titulo, ImageIcon icono) {
    	super(frame);
    	frame.setOpacity(0.50f);
    	panel = new JPanel(new GridBagLayout());
    	
    	JPanel cabezera = new JPanel(new GridBagLayout());
    	cabezera.setBackground(colorNaraja);
    	cabezera.setOpaque(true);
    	lb_titulo = new javax.swing.JLabel(Titulo);
    	lb_titulo.setFont(new java.awt.Font("Arial", 1, 17));
    	lb_icono = new JLabel(icono);
    	lb_icono.setPreferredSize(new Dimension(50 ,50));
    	    	
    	lb_texto = new javax.swing.JLabel(texto);
    	lb_texto.setFont(new java.awt.Font("Arial", 1, 12));
    	lb_texto.setHorizontalAlignment(SwingConstants.CENTER);
    	bt_aceptar = new javax.swing.JButton();

    	panel.setBackground(new java.awt.Color(255, 255, 255));
        bt_aceptar.setText("Aceptar");
        
        bt_aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setOpacity(1f);
				dispose();
			}
		});
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(0,0,0,0);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 1; gbc.anchor = GridBagConstraints.WEST;
        cabezera.add(lb_icono, gbc);
		
        gbc.insets = new Insets(0,5,0,0);
		gbc.gridx = 1; gbc.gridy = 0;  gbc.gridwidth = 1; gbc.fill = GridBagConstraints.BOTH;
		cabezera.add(lb_titulo, gbc);
				     
		gbc.insets = new Insets(-18,0,0,0);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 3; 
        panel.add(cabezera, gbc);
		
        gbc.insets = new Insets(10,10,10,10); 
		gbc.gridx = 0; gbc.gridy = 1; gbc.gridheight = 2;  gbc.gridwidth = 3;
		panel.add(lb_texto, gbc);
		
		 gbc.insets = new Insets(0,10,10,10);
		gbc.gridx = 0; gbc.gridy = 3; gbc.gridheight = 1;  gbc.gridwidth = 3; gbc.fill = GridBagConstraints.NONE; gbc.anchor = GridBagConstraints.EAST;
		panel.add(bt_aceptar, gbc);
        
        panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, colorNaraja));
        this.add(panel);
        this.setUndecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        //this.setVisible(true);
    }

}
