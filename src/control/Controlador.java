package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import baseDatos.SentenciasBBDD;
import modelo.LineaPedido;
import modelo.Mesa;
import modelo.Pedido;
import modelo.Producto;
import utiles.ImgTabla;
import utiles.TablaVentas;


public class Controlador {

	private SentenciasBBDD sentenciasBBDD;
	
	public Controlador() {
		super();
		sentenciasBBDD = new SentenciasBBDD();
	}
	
	public ArrayList<Producto> consultarProductos() {
		return sentenciasBBDD.consultarProductos();
	}
	public ArrayList<Producto> consultarProductosFiltro(String filtro, String nombre) {
		if(filtro.equals("categoría")) {
			nombre = String.valueOf(consultarIdCategoria(nombre));
			filtro = "idCategoria";
		}
		return sentenciasBBDD.consultarProductoByFiltro(filtro, nombre);
	}
	
	public ArrayList<Pedido> consultarPedidos(){
		return sentenciasBBDD.consultarPedidos();
	}
	
	public ArrayList<Pedido> consultarPedidosFiltro(String filtro, String nombre){
		return sentenciasBBDD.consultarPedidosByFecha(filtro,nombre);
	}
	public Producto consultarProductoByNombre(String nombre) {
		return sentenciasBBDD.consultarProductoByNombre(nombre);
	}
	
	public Producto consultarProductoById(int id) {
		return sentenciasBBDD.consultarProductoById(id);
	}
	
	public ArrayList<String> consultarCategorias(){
		return sentenciasBBDD.obtenerCategorias();
	}
	
	public ArrayList<LineaPedido> consultarLineasPedidoByIdPedido(int idPedido){
		return sentenciasBBDD.consultarLineaPedidoByIdPedido(idPedido);
	}
	public int consultarIdCategoria(String nombre) {
		return sentenciasBBDD.obtenerIdCategoria(nombre);
	}
	public String consultarNombreCategoria(int id) {
		return sentenciasBBDD.obtenerNombreCategoria(id);
	}
	
	public int consultarIdEstadoMesa(String nombre) {
		return sentenciasBBDD.consultarIdEstadoMesaByNombre(nombre);
	}
	
	public String consultarNombreEstadoMesa(String nombreMesa) {
		return sentenciasBBDD.consultarNombreEstadoMesa(nombreMesa);
	}
	
	public int consultarIdPedidoByFecha() {
		String fecha = "";
		return sentenciasBBDD.consultarIdPedidoByFecha(fecha);
	}
	
	public int consultarIdProductoByNombre(String nombre) {
		return sentenciasBBDD.consultarIdProductoByNombre(nombre);
	}
	
	public void insertarProducto(Producto producto) {
		sentenciasBBDD.insertarProducto(producto);
	}
	
	public void insertarPedido(Pedido pedido) {
		sentenciasBBDD.insertarPedido(pedido);
	}
	
	public void insertarLineaPedido(LineaPedido lineaPedido) {
		sentenciasBBDD.insertarLineaPedido(lineaPedido);
	}
	
	public void eliminarProducto(String nombre) {
		sentenciasBBDD.borrarProducto(nombre);
	}
	
	public void eliminarPedido(int id) {
		sentenciasBBDD.borrarPedido(id);
	}
	
	public void eliminarLineasPedidoByIdPedido(int idPedido) {
		sentenciasBBDD.borrarLineasPedidoByIdPedido(idPedido);
	}
	
	public void actualizarProducto(Producto producto, String nombreOld) {
		if(producto.getImagen() != null) {
			sentenciasBBDD.actualizarProductoConImagen(producto, nombreOld);
		}else {
			sentenciasBBDD.actualizarProductoSinImagen(producto, nombreOld);
		}
	}
	public void actualizarMesa(Mesa mesa) {
		sentenciasBBDD.actualizarMesa(mesa);
	}
	
