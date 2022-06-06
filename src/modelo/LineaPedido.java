package modelo;

public class LineaPedido {

	private int id;
	private int idPedido;
	private int cantidad;
	private int producto;
	public LineaPedido(int idPedido, int cantidad, int producto) {
		super();
		this.idPedido = idPedido;
		this.cantidad = cantidad;
		this.producto = producto;
	}
	public int getId() {
		return id;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public int getCantidad() {
		return cantidad;
	}
	public int getProducto() {
		return producto;
	}
	
	
}
