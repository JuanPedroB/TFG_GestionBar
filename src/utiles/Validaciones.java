package utiles;

import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import modelo.Producto;

public class Validaciones {

	public static boolean validarNombreProducto(String nombre) {
		return Pattern.matches("[a-zA-Z0-9áéíóúÁÉÍÓÚ\\s]+", nombre);
	}
	
	public static boolean validarPrecio(String precio) {
		try {
			Float.parseFloat(precio);
			return true;
		} catch (NumberFormatException e) {
		}
		return false;
	}
	public boolean validarCategoria(int categoria) {
		return categoria>0;
	}
	
	public static boolean validarNombreRepetido(String nombre, ArrayList<Producto> lista) {
		boolean respuesta = true;
		for (Producto producto : lista) {
			if(producto.getNombre().equals(nombre)) {
				JOptionPane.showMessageDialog(null, "El nombre del producto ya existe");
				respuesta = false;
			}
		}
		return respuesta;
	}
	
	public static boolean validacionesProducto(String nombre, String precio) {
		boolean respuesta = true;
		if(!validarNombreProducto(nombre)) {
			JOptionPane.showMessageDialog(null, "Nombre del producto incorrecto");
			respuesta = false;
		}
		if(!validarPrecio(precio)) {
			JOptionPane.showMessageDialog(null, "Precio del producto incorrecto");
			respuesta = false;
		}
		return respuesta;
	}
	
	public static boolean validarNombreCliente(String nombre) {
		return Pattern.matches("[a-zA-Z\\s]+", nombre) && nombre.length()<23;
	}
	
	public static boolean validarFecha(Date fecha) {
		int dia = 0;
		int mes = 0;
		try {
			dia = fecha.getDate();
			mes = fecha.getMonth()+1;
			return true;
		} catch (Exception e2) {
			return false;
		}
	}
	public static boolean validacionesMesa(String nombre, Date fecha) {
		boolean respuesta = true;
		if(!validarNombreCliente(nombre)) {
			JOptionPane.showMessageDialog(null, "Nombre del cliente incorrecto");
			respuesta = false;
		}
		if(!validarFecha(fecha)) {
			JOptionPane.showMessageDialog(null, "Fecha incorrecta");
			respuesta = false;
		}
		return respuesta;
	}
	
	public static boolean validarMesaPedido(String mesa) {
		try {
			Integer.parseInt(mesa);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
