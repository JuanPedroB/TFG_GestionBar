package utiles;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagenPanel extends JPanel {

	private ImageIcon imagen;
	private String nombre;
	/**
	 * Create the panel.
	 */
	public ImagenPanel(String nombre) {
		this.nombre = nombre;
	}

	public void paint(Graphics g) {
		Dimension tamaño = getSize();
		imagen = new ImageIcon(getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamaño.width, tamaño.height, null);
		setOpaque(false);
		super.paint(g);
	}
}
