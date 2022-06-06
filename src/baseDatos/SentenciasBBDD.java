package baseDatos;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.LineaPedido;
import modelo.Mesa;
import modelo.Pedido;
import modelo.Producto;

public class SentenciasBBDD {

	private BaseDeDatos baseDeDatos;
	private Connection connection;
	
	private String SQL_INSERTAR_PRODUCTO = "INSERT INTO producto (nombre, precio, imagen, idCategoria) VALUES (?, ?, ?, ?)";
	private String SQL_INSERTAR_PEDIDO = "INSERT INTO pedido (precio, idMesa, pagado, fecha) VALUES (?, ?, ?, ?)";
	private String SQL_INSERTAR_LINEAPEDIDO = "INSERT INTO linea_pedido (cantidad, idProducto, idPedido) VALUES (?, ?, ?)";
	
	private String SQL_CONSULTAR_PRODUCTO = "SELECT * FROM producto ORDER BY idCategoria";
	private String SQL_CONSULTAR_CATEGORIA = "SELECT nombre FROM categoria";
	private String SQL_CONSULTAR_NOMBRECATEGORIA = "SELECT nombre FROM categoria WHERE id = ?";
	private String SQL_CONSULTAR_PRODUCTO_BY_NOMBRE = "SELECT * FROM producto WHERE nombre = ?";
	private String SQL_CONSULTAR_ID_ESTADOMESA = "SELECT idEstado FROM mesa WHERE nombre = ?";
	private String SQL_CONSULTAR_NOMBREESTADOMESA = "SELECT nombre FROM estado_mesa WHERE id = ?";
	private String SQL_CONSULTAR_ID_BY_NOMBREESTADO = "SELECT id FROM estado_mesa WHERE nombre = ?";
	private String SQL_CONSULTAR_MESA_BY_NOMBRE = "SELECT * FROM mesa WHERE nombre = ?";
	private String SQL_CONSULTAR_IDPEDIDO_BY_FECHA ="SELECT id FROM pedido WHERE fecha = ?";
	private String SQL_CONSULTAR_IDPRODUCTO_BY_NOMBRE = "SELECT id FROM producto WHERE nombre = ?";
	private String SQL_CONSULTAR_LINEAPEDIDO_BY_IDPEDIDO = "SELECT * FROM linea_pedido WHERE idPedido = ?";
	private String SQL_CONSULTAR_PRODUCTO_BY_ID = "SELECT * FROM producto WHERE id = ?";
	private String SQL_CONSULTAR_CANTIDAD_LINEAPEDIDO_BY_IDPRODUCTO = "SELECT cantidad FROM linea_pedido WHERE idProducto = ?";
	private String SQL_CONSULTAR_PEDIDOS = "SELECT * FROM pedido";
	private String SQL_CONSULTAR_NOMBREMESA_BY_ID = "SELECT nombre FROM mesa WHERE id = ?";
	
	private String SQL_ELIMINAR_PRODUCTO_BY_NOMBRE = "DELETE FROM producto WHERE nombre = ?";
	private String SQL_ELIMINAR_LINEAPEDIDO_BY_IDPRODUCTO = "DELETE FROM linea_pedido WHERE idProducto = ?";
	private String SQL_ELIMINAR_PEDIDO_BY_ID = "DELETE FROM pedido WHERE id = ?";
	private String SQL_ELIMINAR_LINEAPEDIDO_BY_IDPEDIDO = "DELETE FROM linea_pedido WHERE idPedido = ?";
	
	private String SQL_ACTUALIZAR_PRODUCTO_CONIMAGEN = "UPDATE producto SET nombre = ?, precio = ?, imagen = ?, idCategoria = ? WHERE nombre = ?";
	private String SQL_ACTUALIZAR_PRODUCTO_SINIMAGEN = "UPDATE producto SET nombre = ?, precio = ?, idCategoria = ? WHERE nombre = ?";
	private String SQL_ACTUALIZAR_MESA_NORESERVADA = "UPDATE mesa SET cliente = ?, fecha = ?, idEstado = ? WHERE nombre = ?";
	private String SQL_ACTUALIZAR_LINEAPEDIDO_BY_IDPRODUCTO = "UPDATE linea_pedido SET cantidad = cantidad+1 WHERE idProducto = ?";
	private String SQL_ACTUALIZAR__QUITARCANTIDAD_LINEAPEDIDO_BY_IDPRODUCTO = "UPDATE linea_pedido SET cantidad = cantidad-1 WHERE idProducto = ?";
	private String SQL_ACTUALIZAR_PEDIDO = "UPDATE pedido SET precio = ?, idMesa = ?, fecha = ? WHERE id = ?";
	private String SQL_ACTUALIZAR_PAGAR_PEDIDO = "UPDATE pedido SET pagado = true WHERE id = ?";
	
	
	
	public SentenciasBBDD() {
		super();
		baseDeDatos = new BaseDeDatos();
		connection = baseDeDatos.getBase();
	}
	
