package unlam.turismo.consola;

import unlam.turismo.models.Usuario;
import unlam.turismo.sugerencia.Sugerencia;

import java.util.List;

import unlam.turismo.manejoArchivo.*;
import unlam.turismo.models.*;

public class ManejoConsola {

	private Sugerencia sugerencia;
	private Usuario usuario;

	private ManejoConsola(Sugerencia sugerencia, Usuario usuario) {
		this.sugerencia = sugerencia;
		this.usuario = usuario;
	}
	
	public static void iniciarProcesamiento() {
		
		System.out.println("Bienvenido/a al Turismo en la Tierra Media");
		
		//PARA PROBAR LEER Y MOSTRAR ARCHIVO DE PROMOCIONES
		Archivo archivoPromociones = new Archivo("promociones");
		
		List<Promocion> listaPromociones = archivoPromociones.leerArchivoPromociones();
		
		for (Promocion promocion : listaPromociones) {
		    promocion.leerPromocion();
		}
		
	}
	
	
}
