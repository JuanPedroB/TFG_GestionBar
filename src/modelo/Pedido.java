package modelo;

public class Pedido {

	private int id;
	private float precio;
	private int idMesa;
	private boolean pagado;
	private String fecha;
	public Pedido(int id, float precio, int idMesa, boolean pagado, String fecha) {
		super();
		this.id = id;
		this.precio = precio;
		this.idMesa = idMesa;
		this.pagado = pagado;
		this.fecha = fecha;
	}
	
	public Pedido(float precio, int idMesa, boolean pagado, String fecha) {
		super();
		this.precio = precio;
		this.idMesa = idMesa;
		this.pagado = pagado;
		this.fecha = fecha;
	}
	public int getId() {
		return id;
	}
	public float getPrecio() {
		return precio;
	}
	public int getIdMesa() {
		return idMesa;
	}
	public boolean isPagado() {
		return pagado;
	}
	public String getFecha() {
		return fecha;
	}
	
	
}
