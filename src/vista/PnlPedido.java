package vista;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;

import rsbuttom.RSButtonMetro;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class PnlPedido extends JPanel {
	private JTable table_1;
	private JTextField textField;
	private JTable table;
	private RSButtonMetro btnAñadirAlPedido;
	private RSButtonMetro btnAñadirSeleccionado;
	private RSButtonMetro btnQuitarSeleccionado;
	private RSButtonMetro btnCrearPedido;
	private RSButtonMetro btnLimpiarPedido;
	private JLabel lblNewLabel_3;

	/**
	 * Create the panel.
	 */
	public PnlPedido() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(128, 128, 128), Color.GRAY));
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(49, 163, 250), new Color(128, 128, 128), new Color(49, 163, 250)));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(49, 163, 250), new Color(128, 128, 128), new Color(49, 163, 250)));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
						.addComponent(panel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(225, 92, 49), new Color(128, 128, 128), new Color(225, 92, 49)));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblNewLabel_2 = new JLabel("Pedido");
		lblNewLabel_2.setForeground(new Color(49, 163, 250));
		lblNewLabel_2.setFont(new Font("Lucida Console", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnAñadirSeleccionado = new RSButtonMetro();
		btnAñadirSeleccionado.setHorizontalTextPosition(SwingConstants.LEFT);
		btnAñadirSeleccionado.setIconTextGap(10);
		btnAñadirSeleccionado.setIcon(new ImageIcon(PnlPedido.class.getResource("/img/anadirSeleccion.png")));
		btnAñadirSeleccionado.setText("A\u00F1adir");
		configuracionBtn(btnAñadirSeleccionado);
		
		btnQuitarSeleccionado = new RSButtonMetro();
		btnQuitarSeleccionado.setHorizontalTextPosition(SwingConstants.LEFT);
		btnQuitarSeleccionado.setIconTextGap(10);
		btnQuitarSeleccionado.setIcon(new ImageIcon(PnlPedido.class.getResource("/img/quitarSeleccion.png")));
		btnQuitarSeleccionado.setText("Quitar");
		configuracionBtn(btnQuitarSeleccionado);
		
		lblNewLabel_3 = new JLabel("0€");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_4 = new JLabel("Total:");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(177)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
					.addGap(177))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(28)
							.addComponent(btnAñadirSeleccionado, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
							.addGap(30)
							.addComponent(btnQuitarSeleccionado, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnQuitarSeleccionado, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
							.addComponent(btnAñadirSeleccionado, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
						.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_3)
							.addComponent(lblNewLabel_4)))
					.addGap(21))
		);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(225, 92, 49), new Color(128, 128, 128), new Color(225, 92, 49)));
		
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1 = new JLabel("Productos");
		lblNewLabel_1.setForeground(new Color(49, 163, 250));
		lblNewLabel_1.setFont(new Font("Lucida Console", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnAñadirAlPedido = new RSButtonMetro();
		btnAñadirAlPedido.setHorizontalTextPosition(SwingConstants.LEFT);
		btnAñadirAlPedido.setText("Añadir al pedido");
		btnAñadirAlPedido.setIconTextGap(10);
		btnAñadirAlPedido.setIcon(new ImageIcon(PnlPedido.class.getResource("/img/anadirAlPedido.png")));
		configuracionBtn(btnAñadirAlPedido);
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(135)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
					.addGap(134))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addGap(148)
					.addComponent(btnAñadirAlPedido, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
					.addGap(144))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAñadirAlPedido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel_2.setLayout(gl_panel_2);
		panel_5.setLayout(gl_panel_5);
		
		btnCrearPedido = new RSButtonMetro();
		btnCrearPedido.setIconTextGap(10);
		btnCrearPedido.setHorizontalTextPosition(SwingConstants.LEFT);
		btnCrearPedido.setIcon(new ImageIcon(PnlPedido.class.getResource("/img/anadirPedido.png")));
		btnCrearPedido.setText("Crear pedido");
		configuracionBtn(btnCrearPedido);
		
		btnLimpiarPedido = new RSButtonMetro();
		btnLimpiarPedido.setIcon(new ImageIcon(PnlPedido.class.getResource("/img/eliminar.png")));
		btnLimpiarPedido.setHorizontalTextPosition(SwingConstants.LEFT);
		btnLimpiarPedido.setIconTextGap(10);
		btnLimpiarPedido.setText("Borrar pedido");
		configuracionBtn(btnLimpiarPedido);
		
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addGap(293)
					.addComponent(btnCrearPedido, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
					.addGap(45)
					.addComponent(btnLimpiarPedido, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
					.addGap(317))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLimpiarPedido, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCrearPedido, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		JLabel lblNewLabel = new JLabel("Crear pedido");
		lblNewLabel.setForeground(new Color(49, 163, 250));
		lblNewLabel.setFont(new Font("Lucida Console", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addGap(395)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
					.addGap(393))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);

	}
	
	private void configuracionBtn(RSButtonMetro btn) {
		btn.setColorTextNormal(new Color(49, 163, 250));;
		btn.setFont(new Font("Lucida Console", Font.BOLD, 13));
		btn.setColorNormal(Color.WHITE);
		btn.setColorHover(new Color(49, 163, 250));
		btn.setColorPressed(new Color(49, 163, 250));
	}

	public JTable getTablaProductos() {
		return table;
	}
	public JTable getTablaPedido() {
		return table_1;
	}
	
	public JTextField getTextFiltroPnlPedido() {
		return textField;
	}
	
	public RSButtonMetro getBtnAñadirAlPedido() {
		return btnAñadirAlPedido;
	}
	public RSButtonMetro getBtnAñadirSeleccionado() {
		return btnAñadirSeleccionado;
	}
	public RSButtonMetro getBtnQuitarSeleccionado() {
		return btnQuitarSeleccionado;
	}
	public RSButtonMetro getBtnLimpiarPedido() {
		return btnLimpiarPedido;
	}
	public RSButtonMetro getBtnCrearPedido() {
		return btnCrearPedido;
	}
	
	public JLabel getLblPrecioTotal() {
		return lblNewLabel_3;
	}
}
