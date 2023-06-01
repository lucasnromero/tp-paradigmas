package unlam.turismo.consola;

import unlam.turismo.models.Usuario;
import unlam.turismo.sugerencia.Sugerencia;

import java.util.List;

import unlam.turismo.manejoArchivo.*;
import unlam.turismo.models.*;

public class ManejoConsola {

	private Sugerencia sugerencia;
	private Usuario usuario;

	//no entiendo esta clase
	private ManejoConsola(Sugerencia sugerencia, Usuario usuario) {
		this.sugerencia = sugerencia;
		this.usuario = usuario;
	}
	
	public static void iniciarProcesamiento() {
		
		System.out.println("Bienvenido/a al Turismo en la Tierra Media");
		
		Archivo archivoPromociones = new Archivo("promociones");
		Archivo archivoAtracciones = new Archivo("atracciones");
		Archivo archivoUsuarios = new Archivo("usuarios");
		
	    Sugerencia sugerencia = new Sugerencia();
	    List<Usuario> usuarios = archivoUsuarios.leerArchivoUsuarios();

	    sugerencia.setListaAtracciones(archivoAtracciones.leerArchivoAtracciones());
	    sugerencia.setListaPromociones(archivoPromociones.leerArchivoPromociones());
	    
	    //PARA PROBAR LEER Y MOSTRAR ARCHIVO DE USUARIOS
	    for(Usuario usuario: usuarios) {
	    	usuario.leerUsuario();
	    	System.out.println("\n");
	    }
	    
	    //PARA PROBAR LEER Y MOSTRAR ARCHIVO DE ATRACCIONES
	    for (Atraccion atraccion : sugerencia.getListaAtracciones()) {
		    atraccion.leerAtraccion();
		    System.out.println("\n");
		}
	    
		//PARA PROBAR LEER Y MOSTRAR ARCHIVO DE PROMOCIONES
		for (Promocion promocion : sugerencia.getListaPromociones()) {
		    promocion.leerPromocion(sugerencia.getListaAtracciones());
		    System.out.println("\n");
		}
		
	}
	
	
}
