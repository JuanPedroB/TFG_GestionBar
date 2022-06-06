package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.Timestamp;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import Animacion.Animacion;
import modelo.LineaPedido;
import modelo.Mesa;
import modelo.Pedido;
import modelo.Producto;
import utiles.ImgTabla;
import utiles.Validaciones;
import vista.PnlAñadirProducto;
import vista.PnlInicio;
import vista.PnlProductos;
import vista.PnlReservas;
import vista.UI;

public class ParaUI extends UI {
	
	private Controlador controlador;
	private String rutaImagen;
	private String mesaSeleccionada;
	private int idPedido = -1;
	
	public ParaUI() {
		super();
		controlador = new Controlador();
		
		getBtnMenu().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int posicion = getPanelMenu().getX();
				if(posicion > -1) {
					Animacion.mover_izquierda(0, -200, 2, 2, getPanelMenu());
				}else {
					Animacion.mover_derecha(-200, 0, 2, 2, getPanelMenu());
				}
			}
		});
		
		getBtnInicio().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desactivarBotones();
				getBtnInicio().setColorNormal(new Color(49, 163,250));
				getBtnInicio().setColorHover(new Color(49, 163,250));
				getBtnInicio().setColorPressed(new Color(49, 163,250));
				
				cambiaPanel(getPnlInicio());
			}
		});
		
		getBtnProductos().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desactivarBotones();
				getBtnProductos().setColorNormal(new Color(49, 163,250));
				getBtnProductos().setColorHover(new Color(49, 163,250));
				getBtnProductos().setColorPressed(new Color(49, 163,250));
				
				cambiaPanel(getPnlProductos());
				controlador.rellenarTablaPnlProductos(getTablaProductos(), controlador.consultarProductos());
				
			}
		});
		getBtnPedidos().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desactivarBotones();
				getBtnPedidos().setColorNormal(new Color(49, 163,250));
				getBtnPedidos().setColorHover(new Color(49, 163,250));
				getBtnPedidos().setColorPressed(new Color(49, 163,250));
				
				cambiaPanel(getPnlPedido());
				controlador.rellenarTablaProductosPnlPedido(getTablaProductosPnlPedido(), controlador.consultarProductos());
				controlador.rellenarTablaPedidoPnlPedido(getTablaPedidoPnlPedido(), controlador.consultarLineasPedidoByIdPedido(idPedido));
				
			}
		});
		getBtnReservas().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desactivarBotones();
				getBtnReservas().setColorNormal(new Color(49, 163,250));
				getBtnReservas().setColorHover(new Color(49, 163,250));
				getBtnReservas().setColorPressed(new Color(49, 163,250));
				
				actualizarPnlDefault();
				asignarIconoMesas();
				cambiaPanel(getPnlReservas());
			}
		});
		getBtnVentas().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				desactivarBotones();
				getBtnVentas().setColorNormal(new Color(49, 163,250));
				getBtnVentas().setColorHover(new Color(49, 163,250));
				getBtnVentas().setColorPressed(new Color(49, 163,250));
				
				cambiaPanel(getPnlVentas());
				controlador.rellenarTablaVentasPnlVentas(getTablaPnlVentas(), controlador.consultarPedidos());
			}
		});
		
		getBtnAñadirProducto().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				rellenarComboCategorias();
				rutaImagen = null;
				int showConfirmDialog = JOptionPane.showConfirmDialog(null, getPnlAñadirProducto(), "Añadir producto", JOptionPane.YES_NO_OPTION);
				boolean productoValido = true;
				boolean nombreRepetido = true;
				if(showConfirmDialog == JOptionPane.NO_OPTION || showConfirmDialog == JOptionPane.CLOSED_OPTION) {
					limpiarPnlAñadirProducto();
				}else if(showConfirmDialog == JOptionPane.YES_OPTION){
					productoValido = Validaciones.validacionesProducto(getTextNombreProducto().getText(), getTextPrecioProducto().getText());
					ArrayList<Producto> consultarProductos = controlador.consultarProductos();
					nombreRepetido = Validaciones.validarNombreRepetido(getTextNombreProducto().getText(), consultarProductos);
					if(rutaImagen == null) {
						rutaImagen = "D:\\Programas\\Eclipse WorkSpace\\TFG_GestionPedidos\\src\\img\\productoDefault.png";
					}
					
					if(productoValido && nombreRepetido) {
						String nombre = getTextNombreProducto().getText();
						Float precio = Float.valueOf(getTextPrecioProducto().getText());
						int idCategoria = controlador.consultarIdCategoria(getComboPnlAñadirProducto().getSelectedItem().toString());
						byte [] imagen = controlador.getImagen(rutaImagen);
						
						Producto producto = new Producto(nombre, precio, imagen, idCategoria);
						controlador.insertarProducto(producto);
						controlador.rellenarTablaPnlProductos(getTablaProductos(), controlador.consultarProductos());
						JOptionPane.showMessageDialog(null, "El producto "+nombre+" guardado correctamente.");
					}
					limpiarPnlAñadirProducto();
				}
			}
		});
		
		getBtnAbrirFileChooser().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				
				FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif", "png");
				fileChooser.setFileFilter(imgFilter);
				
				int resultado = fileChooser.showOpenDialog(getPnlAñadirProducto());
				
				if (resultado != JFileChooser.CANCEL_OPTION) {

			        File fileName = fileChooser.getSelectedFile();
			        rutaImagen = fileName.getAbsolutePath();

			        if ((fileName == null) || (fileName.getName().equals(""))) {
			            getTextFileChooser().setText("...");
			        } else {
			            ImageIcon imagen = new ImageIcon(rutaImagen);
			            if(imagen.getIconWidth() > 32 && imagen.getIconHeight()>32) {
			            	JOptionPane.showMessageDialog(null, "La resolución no es la correcta");
			            }else {
			            	getTextFileChooser().setText(rutaImagen);
			            	getLblImagenPnlAñadirProducto().setIcon(imagen);
			            	getPnlImagenAñadirProducto().setVisible(true);
			            }
			            
			        }
			    }
			}
		});
		
		getBtnAbrirFileChooserEditar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				
				FileNameExtensionFilter imgFilter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif", "png");
				fileChooser.setFileFilter(imgFilter);
				
				int resultado = fileChooser.showOpenDialog(getPnlEditarProducto());
				
				if (resultado != JFileChooser.CANCEL_OPTION) {

			        File fileName = fileChooser.getSelectedFile();
			        rutaImagen = fileName.getAbsolutePath();

			        if ((fileName == null) || (fileName.getName().equals(""))) {
			            getTextFileChooserEditar().setText("...");
			        } else {
			            ImageIcon imagen = new ImageIcon(rutaImagen);
			            if(imagen.getIconWidth() > 32 && imagen.getIconHeight()>32) {
			            	JOptionPane.showMessageDialog(null, "La resolución no es la correcta");
			            }else {
			            	getTextFileChooserEditar().setText(rutaImagen);
			            	getLblImagenPnlEditarProducto().setIcon(imagen);
			            	getPnlImagenEditarProducto().setVisible(true);
			            }
			            
			        }
			    }
				
			}
		});
		
		getTextPnlProductoFiltro().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String palabra = getTextPnlProductoFiltro().getText();
				String filtro = getComboPnlProductoFiltro().getSelectedItem().toString().toLowerCase();
				ArrayList<Producto> consultarProductosFiltro = controlador.consultarProductosFiltro(filtro, palabra);
				controlador.rellenarTablaPnlProductos(getTablaProductos(), consultarProductosFiltro);
				if(getTextPnlProductoFiltro().getText().equals("")) {
					controlador.rellenarTablaPnlProductos(getTablaProductos(), controlador.consultarProductos());
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		getTextFiltroPnlPedido().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String palabra = getTextFiltroPnlPedido().getText();
				String filtro = "nombre";
				ArrayList<Producto> consultarProductosFiltro = controlador.consultarProductosFiltro(filtro, palabra);
				controlador.rellenarTablaProductosPnlPedido(getTablaProductosPnlPedido(), consultarProductosFiltro);
				if(getTextFiltroPnlPedido().getText().equals("")) {
					controlador.rellenarTablaProductosPnlPedido(getTablaProductosPnlPedido(), controlador.consultarProductos());
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		getMenuEliminarProducto().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = getTablaProductos().getSelectedRow();
				int columnaNombre = 0;
				if(filaSeleccionada == -1) {
					JOptionPane.showMessageDialog(null, "Producto no seleccionado");
				}else {
					String nombre = getTablaProductos().getValueAt(filaSeleccionada, columnaNombre).toString();
					controlador.eliminarProducto(nombre);
					String palabra = getTextPnlProductoFiltro().getText();
					String filtro = getComboPnlProductoFiltro().getSelectedItem().toString().toLowerCase();
					controlador.rellenarTablaPnlProductos(getTablaProductos(), controlador.consultarProductosFiltro(filtro, palabra));
					JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
				}
			}
		});
		
		getMenuActualizarProducto().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = getTablaProductos().getSelectedRow();
				int columnaNombre = 0;
				boolean productoValido = true;
				if(filaSeleccionada == -1) {
					JOptionPane.showMessageDialog(null, "Producto no seleccionado");
				}else {
					String nombre = getTablaProductos().getValueAt(filaSeleccionada, columnaNombre).toString();
					Producto producto = controlador.consultarProductoByNombre(nombre);
					
					rutaImagen = null;
					rellenarComboCategorias();
					getTextNombreProductoEditar().setText(producto.getNombre());
					getTextPrecioProductoEditar().setText(String.valueOf(producto.getPrecio()));
					getComboPnlEditarProducto().setSelectedItem(controlador.consultarNombreCategoria(producto.getIdCategoria()));
					ImageIcon icon= controlador.obtenerImagenBBDD(producto);
					
					getLblImagenPnlEditarProducto().setIcon(icon);
	            	getPnlImagenEditarProducto().setVisible(true);
					
					int showConfirmDialog = JOptionPane.showConfirmDialog(null, getPnlEditarProducto(), "Editar producto", JOptionPane.YES_NO_OPTION);
					if(showConfirmDialog == JOptionPane.YES_OPTION){
						productoValido = Validaciones.validacionesProducto(getTextNombreProductoEditar().getText(), getTextPrecioProductoEditar().getText());
						Producto productoEditado = null;
						if(productoValido) {
							String nombreProducto = getTextNombreProductoEditar().getText();
							Float precio = Float.valueOf(getTextPrecioProductoEditar().getText());
							int idCategoria = controlador.consultarIdCategoria(getComboPnlEditarProducto().getSelectedItem().toString());
							if(getTextFileChooserEditar().getText().equals("")) {
								productoEditado = new Producto(nombreProducto, precio, null, idCategoria);
							}else {
								byte [] imagen = controlador.getImagen(rutaImagen);
								productoEditado = new Producto(nombre, precio, imagen, idCategoria);
							}
							controlador.actualizarProducto(productoEditado, producto.getNombre());
							String palabra = getTextPnlProductoFiltro().getText();
							String filtro = getComboPnlProductoFiltro().getSelectedItem().toString().toLowerCase();
							controlador.rellenarTablaPnlProductos(getTablaProductos(), controlador.consultarProductosFiltro(filtro, palabra));
							JOptionPane.showMessageDialog(null, "El producto "+nombre+" se ha editado correctamente.");
						}
					}
					limpiarPnlEditarProducto();
					
				}
			}
		});
		
		getBotoneraMesas().forEach((mesaBtn) -> {mesaBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				activarRdbtn(true);
				String estadoMesa = controlador.consultarNombreEstadoMesa(mesaBtn.getText());
				seleccionarRdbtnPnlReservas(estadoMesa);
				mesaSeleccionada = mesaBtn.getText();
				if(estadoMesa.equals("Reservada")) {
					Mesa mesa = controlador.consultarMesaByNombre(mesaBtn.getText());
					activarPnlReserva(mesa);
				}else {
					getPnlReservaAceptado().setVisible(false);
				}
			}
		});});
		
		getRdBtns().forEach((radioBtn) -> {radioBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(radioBtn.getText().equals("Reservada")) {
					activarConfigReserva(true);
				}else {
					activarConfigReserva(false);
				}
			}
		});});
		
		getBtnLimpiarPnlReserva().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarConfigPnlReserva();
			}
		});
		
		getBtnGuardarPnlReserva().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int estadoSeleccionado = controlador.consultarIdEstadoMesa(getRdbtnSeleccionadoPnlReserva());
				boolean mesaValida = true;
				if(estadoSeleccionado == 1 || estadoSeleccionado == 2) {
					Mesa mesa = new Mesa(mesaSeleccionada, null, null, estadoSeleccionado);
					controlador.actualizarMesa(mesa);
					getPnlReservaAceptado().setVisible(false);
					asignarIconoMesas();
					JOptionPane.showMessageDialog(null, "La mesa "+mesaSeleccionada+" se ha modificado correctamente.");
				}else {
					String nombreCliente = getTextClientePnlReserva().getText();
					mesaValida = Validaciones.validacionesMesa(nombreCliente, getDateChooserPnlReserva());
					
					if(mesaValida) {
						int dia = getDateChooserPnlReserva().getDate();
						int mes = getDateChooserPnlReserva().getMonth()+1;
						String hora = getComboHoraPnlReserva();
						String fecha = dia+"/"+mes+" - "+hora;
						Mesa mesa = new Mesa(mesaSeleccionada, nombreCliente, fecha, estadoSeleccionado);
						controlador.actualizarMesa(mesa);
						activarPnlReserva(mesa);
						asignarIconoMesas();
						JOptionPane.showMessageDialog(null, "La mesa "+mesaSeleccionada+" se ha modificado correctamente.");
					}
					
				}
					
			}
			
		});
		
		getBtnAñadirAlPedido().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = getTablaProductosPnlPedido().getSelectedRow();
				int columnaNombre = 0;
				if(filaSeleccionada == -1) {
					JOptionPane.showMessageDialog(null, "Selecciona el producto para añadirlo...");
				}else if(idPedido == -1){
					Pedido pedidoPorDefecto = new Pedido(0, 1, false, "");
					controlador.insertarPedido(pedidoPorDefecto);
					idPedido = controlador.consultarIdPedidoByFecha(); 
					insertarLineaPedido(filaSeleccionada, columnaNombre);
				}else {
					insertarLineaPedido(filaSeleccionada, columnaNombre);
				}
				controlador.rellenarTablaPedidoPnlPedido(getTablaPedidoPnlPedido(), controlador.consultarLineasPedidoByIdPedido(idPedido));
				getLblPrecioTotatlPedido().setText(obtenerPrecioTotal());
			}
		});
		
		getBtnAñadirSeleccionado().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = getTablaPedidoPnlPedido().getSelectedRow();
				int columnaNombre = 0;
				if(filaSeleccionada == -1) {
					JOptionPane.showMessageDialog(null, "Selecciona el producto para añadir 1");
				}else {
					String nombre = getTablaPedidoPnlPedido().getValueAt(filaSeleccionada, columnaNombre).toString();
					int idProducto = controlador.consultarIdProductoByNombre(nombre);
					controlador.actualizarSumarCantidadLineaPedido(idProducto);
					controlador.rellenarTablaPedidoPnlPedido(getTablaPedidoPnlPedido(), controlador.consultarLineasPedidoByIdPedido(idPedido));
					getLblPrecioTotatlPedido().setText(obtenerPrecioTotal());
				}
			}
		});
		
		getBtnQuitarSeleccionado().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = getTablaPedidoPnlPedido().getSelectedRow();
				int columnaNombre = 0;
				if(filaSeleccionada == -1) {
					JOptionPane.showMessageDialog(null, "Selecciona el producto para quitar 1");
				}else {
					String nombre = getTablaPedidoPnlPedido().getValueAt(filaSeleccionada, columnaNombre).toString();
					int idProducto = controlador.consultarIdProductoByNombre(nombre);
					controlador.actualizarQuitarCantidadLineaPedido(idProducto);
					ArrayList<LineaPedido> lineasPedido = controlador.consultarLineasPedidoByIdPedido(idPedido);
					controlador.rellenarTablaPedidoPnlPedido(getTablaPedidoPnlPedido(), controlador.consultarLineasPedidoByIdPedido(idPedido));
					getLblPrecioTotatlPedido().setText(obtenerPrecioTotal());
					if(lineasPedido.size() == 0) {
						controlador.eliminarPedido(idPedido);
						idPedido = -1;
					}
					
				}
			}
		});
		
		getBtnLimpiarPedido().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(idPedido != -1) {
					controlador.eliminarLineasPedidoByIdPedido(idPedido);
					controlador.rellenarTablaPedidoPnlPedido(getTablaPedidoPnlPedido(), controlador.consultarLineasPedidoByIdPedido(idPedido));
					controlador.eliminarPedido(idPedido);
					idPedido = -1;
					getLblPrecioTotatlPedido().setText(obtenerPrecioTotal());
					JOptionPane.showMessageDialog(null, "Se ha eliminado el pedido con éxito");
				}else {
					JOptionPane.showMessageDialog(null, "No existe ningun pedido...");
				}
			}
		});
		
		getBtnCrearPedido().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(idPedido != -1) {
					String precio = getLblPrecioTotatlPedido().getText();
					float precioFinal = Float.valueOf(precio.replace("€", ""));
					String mesa = JOptionPane.showInputDialog("Introduce el número de mesa:");
					if(Validaciones.validarMesaPedido(mesa)) {
						int mesaNumero = Integer.valueOf(mesa);
						DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
						String fecha = dtf4.format(LocalDateTime.now());
						Pedido pedido = new Pedido(precioFinal, mesaNumero, false, fecha);
						controlador.actualizarPedidoById(pedido, idPedido);
						idPedido = -1;
						controlador.rellenarTablaPedidoPnlPedido(getTablaPedidoPnlPedido(), controlador.consultarLineasPedidoByIdPedido(idPedido));
						getLblPrecioTotatlPedido().setText(obtenerPrecioTotal());
						JOptionPane.showMessageDialog(null, "Pedido creado con éxito");
					}else {
						JOptionPane.showMessageDialog(null, "El número de mesa introducido es incorrecto");
					}
				}
			}
		});
		
		getTextFiltroPnlVentas().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				String palabra = getTextFiltroPnlVentas().getText();
				String filtro = "fecha";
				ArrayList<Pedido> consultarPedidosFecha = controlador.consultarPedidosFiltro(filtro, palabra);
				controlador.rellenarTablaVentasPnlVentas(getTablaPnlVentas(), consultarPedidosFecha);
				if(getTextFiltroPnlVentas().getText().equals("")) {
					controlador.rellenarTablaVentasPnlVentas(getTablaPnlVentas(), controlador.consultarPedidos());
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		getBtnLimpiarPnlVentas().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getTextFiltroPnlVentas().setText("");
				controlador.rellenarTablaVentasPnlVentas(getTablaPnlVentas(), controlador.consultarPedidos());
			}
		});
		
		getBtnPagarPnlVentas().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = getTablaPnlVentas().getSelectedRow();
				int columna = 0;
				String palabra = getTextFiltroPnlVentas().getText();
				String filtro = "fecha";
				if(filaSeleccionada == -1) {
					JOptionPane.showMessageDialog(null, "Selecciona el pedido para pagarlo");
				}else {
					String nombre = getTablaPnlVentas().getValueAt(filaSeleccionada, columna).toString();
					int Idnombre = Integer.valueOf(nombre.replace("Pedido ", ""));
					controlador.actualizarPagarPedido(Idnombre);
					if(palabra.equals("")) {
						controlador.rellenarTablaVentasPnlVentas(getTablaPnlVentas(), controlador.consultarPedidos());
					}else {
						ArrayList<Pedido> consultarPedidosFecha = controlador.consultarPedidosFiltro(filtro, palabra);
						controlador.rellenarTablaVentasPnlVentas(getTablaPnlVentas(), consultarPedidosFecha);
					}
					JOptionPane.showMessageDialog(null, "Pedido pagado con éxito");
				}
			}
		});
		
	}
	
	private String obtenerPrecioTotal() {
		int filas = getTablaPedidoPnlPedido().getRowCount();
		int columna = 3;
		float precioTotal = 0;
		for (int i = 0; i < filas; i++) {
			String precioColumna = getTablaPedidoPnlPedido().getValueAt(i, 2).toString();
			precioColumna = precioColumna.replace("€", "");
			precioTotal += Float.valueOf(precioColumna);
			precioTotal = (float) (Math.round(precioTotal * 100d) / 100d);
		}
		return String.valueOf(precioTotal+"€");
	}
	
	private void desactivarBotones() {
		getBtnInicio().setColorNormal(Color.WHITE);
		getBtnProductos().setColorNormal(Color.WHITE);
		getBtnPedidos().setColorNormal(Color.WHITE);
		getBtnReservas().setColorNormal(Color.WHITE);
		getBtnVentas().setColorNormal(Color.WHITE);
	}
	
	private void rellenarComboCategorias() {
		getComboPnlAñadirProducto().removeAllItems();
		getComboPnlEditarProducto().removeAllItems();
		ArrayList<String> categ = controlador.consultarCategorias();
		categ.forEach((c) -> {getComboPnlAñadirProducto().addItem(c);
		getComboPnlEditarProducto().addItem(c);});
	}
	private void actualizarPnlDefault() {
		activarRdbtn(false);
		activarConfigReserva(false);
	}
	
	private void asignarIconoMesas() {
		for (int i = 0; i < getBotoneraMesas().size(); i++) {
			String nombreMesa = getBotoneraMesas().get(i).getText();
			String estadoMesa = controlador.consultarNombreEstadoMesa(nombreMesa);
			seleccionarIcono(estadoMesa, i);
		}
	}
	private void activarPnlReserva(Mesa mesa) {
		getLblClienteReserva().setText(mesa.getCliente());
		getLblFechaReserva().setText("Reserva: "+mesa.getFecha());
		getPnlReservaAceptado().setVisible(true);
	}
	
	private void insertarLineaPedido(int filaSeleccionada, int columnaNombre) {
		String nombre = getTablaProductosPnlPedido().getValueAt(filaSeleccionada, columnaNombre).toString();
		int idProducto = controlador.consultarIdProductoByNombre(nombre);
		if(existeProducto(idProducto)) {
			controlador.actualizarSumarCantidadLineaPedido(idProducto);
		}else {
			LineaPedido lineaPedido = new LineaPedido(idPedido, 1, idProducto);
			controlador.insertarLineaPedido(lineaPedido);
		}
	}
	
	private boolean existeProducto(int idProducto) {
		ArrayList<LineaPedido> lineas= new ArrayList<LineaPedido>();
		lineas = controlador.consultarLineasPedidoByIdPedido(idPedido);
		for (int i = 0; i <lineas.size(); i++) {
			if(lineas.get(i).getProducto() == idProducto) {
				return true;
			}
		}
		return false;
		
	}
	
	
}
