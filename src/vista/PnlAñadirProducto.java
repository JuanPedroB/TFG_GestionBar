package vista;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Iterator;

public class PnlAñadirProducto extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JTextField textField_2;
	private JComboBox comboBox;
	private JPanel panel_4;
	private JLabel label;

	/**
	 * Create the panel.
	 */
	public PnlAñadirProducto() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), Color.GRAY, new Color(128, 128, 128), Color.GRAY));
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(49, 163, 250), new Color(128, 128, 128), new Color(49, 163, 250)));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(49, 163, 250), new Color(128, 128, 128), new Color(49, 163, 250)));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 722, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 718, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("Nombre del producto:");
		
		lblNewLabel.setForeground(new Color(0,0,0));
		lblNewLabel.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setForeground(new Color(0,0,0));
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Precio del producto");
		lblNewLabel_1.setForeground(new Color(0,0,0));
		lblNewLabel_1.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(0,0,0));
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Categor\u00EDa:");
		lblNewLabel_2.setForeground(new Color(0,0,0));
		lblNewLabel_2.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		
		
		comboBox = new JComboBox();
		
		JLabel lblNewLabel_3 = new JLabel("Escribe el nombre y precio del producto:");
		lblNewLabel_3.setForeground(new Color(49, 163, 250));
		lblNewLabel_3.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 14));
		
		JLabel lblNewLabel_3_1 = new JLabel("Selecciona la categor\u00EDa del producto:");
		lblNewLabel_3_1.setForeground(new Color(49, 163, 250));
		lblNewLabel_3_1.setFont(new Font("Lucida Sans Unicode", Font.BOLD, 14));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(49, 163, 250), new Color(128, 128, 128), new Color(49, 163, 250)));
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(49, 163, 250), new Color(128, 128, 128), new Color(49, 163, 250)));
		panel_4.setVisible(false);
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(109))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(4)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(37)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(50)
							.addComponent(lblNewLabel_3_1)
							.addGap(30)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(22)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(5)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_4.setLayout(gl_panel_4);
		
		JLabel lblNewLabel_4 = new JLabel("Introduce la imagen del producto (opcional):");
		lblNewLabel_4.setForeground(new Color(0,0,0));
		lblNewLabel_4.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		btnNewButton = new JButton("Abrir");
		
		JLabel lblNewLabel_5 = new JLabel("M\u00E1x: 64KB - 32x32px");
		lblNewLabel_5.setForeground(new Color(0,0,0));
		lblNewLabel_5.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 12));
		
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(103)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
							.addGap(80)))
					.addGap(19))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(23)
					.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
					.addGap(27))
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addGap(107)
					.addComponent(lblNewLabel_5, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addGap(105))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_5)
					.addGap(10)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblAadirProducto = new JLabel("A\u00F1adir producto");
		lblAadirProducto.setForeground(new Color(49, 163, 250));
		lblAadirProducto.setFont(new Font("Lucida Console", Font.BOLD, 18));
		lblAadirProducto.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(275)
					.addComponent(lblAadirProducto, GroupLayout.PREFERRED_SIZE, 80, Short.MAX_VALUE)
					.addGap(270))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addGap(29)
					.addComponent(lblAadirProducto, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(26))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);

	}
	
	public JButton getBtnFileChooser() {
		return btnNewButton;
	}
	public JTextField getTextFileChooser() {
		return textField_2;
	}
	public JTextField getTextNombreProducto() {
		return textField;
	}
	public JTextField getTextPrecioProducto() {
		return textField_1;
	}
	public JTextField getTextImagenProducto() {
		return textField_2;
	}
	public JComboBox getComboCategorias() {
		return comboBox;
	}
	public JPanel getPnlImagen() {
		return panel_4;
	}
	public JLabel getLblImagen() {
		return label;
	}
	
	public void limpiarPnlAñadirProducto() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		comboBox.setSelectedIndex(0);
		panel_4.setVisible(false);
		label.setIcon(new ImageIcon());
	}
}