	public void actualizarSumarCantidadLineaPedido(int idProducto) {
		sentenciasBBDD.actualizarSumarCantidadLineaPedido(idProducto);
	}
	public void actualizarQuitarCantidadLineaPedido(int idProducto) {
		sentenciasBBDD.actualizarQuitarCantidadLineaPedido(idProducto);
		if(sentenciasBBDD.obtenerCantidadLineaPedido(idProducto) <= 0) {
			sentenciasBBDD.borrarLineaPedido(idProducto);
		}
	}
	
	public void actualizarPedidoById(Pedido pedido, int id) {
		sentenciasBBDD.actualizarPedidoById(pedido, id);
	}
	
	public void actualizarPagarPedido(int id) {
		sentenciasBBDD.actualizarPagarPedido(id);
	}
	
	public Mesa consultarMesaByNombre(String nombre) {
		return sentenciasBBDD.consultarMesaByNombre(nombre);
	}
	
	public byte[] getImagen(String ruta) {
		File imagen = new File(ruta);
		try {
			byte[] icono = new byte[(int) imagen.length()];
			InputStream input = new FileInputStream(imagen);
			input.read(icono);
			return icono;
		} catch (Exception e) {
			return null;
		}
	}
	
	private String obtenerMesaPagada(boolean pagado) {
		if(pagado) {
			return "Sí";
		}else {
			return "No";
		}
	}
	