	public void insertarProducto(Producto producto) {
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement(SQL_INSERTAR_PRODUCTO);
			preparedStatement.setString(1, producto.getNombre());
			preparedStatement.setFloat(2, producto.getPrecio());
			preparedStatement.setBytes(3, producto.getImagen());
			preparedStatement.setInt(4, producto.getIdCategoria());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void insertarPedido(Pedido pedido) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SQL_INSERTAR_PEDIDO);
			preparedStatement.setFloat(1, pedido.getPrecio());
			preparedStatement.setInt(2, pedido.getIdMesa());
			preparedStatement.setBoolean(3, pedido.isPagado());
			preparedStatement.setString(4, pedido.getFecha());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void insertarLineaPedido(LineaPedido lineaPedido) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SQL_INSERTAR_LINEAPEDIDO);
			preparedStatement.setInt(1, lineaPedido.getCantidad());
			preparedStatement.setInt(2, lineaPedido.getProducto());
			preparedStatement.setInt(3, lineaPedido.getIdPedido());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public int consultarIdPedidoByFecha(String fecha) {
		int id = -1;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_CONSULTAR_IDPEDIDO_BY_FECHA);
			preparedStatement.setString(1, fecha);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				id = resultSet.getInt("id");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return id;
	}
	
	public int consultarIdProductoByNombre(String nombre) {
		int id = -1;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_CONSULTAR_IDPRODUCTO_BY_NOMBRE);
			preparedStatement.setString(1, nombre);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				id = resultSet.getInt("id");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return id;
	}
	
	public ArrayList<Producto> consultarProductos() {
		ArrayList<Producto> productos = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL_CONSULTAR_PRODUCTO);
			
			while(resultSet.next()) {
				Producto producto = new Producto(resultSet.getString("nombre"), resultSet.getFloat("precio"), resultSet.getBytes("imagen"), resultSet.getInt("idCategoria"));
				productos.add(producto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return productos;
	}
	
	public ArrayList<Pedido> consultarPedidos(){
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL_CONSULTAR_PEDIDOS);
			
			while(resultSet.next()) {
				Pedido pedido = new Pedido(resultSet.getInt("id"), resultSet.getFloat("precio"), resultSet.getInt("idMesa"), resultSet.getBoolean("pagado"), resultSet.getString("fecha"));
				pedidos.add(pedido);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return pedidos;
	}
	
	public ArrayList<Pedido> consultarPedidosByFecha(String filtro, String nombre){
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(("SELECT * FROM pedido WHERE "+filtro+" LIKE '%"+nombre+"%'"));
			while(resultSet.next()) {
				Pedido pedido = new Pedido(resultSet.getInt("id"), resultSet.getFloat("precio"), resultSet.getInt("idMesa"), resultSet.getBoolean("pagado"), resultSet.getString("fecha"));
				pedidos.add(pedido);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return pedidos;
	}
	
	
	public ArrayList<Producto> consultarProductoByFiltro(String filtro, String nombre){
		ArrayList<Producto> productos = new ArrayList<Producto>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(("SELECT * FROM producto WHERE "+filtro+" LIKE '%"+nombre+"%'"));
			while(resultSet.next()) {
				Producto producto = new Producto(resultSet.getString("nombre"), resultSet.getFloat("precio"), resultSet.getBytes("imagen"), resultSet.getInt("idCategoria"));
				productos.add(producto);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return productos;
	}
	
	public ArrayList<LineaPedido> consultarLineaPedidoByIdPedido(int idPedido){
		ArrayList<LineaPedido> lineasPedido = new ArrayList<LineaPedido>();
		try {
			PreparedStatement statement = connection.prepareStatement(SQL_CONSULTAR_LINEAPEDIDO_BY_IDPEDIDO);
			statement.setInt(1, idPedido);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				LineaPedido linea= new LineaPedido(resultSet.getInt("idPedido"), resultSet.getInt("cantidad"), resultSet.getInt("idProducto"));
				lineasPedido.add(linea);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return lineasPedido;
	}
	
	public Producto consultarProductoById(int id) {
		Producto producto = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_CONSULTAR_PRODUCTO_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				producto = new Producto(resultSet.getString("nombre"), resultSet.getFloat("precio"), resultSet.getBytes("imagen"), resultSet.getInt("idCategoria"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return producto;
	}
	
	public Producto consultarProductoByNombre(String nombre) {
		Producto producto = null;
		try {
			PreparedStatement statement = connection.prepareStatement(SQL_CONSULTAR_PRODUCTO_BY_NOMBRE);
			statement.setString(1, nombre);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				producto = new Producto(resultSet.getString("nombre"), resultSet.getFloat("precio"), resultSet.getBytes("imagen"), resultSet.getInt("idCategoria"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return producto;
	}
	
	public Mesa consultarMesaByNombre(String nombre) {
		Mesa mesa = null;
		try {
			PreparedStatement statement = connection.prepareStatement(SQL_CONSULTAR_MESA_BY_NOMBRE);
			statement.setString(1, nombre);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				mesa = new Mesa(resultSet.getString("nombre"), resultSet.getString("cliente"), resultSet.getString("fecha"), resultSet.getInt("idEstado"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return mesa;
	}
	
	public String consultarNombreMesaById(int id) {
		String mesa = "";
		try {
			PreparedStatement statement = connection.prepareStatement(SQL_CONSULTAR_NOMBREMESA_BY_ID);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				mesa = resultSet.getString("nombre");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return mesa;
	}
	
	public int consultarIdEstadoMesa(String nombre) {
		int id = -1;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_CONSULTAR_ID_ESTADOMESA);
			preparedStatement.setString(1, nombre);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				id = resultSet.getInt("idEstado");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return id;
	}
	
	public int consultarIdEstadoMesaByNombre(String nombre) {
		int id = -1;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_CONSULTAR_ID_BY_NOMBREESTADO);
			preparedStatement.setString(1, nombre);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				id = resultSet.getInt("id");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return id;
	}
	
	public String consultarNombreEstadoMesa(String nombre) {
		int id = consultarIdEstadoMesa(nombre);
		String estado = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_CONSULTAR_NOMBREESTADOMESA);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				estado = resultSet.getString("nombre");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return estado;
	}
	
	public void actualizarProductoConImagen(Producto producto, String nombreOld) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SQL_ACTUALIZAR_PRODUCTO_CONIMAGEN);
			preparedStatement.setString(1, producto.getNombre());
			preparedStatement.setFloat(2, producto.getPrecio());
			preparedStatement.setBytes(3, producto.getImagen());
			preparedStatement.setInt(4, producto.getIdCategoria());
			preparedStatement.setString(5, nombreOld);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	public void actualizarProductoSinImagen(Producto producto, String nombreOld) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SQL_ACTUALIZAR_PRODUCTO_SINIMAGEN);
			preparedStatement.setString(1, producto.getNombre());
			preparedStatement.setFloat(2, producto.getPrecio());
			preparedStatement.setInt(3, producto.getIdCategoria());
			preparedStatement.setString(4, nombreOld);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void actualizarMesa(Mesa mesa) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(SQL_ACTUALIZAR_MESA_NORESERVADA);
			preparedStatement.setString(1, mesa.getCliente());
			preparedStatement.setString(2, mesa.getFecha());
			preparedStatement.setInt(3, mesa.getIdEstado());
			preparedStatement.setString(4, mesa.getNombre());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void actualizarSumarCantidadLineaPedido(int idProdcuto) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_ACTUALIZAR_LINEAPEDIDO_BY_IDPRODUCTO);
			preparedStatement.setInt(1, idProdcuto);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	public void actualizarQuitarCantidadLineaPedido(int idProdcuto) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_ACTUALIZAR__QUITARCANTIDAD_LINEAPEDIDO_BY_IDPRODUCTO);
			preparedStatement.setInt(1, idProdcuto);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void actualizarPedidoById(Pedido pedido, int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_ACTUALIZAR_PEDIDO);
			preparedStatement.setFloat(1, pedido.getPrecio());
			preparedStatement.setInt(2, pedido.getIdMesa());
			preparedStatement.setString(3, pedido.getFecha());
			preparedStatement.setInt(4, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void actualizarPagarPedido(int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_ACTUALIZAR_PAGAR_PEDIDO);
			preparedStatement.setFloat(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public int obtenerCantidadLineaPedido(int idProducto) {
		int cantidad = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_CONSULTAR_CANTIDAD_LINEAPEDIDO_BY_IDPRODUCTO);
			preparedStatement.setInt(1, idProducto);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				cantidad = resultSet.getInt("cantidad");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return cantidad;
	}
	
	public ArrayList<String> obtenerCategorias(){
		ArrayList<String> categorias = new ArrayList<String>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL_CONSULTAR_CATEGORIA);
			
			while(resultSet.next()) {
				categorias.add(resultSet.getString("nombre"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return categorias;
	}
	
	public int obtenerIdCategoria(String nombre) {
		int id = -1;
		try {
			Statement statement = connection.createStatement();
			ResultSet rSet = statement.executeQuery("SELECT id FROM categoria WHERE nombre LIKE '%"+nombre+"%'");
			if(rSet != null) {
				rSet.next();
				id = rSet.getInt("id");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return id;
	}
	
	public String obtenerNombreCategoria(int id) {
		String nombre ="";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_CONSULTAR_NOMBRECATEGORIA);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet != null) {
				resultSet.next();
				nombre = resultSet.getString("nombre");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return nombre;
	}
	
	public void borrarProducto(String nombre) {
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_ELIMINAR_PRODUCTO_BY_NOMBRE);
			preparedStatement.setString(1, nombre);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void borrarLineaPedido(int idProducto) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_ELIMINAR_LINEAPEDIDO_BY_IDPRODUCTO);
			preparedStatement.setInt(1, idProducto);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void borrarPedido(int id) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_ELIMINAR_PEDIDO_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void borrarLineasPedidoByIdPedido(int idPedido) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_ELIMINAR_LINEAPEDIDO_BY_IDPEDIDO);
			preparedStatement.setInt(1, idPedido);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
}
