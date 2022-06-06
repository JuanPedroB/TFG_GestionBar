package modelo;

public class Producto {

	private int id;
	private String nombre;
	private float precio;
	private byte [] imagen;
	private int idCategoria;
	
	public Producto(String nombre, float precio, byte[] imagen, int idCategoria) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.imagen = imagen;
		this.idCategoria = idCategoria;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	
}
