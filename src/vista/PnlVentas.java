package vista;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import rsbuttom.RSButtonMetro;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class PnlVentas extends JPanel {
	private JTable table;
	private JTextField textField;
	private RSButtonMetro btnPagarPedido;
	private RSButtonMetro btnLimpiarFiltro;

	/**
	 * Create the panel.
	 */
	public PnlVentas() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(128, 128, 128), Color.GRAY));
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(49, 163, 250), new Color(128, 128, 128), new Color(49, 163, 250)));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(49, 163, 250), new Color(128, 128, 128), new Color(49, 163, 250)));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(8)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)
							.addGap(25))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1005, Short.MAX_VALUE)
								.addComponent(panel_1, 0, 0, Short.MAX_VALUE))
							.addGap(13)))
					.addGap(12))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		btnLimpiarFiltro = new RSButtonMetro();
		btnLimpiarFiltro.setIcon(new ImageIcon(PnlPedido.class.getResource("/img/limpiarFiltro.png")));
		btnLimpiarFiltro.setHorizontalTextPosition(SwingConstants.LEFT);
		btnLimpiarFiltro.setIconTextGap(10);
		btnLimpiarFiltro.setText("Limpiar filtro");
		configuracionBtn(btnLimpiarFiltro);
		
		btnPagarPedido = new RSButtonMetro();
		btnPagarPedido.setIcon(new ImageIcon(PnlPedido.class.getResource("/img/pagarPedido.png")));
		btnPagarPedido.setHorizontalTextPosition(SwingConstants.LEFT);
		btnPagarPedido.setIconTextGap(10);
		btnPagarPedido.setText("Pagar pedido");
		configuracionBtn(btnPagarPedido);
		
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(280)
					.addComponent(btnLimpiarFiltro, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addGap(48)
					.addComponent(btnPagarPedido, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
					.addGap(344))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLimpiarFiltro, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPagarPedido, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNewLabel = new JLabel("Gestión de ventas");
		lblNewLabel.setForeground(new Color(49, 163, 250));
		lblNewLabel.setFont(new Font("Lucida Console", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Filtrar por fecha (a\u00F1o/mes/d\u00EDa):");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(392)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
					.addGap(39))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);

	}
	
	private void configuracionBtn(RSButtonMetro btn) {
		btn.setColorTextNormal(new Color(49, 163, 250));;
		btn.setFont(new Font("Lucida Console", Font.BOLD, 13));
		btn.setColorNormal(Color.WHITE);
		btn.setColorHover(new Color(49, 163, 250));
		btn.setColorPressed(new Color(49, 163, 250));
	}
	
	public JTable getTableVentas() {
		return table;
	}
	
	public JTextField getTextFiltroVentas() {
		return textField;
	}
	
	public RSButtonMetro getBtnLimpiarFiltro() {
		return btnLimpiarFiltro;
	}
	
	public RSButtonMetro getBtnPagarPedido() {
		return btnPagarPedido;
	}
}
