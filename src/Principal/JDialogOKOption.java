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
    private Color colorRojo = new Color(255, 0, 0);
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JLabel lb_icono;
    private javax.swing.JLabel lb_texto;
    private JPanel panel;

    public JDialogOKOption(JFrame frame, String texto, String Titulo, ImageIcon icono) {
    	super(frame);
    	panel = new JPanel(new GridBagLayout());
    	jButton1 = new javax.swing.JButton();
    	lb_titulo = new javax.swing.JLabel(Titulo);
    	lb_titulo.setFont(new java.awt.Font("Arial", 1, 17));
    	lb_icono = new JLabel(icono);
    	lb_icono.setPreferredSize(new Dimension(50 ,50));
    	lb_texto = new javax.swing.JLabel(texto);
    	lb_texto.setFont(new java.awt.Font("Arial", 1, 12));
    	lb_texto.setHorizontalAlignment(SwingConstants.CENTER);
        jButton2 = new javax.swing.JButton();

        jButton1.setText("Aceptar");

        panel.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Aceptar");
        
        jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 1;
		panel.add(lb_icono, gbc);
		
		gbc.gridx = 1; gbc.gridy = 0;  gbc.gridwidth = 1;
		panel.add(lb_titulo, gbc);
		
		gbc.gridx = 0; gbc.gridy = 1; gbc.gridheight = 2;  gbc.gridwidth = 2;
		panel.add(lb_texto, gbc);
		
		gbc.gridx = 0; gbc.gridy = 3; gbc.gridheight = 1;  gbc.gridwidth = 2;
		panel.add(jButton2, gbc);
        
        panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, colorRojo));
        this.add(panel);
        this.setUndecorated(true);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        //this.setVisible(true);
    }

}