	public void rellenarTablaPnlProductos(JTable table, ArrayList<Producto> productos) {
		table.removeAll();
		table.setDefaultRenderer(Object.class, new ImgTabla());
		
		String[] nombreColumna = {"Nombre","Precio", "Categoría", "Imagen"};
		Object[][] filasTablas = new Object[productos.size()][4];
		for (int i = 0; i < productos.size(); i++) {
			Producto producto = productos.get(i);
			filasTablas[i][0] = producto.getNombre();
			float precioProducto = (float) (Math.round(producto.getPrecio() * 100d) / 100d);
			filasTablas[i][1] = String.valueOf(precioProducto+"€");
			filasTablas[i][2] = consultarNombreCategoria(producto.getIdCategoria());
			
			try {
				ImageIcon icon = obtenerImagenBBDD(producto);
				
				filasTablas[i][3] = new JLabel(icon);
			} catch (Exception e) {
				filasTablas[i][3] = new JLabel("No Imagen");
			}
			
		}
		DefaultTableModel tablaCompleta = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int filasTablas,  int nombreColumna) {
				return false;
			}
		};
		for (int i = 0; i < nombreColumna.length; i++) {
			tablaCompleta.addColumn(nombreColumna[i]);
		}
		for (int i = 0; i < filasTablas.length; i++) {
			tablaCompleta.addRow(filasTablas[i]);
		}
		table.getTableHeader().setForeground(Color.BLACK);
		table.getTableHeader().setFont(new Font("Lucida Console", Font.BOLD, 12));
		table.setRowHeight(50);
		table.setModel(tablaCompleta);
	}
	
	public void rellenarTablaProductosPnlPedido(JTable table, ArrayList<Producto> productos) {
		table.removeAll();
		table.setDefaultRenderer(Object.class, new ImgTabla());
		
		String[] nombreColumna = {"Nombre", "Precio", "Imagen"};
		Object[][] filasTablas = new Object[productos.size()][3];
		for (int i = 0; i < productos.size(); i++) {
			Producto producto = productos.get(i);
			filasTablas[i][0] = producto.getNombre();
			float precioProducto = (float) (Math.round(producto.getPrecio() * 100d) / 100d);
			filasTablas[i][1] = String.valueOf(precioProducto+"€");
			
			try {
				ImageIcon icon = obtenerImagenBBDD(producto);
				
				filasTablas[i][2] = new JLabel(icon);
			} catch (Exception e) {
				filasTablas[i][2] = new JLabel("No Imagen");
			}
			
		}
		DefaultTableModel tablaCompleta = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int filasTablas,  int nombreColumna) {
				return false;
			}
		};
		for (int i = 0; i < nombreColumna.length; i++) {
			tablaCompleta.addColumn(nombreColumna[i]);
		}
		for (int i = 0; i < filasTablas.length; i++) {
			tablaCompleta.addRow(filasTablas[i]);
		}
		table.getTableHeader().setForeground(Color.BLACK);
		table.getTableHeader().setFont(new Font("Lucida Console", Font.BOLD, 12));
		table.setRowHeight(50);
		table.setModel(tablaCompleta);
	}
	
	public void rellenarTablaPedidoPnlPedido(JTable table, ArrayList<LineaPedido> lineas) {
		table.removeAll();
		table.setDefaultRenderer(Object.class, new ImgTabla());
		
		String[] nombreColumna = {"Nombre", "Cantidad", "Precio", "Imagen"};
		Object[][] filasTablas = new Object[lineas.size()][4];
		for (int i = 0; i < lineas.size(); i++) {
			LineaPedido linea = lineas.get(i);
			int idProdcuto = linea.getProducto();
			Producto productoLinea = consultarProductoById(idProdcuto);
			filasTablas[i][0] = productoLinea.getNombre();
			filasTablas[i][1] = linea.getCantidad();
			float precio = linea.getCantidad()*productoLinea.getPrecio();
			precio = (float) (Math.round(precio * 100d) / 100d);
			filasTablas[i][2] = String.valueOf(precio+"€");
			try {
				ImageIcon icon = obtenerImagenBBDD(productoLinea);
				
				filasTablas[i][3] = new JLabel(icon);
			} catch (Exception e) {
				filasTablas[i][3] = new JLabel("No Imagen");
			}
			
		}
		DefaultTableModel tablaCompleta = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int filasTablas,  int nombreColumna) {
				return false;
			}
		};
		for (int i = 0; i < nombreColumna.length; i++) {
			tablaCompleta.addColumn(nombreColumna[i]);
		}
		for (int i = 0; i < filasTablas.length; i++) {
			tablaCompleta.addRow(filasTablas[i]);
		}
		table.getTableHeader().setForeground(Color.BLACK);
		table.getTableHeader().setFont(new Font("Lucida Console", Font.BOLD, 12));
		table.setRowHeight(50);
		table.setModel(tablaCompleta);
	}
	
	public void rellenarTablaVentasPnlVentas(JTable table, ArrayList<Pedido> pedidos) {
		table.removeAll();
		table.setDefaultRenderer(Object.class, new TablaVentas());
		
		String[] nombreColumna = {"Nº Pedido", "Mesa", "Precio", "Pagado", "Fecha"};
		Object[][] filasTablas = new Object[pedidos.size()][5];
		for (int i = 0; i < pedidos.size(); i++) {
			Pedido pedido = pedidos.get(i);
			filasTablas[i][0] = String.valueOf("Pedido "+pedido.getId());
			filasTablas[i][1] = sentenciasBBDD.consultarNombreMesaById(pedido.getIdMesa());
			float precio = pedido.getPrecio();
			precio = (float) (Math.round(precio * 100d) / 100d);
			filasTablas[i][2] = String.valueOf(precio+"€");
			filasTablas[i][3] = obtenerMesaPagada(pedido.isPagado());
			filasTablas[i][4] = pedido.getFecha();
			
		}
		DefaultTableModel tablaCompleta = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int filasTablas,  int nombreColumna) {
				return false;
			}
		};
		for (int i = 0; i < nombreColumna.length; i++) {
			tablaCompleta.addColumn(nombreColumna[i]);
		}
		for (int i = 0; i < filasTablas.length; i++) {
			tablaCompleta.addRow(filasTablas[i]);
		}
		table.getTableHeader().setForeground(Color.BLACK);
		table.getTableHeader().setFont(new Font("Lucida Console", Font.BOLD, 12));
		table.setRowHeight(50);
		table.setModel(tablaCompleta);
	}
	
	public ImageIcon obtenerImagenBBDD(Producto producto) {
		byte [] imagen = producto.getImagen();
		BufferedImage bufferedImage = null;
		InputStream inputStream = new ByteArrayInputStream(imagen);
		try {
			bufferedImage = ImageIO.read(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageIcon icon = new ImageIcon(bufferedImage.getScaledInstance(32, 32, 0));
		return icon;
	}


}
