package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import rsbuttom.RSButtonMetro;
import utiles.ImgTabla;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class PnlProductos extends JPanel {
	private JTable table;
	private RSButtonMetro btnNewButton;
	private JComboBox comboBox;
	private JTextField textField;
	private JMenuItem opcionActualizar;
	private JMenuItem opcionEliminar;

	/**
	 * Create the panel.
	 */
	public PnlProductos() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(128, 128, 128), Color.GRAY));
		add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel cabecera = new JPanel();
		cabecera.setBackground(Color.WHITE);
		cabecera.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(49, 163, 250), new Color(128, 128, 128), new Color(49, 163, 250)));
		
		JPanel piePantalla = new JPanel();
		piePantalla.setBackground(Color.WHITE);
		piePantalla.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(49, 163, 250), new Color(128, 128, 128), new Color(49, 163, 250)));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
						.addComponent(cabecera, GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
						.addComponent(piePantalla, GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(cabecera, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(piePantalla, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		btnNewButton = new RSButtonMetro();
		btnNewButton.setIcon(new ImageIcon(PnlProductos.class.getResource("/img/mas.png")));
		btnNewButton.setText("Añadir producto");
		btnNewButton.setIconTextGap(10);
		btnNewButton.setColorTextNormal(new Color(49, 163, 250));;
		btnNewButton.setFont(new Font("Lucida Console", Font.BOLD, 13));
		btnNewButton.setColorNormal(Color.WHITE);
		btnNewButton.setColorHover(new Color(49, 163, 250));
		btnNewButton.setColorPressed(new Color(49, 163, 250));
		btnNewButton.setHorizontalTextPosition(SwingConstants.LEFT);
		btnNewButton.setColorBorde(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(49, 163, 250), new Color(128, 128, 128), new Color(49, 163, 250)));
		
		GroupLayout gl_piePantalla = new GroupLayout(piePantalla);
		gl_piePantalla.setHorizontalGroup(
			gl_piePantalla.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_piePantalla.createSequentialGroup()
					.addGap(98)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
					.addGap(87))
		);
		gl_piePantalla.setVerticalGroup(
			gl_piePantalla.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_piePantalla.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		piePantalla.setLayout(gl_piePantalla);
		
		JPopupMenu menuContextual = new JPopupMenu();
		opcionActualizar = new JMenuItem("Actualizar producto");
		menuContextual.add(opcionActualizar);
		
		opcionEliminar = new JMenuItem("Eliminar producto");
		menuContextual.add(opcionEliminar);
		
		table = new JTable();
		table.setComponentPopupMenu(menuContextual);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Gesti\u00F3n de productos");
		lblNewLabel.setForeground(new Color(49, 163, 250));
		lblNewLabel.setFont(new Font("Lucida Console", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PnlProductos.class.getResource("/img/lupa.png")));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.addItem("Nombre");
		comboBox.addItem("Categoría");
		GroupLayout gl_cabecera = new GroupLayout(cabecera);
		gl_cabecera.setHorizontalGroup(
			gl_cabecera.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cabecera.createSequentialGroup()
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(322)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
					.addGap(35)
					.addComponent(comboBox, 0, 22, Short.MAX_VALUE)
					.addGap(29))
		);
		gl_cabecera.setVerticalGroup(
			gl_cabecera.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_cabecera.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_cabecera.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_cabecera.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addGap(21))
		);
		cabecera.setLayout(gl_cabecera);
		panel.setLayout(gl_panel);

	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public JTable getTablaProductos() {
		return table;
	}
	
	public RSButtonMetro getBtnAñadirProducto() {
		return btnNewButton;
	}
	public JTextField getTextFiltro() {
		return textField;
	}
	public JComboBox getComboFiltro() {
		return comboBox;
	}
	public JMenuItem getMenuActualizarProducto() {
		return opcionActualizar;
	}
	public JMenuItem getMenuEliminarProducto() {
		return opcionEliminar;
	}
}
