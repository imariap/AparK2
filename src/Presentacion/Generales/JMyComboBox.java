package Presentacion.Generales;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class JMyComboBox extends JComboBox<String> {
	  
	private Color colorNaraja = new Color(230, 136, 1);
	private Color colorGris = new Color(64,64,64);

	public JMyComboBox(String msg) {
		//this.setBorder(BorderFactory.createMatteBorder(2,2,2,2, colorNaraja));
		this.setBackground(Color.white);
		this.setForeground(colorGris);
	}
}
