package Presentacion.Generales;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class JBotonMenu extends JButton {
	  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color colorNaraja = new Color(230, 136, 1);
	private Color colorGris = new Color(64,64,64);

	public JBotonMenu(String msg) {
		super(msg);
		this.setBorder(BorderFactory.createMatteBorder(2,2,2,2, colorNaraja));
		this.setFocusPainted(false);
		//this.setSize(new Dimension(5, 5));
		this.setBackground(Color.white);
		this.setForeground(colorGris);
		this.setPreferredSize(new Dimension(100, 40));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}
