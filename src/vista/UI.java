package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import rsbuttom.RSButtonMetro;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Cursor;
import javax.swing.BoxLayout;

public class UI extends JFrame {

	private JPanel contentPane;
	private JPanel panelMenu;
	private JButton btnMenuSliding;
	private RSButtonMetro btnInicio;
	private RSButtonMetro btnProductos;
	private RSButtonMetro btnReservas;
	private RSButtonMetro btnPedidos;
	private RSButtonMetro btnVentas;
	private JPanel panelInfo;
	
	private PnlInicio pnlInicio;
	private PnlProductos pnlProductos;
	private PnlReservas pnlReservas;
	private PnlAñadirProducto pnlAñadirProducto;
	private PnlEditarProducto pnlEditarProducto;
	private PnlPedido pnlPedido;
	private PnlVentas pnlVentas;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1231, 694);
		setResizable(true);
		Image icono = new ImageIcon(UI.class.getResource("/img/cafe.png")).getImage();
		setIconImage(icono);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240,240,240));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{200, 709, 0};
		gbl_contentPane.rowHeights = new int[]{52, 444, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panelBarra = new JPanel();
		panelBarra.setBackground(new Color(53,53,53));
		GridBagConstraints gbc_panelBarra = new GridBagConstraints();
		gbc_panelBarra.fill = GridBagConstraints.BOTH;
		gbc_panelBarra.insets = new Insets(0, 0, 5, 0);
		gbc_panelBarra.gridwidth = 2;
		gbc_panelBarra.gridx = 0;
		gbc_panelBarra.gridy = 0;
		gbc_panelBarra.insets = new Insets(0,0,0,0);
		contentPane.add(panelBarra, gbc_panelBarra);
		panelBarra.setLayout(null);
		
		btnMenuSliding = new JButton("");
		btnMenuSliding.setIcon(new ImageIcon(UI.class.getResource("/img/menu.png")));
		btnMenuSliding.setContentAreaFilled(false);
		btnMenuSliding.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMenuSliding.setBorder(null);
		btnMenuSliding.setBounds(20, 11, 40, 31);
		panelBarra.add(btnMenuSliding);
		
		panelMenu = new JPanel();
		panelMenu.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelMenu = new GridBagConstraints();
		gbc_panelMenu.fill = GridBagConstraints.BOTH;
		gbc_panelMenu.insets = new Insets(0, 0, 0, 5);
		gbc_panelMenu.gridx = 0;
		gbc_panelMenu.gridy = 1;
		gbc_panelMenu.insets = new Insets(0,0,0,0);
		contentPane.add(panelMenu, gbc_panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 200, 49);
		panel_2.setBackground(Color.WHITE);
		panelMenu.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAVEGACI\u00D3N");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 23, 136, 26);
		panel_2.add(lblNewLabel);
		
		btnInicio = new RSButtonMetro();
		btnInicio.setIcon(new ImageIcon(UI.class.getResource("/img/hogar.png")));
		btnInicio.setIconTextGap(10);
		btnInicio.setColorHover(new Color(49, 163,250));
		btnInicio.setColorTextNormal(Color.DARK_GRAY);
		btnInicio.setColorNormal(new Color(49, 163,250));
		btnInicio.setText("INICIO");
		btnInicio.setBounds(0, 60, 200, 50);
		panelMenu.add(btnInicio);
		
		btnProductos = new RSButtonMetro();
		btnProductos.setIcon(new ImageIcon(UI.class.getResource("/img/caja.png")));
		btnProductos.setText("PRODUCTOS");
		btnProductos.setIconTextGap(10);
		btnProductos.setColorTextNormal(Color.DARK_GRAY);
		btnProductos.setColorNormal(Color.WHITE);
		btnProductos.setColorHover(new Color(49, 163, 250));
		btnProductos.setBounds(0, 110, 200, 50);
		panelMenu.add(btnProductos);
		
		btnReservas = new RSButtonMetro();
		btnReservas.setIcon(new ImageIcon(UI.class.getResource("/img/reservado.png")));
		btnReservas.setText("RESERVAS");
		btnReservas.setIconTextGap(10);
		btnReservas.setColorTextNormal(Color.DARK_GRAY);
		btnReservas.setColorNormal(Color.WHITE);
		btnReservas.setColorHover(new Color(49, 163, 250));
		btnReservas.setBounds(0, 210, 200, 50);
		panelMenu.add(btnReservas);
		
		btnPedidos = new RSButtonMetro();
		btnPedidos.setIcon(new ImageIcon(UI.class.getResource("/img/task.png")));
		btnPedidos.setText("PEDIDOS");
		btnPedidos.setIconTextGap(10);
		btnPedidos.setColorTextNormal(Color.DARK_GRAY);
		btnPedidos.setColorNormal(Color.WHITE);
		btnPedidos.setColorHover(new Color(49, 163, 250));
		btnPedidos.setBounds(0, 160, 200, 50);
		panelMenu.add(btnPedidos);
		
		btnVentas = new RSButtonMetro();
		btnVentas.setIcon(new ImageIcon(UI.class.getResource("/img/grafico-de-barras.png")));
		btnVentas.setText("VENTAS");
		btnVentas.setIconTextGap(10);
		btnVentas.setColorTextNormal(Color.DARK_GRAY);
		btnVentas.setColorNormal(Color.WHITE);
		btnVentas.setColorHover(new Color(49, 163, 250));
		btnVentas.setBounds(0, 260, 200, 50);
		panelMenu.add(btnVentas);
		
		inicializarPaneles();
		
		panelInfo = new JPanel();
		cambiaPanel(pnlInicio);
		panelInfo.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panelInfo = new GridBagConstraints();
		gbc_panelInfo.fill = GridBagConstraints.BOTH;
		gbc_panelInfo.gridx = 1;
		gbc_panelInfo.gridy = 1;
		gbc_panelInfo.insets = new Insets(0,0,0,0);
		contentPane.add(panelInfo, gbc_panelInfo);
		panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.X_AXIS));
		
		this.setLocationRelativeTo(this);
	}
	
	public void cambiaPanel(JPanel pnlCambio) {
		this.panelInfo.removeAll();
		this.panelInfo.revalidate();
		this.panelInfo.repaint();
		
		this.panelInfo.add(pnlCambio);
		this.panelInfo.revalidate();
		this.panelInfo.repaint();
	}
	
	public void inicializarPaneles() {
		pnlInicio = new PnlInicio();
		pnlProductos = new PnlProductos();
		pnlReservas = new PnlReservas();
		pnlAñadirProducto = new PnlAñadirProducto();
		pnlEditarProducto = new PnlEditarProducto();
		pnlPedido = new PnlPedido();
		pnlVentas = new PnlVentas();
	}
	
	public JPanel getPanelMenu() {
		return panelMenu;
	}
	
	public JButton getBtnMenu() {
		return btnMenuSliding;
	}
	
	public RSButtonMetro getBtnInicio() {
		return btnInicio;
	}
	public RSButtonMetro getBtnProductos() {
		return btnProductos;
	}
	public RSButtonMetro getBtnPedidos() {
		return btnPedidos;
	}
	public RSButtonMetro getBtnReservas() {
		return btnReservas;
	}
	public RSButtonMetro getBtnVentas() {
		return btnVentas;
	}
	public JPanel getPnlInicio() {
		return pnlInicio;
	}
	public JPanel getPnlProductos() {
		return pnlProductos;
	}
	public JPanel getPnlReservas() {
		return pnlReservas;
	}
	public JPanel getPnlAñadirProducto() {
		return pnlAñadirProducto;
	}
	public JPanel getPnlEditarProducto() {
		return pnlEditarProducto;
	}
	
	public JPanel getPnlPedido() {
		return pnlPedido;
	}
	
	public JPanel getPnlVentas() {
		return pnlVentas;
	}
	
	public JTable getTablaProductos() {
		return pnlProductos.getTablaProductos();
	}
	public JMenuItem getMenuActualizarProducto() {
		return pnlProductos.getMenuActualizarProducto();
	}
	public JMenuItem getMenuEliminarProducto() {
		return pnlProductos.getMenuEliminarProducto();
	}
	public JButton getBtnAñadirProducto() {
		return pnlProductos.getBtnAñadirProducto();
	}
	
	public JButton getBtnAbrirFileChooser() {
		return pnlAñadirProducto.getBtnFileChooser();
	}
	
	public JTextField getTextFileChooser() {
		return pnlAñadirProducto.getTextFileChooser();
	}
	public void limpiarPnlAñadirProducto() {
		pnlAñadirProducto.limpiarPnlAñadirProducto();
	}
	public JTextField getTextNombreProducto() {
		return pnlAñadirProducto.getTextNombreProducto();
	}
	public JTextField getTextPrecioProducto() {
		return pnlAñadirProducto.getTextPrecioProducto();
	}
	public JTextField getTextImagenProducto() {
		return pnlAñadirProducto.getTextImagenProducto();
	}
	public JPanel getPnlImagenAñadirProducto() {
		return pnlAñadirProducto.getPnlImagen();
	}
	public JLabel getLblImagenPnlAñadirProducto() {
		return pnlAñadirProducto.getLblImagen();
	}
	
	public JComboBox getComboPnlAñadirProducto() {
		return pnlAñadirProducto.getComboCategorias();
	}
	
	
	public JButton getBtnAbrirFileChooserEditar() {
		return pnlEditarProducto.getBtnFileChooser();
	}
	
	public JTextField getTextFileChooserEditar() {
		return pnlEditarProducto.getTextFileChooser();
	}
	public void limpiarPnlEditarProducto() {
		pnlEditarProducto.limpiarPnlEditarProducto();
	}
	public JTextField getTextNombreProductoEditar() {
		return pnlEditarProducto.getTextNombreProducto();
	}
	public JTextField getTextPrecioProductoEditar() {
		return pnlEditarProducto.getTextPrecioProducto();
	}
	public JTextField getTextImagenProductoEditar() {
		return pnlEditarProducto.getTextImagenProducto();
	}
	public JPanel getPnlImagenEditarProducto() {
		return pnlEditarProducto.getPnlImagen();
	}
	public JLabel getLblImagenPnlEditarProducto() {
		return pnlEditarProducto.getLblImagen();
	}
	
	public JComboBox getComboPnlEditarProducto() {
		return pnlEditarProducto.getComboCategorias();
	}
	
	public JTextField getTextPnlProductoFiltro() {
		return pnlProductos.getTextFiltro();
	}
	public JComboBox getComboPnlProductoFiltro() {
		return pnlProductos.getComboFiltro();
	}
	public ArrayList<RSButtonMetro> getBotoneraMesas(){
		return pnlReservas.getBotonera();
	}
	public void activarRdbtn(Boolean editable) {
		pnlReservas.rdbtnEditables(editable);
	}
	
	public void activarConfigReserva(Boolean editable) {
		pnlReservas.configReserva(editable);
	}
	
	public void seleccionarRdbtnPnlReservas(String nombre) {
		pnlReservas.seleccionarRadioBtn(nombre);
	}
	
	public ArrayList<JRadioButton> getRdBtns() {
		return pnlReservas.getRdBtns();
	}
	public JButton getBtnLimpiarPnlReserva() {
		return pnlReservas.getBtnLimpiar();
	}
	public JButton getBtnGuardarPnlReserva() {
		return pnlReservas.getBtnGuardar();
	}
	public void limpiarConfigPnlReserva() {
		pnlReservas.limpiarConfigReserva();
	}
	public void seleccionarIcono(String estado, int posicion) {
		pnlReservas.seleccionarIcono(estado, posicion);
	}
	
	public String getRdbtnSeleccionadoPnlReserva() {
		return pnlReservas.getRdbtnSeleccionado();
	}
	public JTextField getTextClientePnlReserva() {
		return pnlReservas.getTextCliente();
	}
	public Date getDateChooserPnlReserva() {
		return pnlReservas.getDateChooser();
	}
	public String getComboHoraPnlReserva() {
		return pnlReservas.getComboHora();
	}
	
	public JPanel getPnlReservaAceptado() {
		return pnlReservas.getPnlReservaAceptado();
	}
	
	public JLabel getLblFechaReserva() {
		return pnlReservas.getLblFechaReserva();
	}
	public JLabel getLblClienteReserva() {
		return pnlReservas.getLblClienteReserva();
	}
	public JTable getTablaProductosPnlPedido() {
		return pnlPedido.getTablaProductos();
	}
	public JTable getTablaPedidoPnlPedido() {
		return pnlPedido.getTablaPedido();
	}
	
	public JTextField getTextFiltroPnlPedido() {
		return pnlPedido.getTextFiltroPnlPedido();
	}
	
	public RSButtonMetro getBtnAñadirAlPedido() {
		return pnlPedido.getBtnAñadirAlPedido();
	}
	public RSButtonMetro getBtnAñadirSeleccionado() {
		return pnlPedido.getBtnAñadirSeleccionado();
	}
	public RSButtonMetro getBtnQuitarSeleccionado() {
		return pnlPedido.getBtnQuitarSeleccionado();
	}
	public RSButtonMetro getBtnLimpiarPedido() {
		return pnlPedido.getBtnLimpiarPedido();
	}
	public RSButtonMetro getBtnCrearPedido() {
		return pnlPedido.getBtnCrearPedido();
	}
	public JLabel getLblPrecioTotatlPedido() {
		return pnlPedido.getLblPrecioTotal();
	}
	
	public JTable getTablaPnlVentas() {
		return pnlVentas.getTableVentas();
	}
	public JTextField getTextFiltroPnlVentas() {
		return pnlVentas.getTextFiltroVentas();
	}
	
	public RSButtonMetro getBtnLimpiarPnlVentas() {
		return pnlVentas.getBtnLimpiarFiltro();
	}
	
	public RSButtonMetro getBtnPagarPnlVentas() {
		return pnlVentas.getBtnPagarPedido();
	}
	
	
}

