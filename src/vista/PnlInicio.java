package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class PnlInicio extends JPanel {

	/**
	 * Create the panel.
	 */
	public PnlInicio() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
//		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(128, 128, 128), Color.GRAY));
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{775, 0};
		gbl_panel.rowHeights = new int[]{537, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PnlInicio.class.getResource("/img/logo.png")));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

	}
	
}
