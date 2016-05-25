package Principal;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class JBotonMenu extends JButton {
	  
	private Color colorNaraja = new Color(230, 136, 1);
	private Color colorGris = new Color(64,64,64);

	public JBotonMenu(String msg) {
		super(msg);
		this.setBorder(BorderFactory.createMatteBorder(2,2,2,2, colorNaraja));
		this.setFocusPainted(false);
		this.setBackground(Color.white);
		this.setForeground(colorGris);
	}
}