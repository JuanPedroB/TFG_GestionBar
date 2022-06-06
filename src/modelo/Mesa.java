package modelo;

public class Mesa {

	private int id;
	private String nombre;
	private String cliente;
	private String fecha;
	private int idEstado;
	public Mesa(String nombre, String cliente, String fecha, int idEstado) {
		super();
		this.nombre = nombre;
		this.cliente = cliente;
		this.fecha = fecha;
		this.idEstado = idEstado;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCliente() {
		return cliente;
	}
	public String getFecha() {
		return fecha;
	}
	public int getIdEstado() {
		return idEstado;
	}
	
	
	
}
