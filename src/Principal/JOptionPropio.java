package Principal;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JOptionPropio {
	public JOptionPropio (JFrame frame, String texto, String title) {
        JDialog p = new JDialog();
        p.setTitle(title);
       p.show();   
    }

    private JPanel getPanel(String texto) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(texto);
        panel.setBackground(Color.WHITE);
        panel.add(label);

        return panel;
    }

   


}
