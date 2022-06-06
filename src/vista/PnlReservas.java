package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import com.toedter.calendar.JDateChooser;

import rsbuttom.RSButtonMetro;
import utiles.ImagenPanel;

public class PnlReservas extends JPanel {
	private JTextField textFieldCliente;
	private int maxMesas = 16;
	private ArrayList<RSButtonMetro> botonera;
	private JPanel panelReservaAceptada;
	private JPanel panel_1;
	private ButtonGroup radioMesas;
	private JRadioButton rdbtnDisponible;
	private JRadioButton rdbtnOcupada;
	private JRadioButton rdbtnReservada;
	private JDateChooser dateChooser;
	private JComboBox comboBox;
	private JLabel lblCliente;
	private JLabel lblFecha;
	private JLabel lblHora;
	private JLabel lblMensajeReserva;
	private JLabel lblInfoReserva;
	private JButton btnGuardar;
	private JButton btnLimpiar;

	/**
	 * Create the panel.
	 */
	public PnlReservas() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(128, 128, 128), Color.GRAY));
		add(panel);
		
		JPanel cabecera = new JPanel();
		cabecera.setBackground(Color.WHITE);
		cabecera.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(49, 163, 250), new Color(128, 128, 128), new Color(49, 163, 250)));
		ImagenPanel croquiMesas = new ImagenPanel("/img/croquiMesas2.jpg");
		
		JPanel opciones = new JPanel();
		opciones.setBackground(Color.WHITE);
		opciones.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(49, 163, 250), new Color(128, 128, 128), new Color(49, 163, 250)));
		
		JPanel eleccionMesa = new JPanel();
		eleccionMesa.setBackground(Color.WHITE);
		eleccionMesa.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(49, 163, 250), new Color(128, 128, 128), new Color(49, 163, 250)));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(cabecera, GroupLayout.DEFAULT_SIZE, 861, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(opciones, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(croquiMesas, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
								.addComponent(eleccionMesa, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(cabecera, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(eleccionMesa, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(croquiMesas, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
						.addComponent(opciones, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
					.addContainerGap())
		);
		botonera = new ArrayList<RSButtonMetro>();
		crearBotonera();
		
		GroupLayout gl_eleccionMesa = new GroupLayout(eleccionMesa);
		gl_eleccionMesa.setHorizontalGroup(
			gl_eleccionMesa.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_eleccionMesa.createSequentialGroup()
					.addGap(26)
					.addComponent(botonera.get(0), GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(botonera.get(1), GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(botonera.get(2), GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(botonera.get(3), GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(botonera.get(4), GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(botonera.get(5), GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(botonera.get(6), GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(botonera.get(7), GroupLayout.PREFERRED_SIZE, 74, Short.MAX_VALUE)
					.addGap(22))
				.addGroup(Alignment.LEADING, gl_eleccionMesa.createSequentialGroup()
					.addGap(54)
					.addComponent(botonera.get(8), GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(botonera.get(9), GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(botonera.get(10), GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(botonera.get(11), GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(botonera.get(12), GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(botonera.get(13), GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(botonera.get(14), GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addGap(45))
		);
		gl_eleccionMesa.setVerticalGroup(
			gl_eleccionMesa.createParallelGroup(Alignment.CENTER)
				.addGroup(gl_eleccionMesa.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_eleccionMesa.createParallelGroup(Alignment.BASELINE)
						.addComponent(botonera.get(0))
						.addComponent(botonera.get(1))
						.addComponent(botonera.get(2))
						.addComponent(botonera.get(3))
						.addComponent(botonera.get(4))
						.addComponent(botonera.get(5))
						.addComponent(botonera.get(6))
						.addComponent(botonera.get(7)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_eleccionMesa.createParallelGroup(Alignment.BASELINE)
						.addComponent(botonera.get(8))
						.addComponent(botonera.get(9))
						.addComponent(botonera.get(10))
						.addComponent(botonera.get(11))
						.addComponent(botonera.get(12))
						.addComponent(botonera.get(13))
						.addComponent(botonera.get(14)))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		eleccionMesa.setLayout(gl_eleccionMesa);
		GroupLayout gl_croquiMesas = new GroupLayout(croquiMesas);
		gl_croquiMesas.setHorizontalGroup(
			gl_croquiMesas.createParallelGroup(Alignment.LEADING)
				.addGap(0, 626, Short.MAX_VALUE)
		);
		gl_croquiMesas.setVerticalGroup(
			gl_croquiMesas.createParallelGroup(Alignment.LEADING)
				.addGap(0, 476, Short.MAX_VALUE)
		);
		croquiMesas.setLayout(gl_croquiMesas);
		
		panelReservaAceptada = new JPanel();
		panelReservaAceptada.setVisible(false);
		panelReservaAceptada.setBackground(new Color(234, 152, 126));
		panelReservaAceptada.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(225, 92, 49), new Color(225, 92, 49), new Color(225, 92, 49), new Color(225, 92, 49)));
		
		JPanel panelConfiguracion = new JPanel();
		panelConfiguracion.setBackground(Color.WHITE);
		panelConfiguracion.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), new Color(225, 92, 49), new Color(128, 128, 128), new Color(225, 92, 49)));
		
		GroupLayout gl_opciones = new GroupLayout(opciones);
		gl_opciones.setHorizontalGroup(
			gl_opciones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_opciones.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_opciones.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_opciones.createSequentialGroup()
							.addGap(10)
							.addComponent(panelReservaAceptada, GroupLayout.PREFERRED_SIZE, 173, Short.MAX_VALUE)
							.addGap(12))
						.addComponent(panelConfiguracion, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 195, Short.MAX_VALUE))
					.addGap(6))
		);
		gl_opciones.setVerticalGroup(
			gl_opciones.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_opciones.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelConfiguracion, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panelReservaAceptada, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		GroupLayout gl_panelConfiguracion = new GroupLayout(panelConfiguracion);
		gl_panelConfiguracion.setHorizontalGroup(
			gl_panelConfiguracion.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelConfiguracion.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelConfiguracion.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(12))
		);
		gl_panelConfiguracion.setVerticalGroup(
			gl_panelConfiguracion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelConfiguracion.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 190, Short.MAX_VALUE)
					.addContainerGap())
		);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{29, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 14, 16, 21, 5, 41, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		lblCliente = new JLabel("Cliente:");
		lblCliente.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 0;
		panel_2.add(lblCliente, gbc_lblCliente);
		
		textFieldCliente = new JTextField();
		GridBagConstraints gbc_textFieldCliente = new GridBagConstraints();
		gbc_textFieldCliente.gridwidth = 3;
		gbc_textFieldCliente.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCliente.gridx = 1;
		gbc_textFieldCliente.gridy = 0;
		panel_2.add(textFieldCliente, gbc_textFieldCliente);
		textFieldCliente.setColumns(10);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 2;
		panel_2.add(lblFecha, gbc_lblFecha);
		
		dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 3;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 2;
		panel_2.add(dateChooser, gbc_dateChooser);
		
		lblHora = new JLabel("Hora:");
		lblHora.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblHora = new GridBagConstraints();
		gbc_lblHora.insets = new Insets(0, 0, 5, 5);
		gbc_lblHora.gridx = 0;
		gbc_lblHora.gridy = 4;
		panel_2.add(lblHora, gbc_lblHora);
		
		comboBox = new JComboBox();
		rellenarComboHoras();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 4;
		panel_2.add(comboBox, gbc_comboBox);
		
		btnGuardar = new JButton("Guardar");
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 6;
		panel_2.add(btnGuardar, gbc_btnGuardar);
		
		btnLimpiar = new JButton("Limpiar");
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.gridwidth = 2;
		gbc_btnLimpiar.gridx = 2;
		gbc_btnLimpiar.gridy = 6;
		panel_2.add(btnLimpiar, gbc_btnLimpiar);
		radioMesas = new ButtonGroup();
		rdbtnDisponible = new JRadioButton("Disponible");
		rdbtnDisponible.setBackground(Color.WHITE);
		rdbtnOcupada = new JRadioButton("Ocupada");
		rdbtnOcupada.setBackground(Color.WHITE);
		rdbtnReservada = new JRadioButton("Reservada");
		rdbtnReservada.setBackground(Color.WHITE);
		radioMesas.add(rdbtnDisponible);
		radioMesas.add(rdbtnOcupada);
		radioMesas.add(rdbtnReservada);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnDisponible)
						.addComponent(rdbtnOcupada)
						.addComponent(rdbtnReservada))
					.addContainerGap(86, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdbtnDisponible)
					.addGap(18)
					.addComponent(rdbtnOcupada)
					.addGap(18)
					.addComponent(rdbtnReservada)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panelConfiguracion.setLayout(gl_panelConfiguracion);
		
		lblMensajeReserva = new JLabel("");
		lblMensajeReserva.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblMensajeReserva.setForeground(Color.BLACK);
		lblMensajeReserva.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblInfoReserva = new JLabel("");
		lblInfoReserva.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(PnlReservas.class.getResource("/img/reserva.png")));
		GroupLayout gl_panelReservaAceptada = new GroupLayout(panelReservaAceptada);
		gl_panelReservaAceptada.setHorizontalGroup(
			gl_panelReservaAceptada.createParallelGroup(Alignment.TRAILING)
				.addComponent(lblMensajeReserva, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
				.addGroup(gl_panelReservaAceptada.createSequentialGroup()
					.addContainerGap(72, Short.MAX_VALUE)
					.addComponent(lblNewLabel_7)
					.addGap(73))
				.addComponent(lblInfoReserva, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
		);
		gl_panelReservaAceptada.setVerticalGroup(
			gl_panelReservaAceptada.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelReservaAceptada.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_7)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblMensajeReserva, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblInfoReserva, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelReservaAceptada.setLayout(gl_panelReservaAceptada);
		opciones.setLayout(gl_opciones);
		
		JLabel lblNewLabel = new JLabel("Gesti\u00F3n de reservas");
		lblNewLabel.setForeground(new Color(49, 163, 250));
		lblNewLabel.setFont(new Font("Lucida Console", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Reservado:");
		
		JLabel lblNewLabel_2 = new JLabel("Ocupado:");
		
		JLabel lblNewLabel_3 = new JLabel("Disponible:");
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(PnlReservas.class.getResource("/img/aceptar.png")));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(PnlReservas.class.getResource("/img/cancelar.png")));
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(PnlReservas.class.getResource("/img/reserva.png")));
		GroupLayout gl_cabecera = new GroupLayout(cabecera);
		gl_cabecera.setHorizontalGroup(
			gl_cabecera.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_cabecera.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4)
					.addGap(30)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_5)
					.addGap(27)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_6)
					.addGap(33))
		);
		gl_cabecera.setVerticalGroup(
			gl_cabecera.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cabecera.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel_1)
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(gl_cabecera.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addGroup(gl_cabecera.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_4)
						.addGroup(gl_cabecera.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2)
							.addComponent(lblNewLabel)
							.addComponent(lblNewLabel_3)
							.addComponent(lblNewLabel_5)))
					.addGap(20))
		);
		cabecera.setLayout(gl_cabecera);
		panel.setLayout(gl_panel);

		rdbtnEditables(false);
		configReserva(false);
	}
	
	private void crearBotonera() {
		for (int i = 1; i < maxMesas; i++) {
			RSButtonMetro boton = new RSButtonMetro();
			boton.setText("Mesa "+i);
			boton.setColorTextNormal(Color.BLACK);
			boton.setColorNormal(Color.WHITE);
			boton.setColorHover(new Color(49, 163, 250));
			botonera.add(boton);
		}
	}
	
	public void seleccionarIcono(String estado, int posicion) {
		for (int i = 0; i < this.botonera.size(); i++) {
			JButton boton = this.botonera.get(posicion);
			if(estado.equals("Disponible")) {
				boton.setIcon(new ImageIcon(getClass().getResource("/img/aceptar.png")));
			}
			if(estado.equals("Ocupada")) {
				boton.setIcon(new ImageIcon(getClass().getResource("/img/cancelar.png")));
			}
			if(estado.equals("Reservada")) {
				boton.setIcon(new ImageIcon(getClass().getResource("/img/reserva.png")));
			}
		}
	}
	
	public void rdbtnEditables(Boolean editable) {
		rdbtnDisponible.setEnabled(editable);
		rdbtnOcupada.setEnabled(editable);
		rdbtnReservada.setEnabled(editable);
		btnGuardar.setEnabled(editable);
		btnLimpiar.setEnabled(editable);
		if(!editable) {
			radioMesas.clearSelection();
		}
	}
	
	public void configReserva(Boolean editable) {
		lblCliente.setEnabled(editable);
		lblFecha.setEnabled(editable);
		lblHora.setEnabled(editable);
		textFieldCliente.setEnabled(editable);
		dateChooser.setEnabled(editable);
		comboBox.setEnabled(editable);
		if(!editable) {
			limpiarConfigReserva();
		}
	}
	public void limpiarConfigReserva() {
		textFieldCliente.setText("");
		dateChooser.getDateEditor().setDate(null);
		comboBox.setSelectedIndex(0);
	}
	
	public void rellenarComboHoras() {
		comboBox.addItem("13:00");
		comboBox.addItem("13:30");
		comboBox.addItem("14:00");
		comboBox.addItem("14:30");
		comboBox.addItem("21:30");
		comboBox.addItem("22:00");
		comboBox.addItem("22:30");
		comboBox.addItem("23:00");
	}
	public ArrayList<RSButtonMetro> getBotonera(){
		return botonera;
	}
	
	public void seleccionarRadioBtn(String nombre) {
		for (int i = 0; i < panel_1.getComponents().length ; i++) {
			JRadioButton boton = (JRadioButton) panel_1.getComponent(i);
			if(boton.getText().equals(nombre)) {
				boton.setSelected(true);
			}
		}
	}
	public ArrayList<JRadioButton> getRdBtns() {
		ArrayList<JRadioButton> radioBtns = new ArrayList<JRadioButton>();
		for (int i = 0; i < panel_1.getComponents().length; i++) {
			radioBtns.add((JRadioButton) panel_1.getComponent(i));
		}
		return radioBtns;
	}
	
	public String getRdbtnSeleccionado() {
		String botonSeleccionado = null;
		for (int i = 0; i < panel_1.getComponents().length ; i++) {
			JRadioButton boton = (JRadioButton) panel_1.getComponent(i);
			if(boton.isSelected()) {
				botonSeleccionado = boton.getText();
			}
		}
		return botonSeleccionado;
	}
	
	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}
	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	
	public JTextField getTextCliente() {
		return textFieldCliente;
	}
	public Date getDateChooser() {
		return dateChooser.getDate();
	}
	public String getComboHora() {
		return comboBox.getSelectedItem().toString();
	}
	
	public JPanel getPnlReservaAceptado() {
		return panelReservaAceptada;
	}
	
	public JLabel getLblFechaReserva() {
		return lblMensajeReserva;
	}
	public JLabel getLblClienteReserva() {
		return lblInfoReserva;
	}
}
