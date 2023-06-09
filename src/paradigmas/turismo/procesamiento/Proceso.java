package paradigmas.turismo.procesamiento;

import java.util.List;
import java.util.Scanner;

import paradigmas.turismo.iterator.AtraccionesIteratorInterface;
import paradigmas.turismo.iterator.PromocionesIteratorInterface;
import paradigmas.turismo.iterator.Sugerencia;
import paradigmas.turismo.iterator.SugerenciaInterface;
import paradigmas.turismo.manejoArchivos.Archivo;
import paradigmas.turismo.models.Atraccion;
import paradigmas.turismo.models.Promocion;
import paradigmas.turismo.models.Usuario;
import paradigmas.turismo.resumenUsuario.ResumenUsuario;

public class Proceso {

	public static void iniciarProcesamiento() {

		Proceso.mensajeDeBienvenida();

		Scanner scanner = new Scanner(System.in);

		Archivo archivoUsuarios = new Archivo("usuarios");
		Archivo archivoAtracciones = new Archivo("atracciones");
		Archivo archivoPromociones = new Archivo("promociones");

		List<Usuario> listaUsuarios = archivoUsuarios.leerArchivoUsuarios();
		List<Atraccion> listaAtracciones = archivoAtracciones.leerArchivoAtracciones();
		List<Promocion> listaPromociones = archivoPromociones.leerArchivoPromociones(listaAtracciones);

		
		  for (Usuario usuario : listaUsuarios) {
		  
		  System.out.println("Nombre del usuario: " + usuario.getNombreUsuario());
		  
		  ResumenUsuario resumenUsuario = new ResumenUsuario(usuario);
		  SugerenciaInterface sugerencia = new Sugerencia(listaAtracciones,
		  listaPromociones, usuario, resumenUsuario);
		  
		  PromocionesIteratorInterface promocionesPreferidasIterator = sugerencia.crearPromocionesPreferidasIterator();
		  AtraccionesIteratorInterface atraccionesPreferidasIterator = sugerencia.crearAtraccionesPreferidasIterator();
		  PromocionesIteratorInterface promocionesNoPreferidasIterator = sugerencia.crearPromocionesNoPreferidasIterator();
		  AtraccionesIteratorInterface atraccionesNoPreferidasIterator = sugerencia.crearAtraccionesNoPreferidasIterator();
		  
		  promocionesIterator(promocionesPreferidasIterator, sugerencia, resumenUsuario, scanner);
		  atraccionesIterator(atraccionesPreferidasIterator, sugerencia, resumenUsuario, scanner);	
		  promocionesIterator(promocionesNoPreferidasIterator, sugerencia, resumenUsuario, scanner);
		  atraccionesIterator(atraccionesNoPreferidasIterator, sugerencia, resumenUsuario, scanner);
		  
		  Proceso.guardarResumenUsuario(resumenUsuario);
		  
		  System.out.println("\n******************************************************************************************");
		  System.out.println("\t\t\tRESUMEN: ");
		  resumenUsuario.mostrarResumen();
		  System.out.println("\t\t\t¡GRACIAS POR VISITARNOS!");
		  System.out.println("********************************************************************************************\n");
		  
		  }
		 

		scanner.close();

	}

	private static void mensajeDeBienvenida() {

		System.out.println("Bievenido/a al Turismo En La Tierra Media");
		System.out.println("-----------------------------------------");
	}
	
	private static void promocionesIterator(PromocionesIteratorInterface promocionesIterator, SugerenciaInterface sugerencia, ResumenUsuario resumenUsuario, Scanner scanner) {
		
		while (promocionesIterator.hasNext()) {

			Promocion promocion = promocionesIterator.getNext();

			if (promocion != null) {

				System.out.println(promocion.toString() + "\n\n");

				boolean respuestaValida = false;
				do {
		            System.out.println("Acepta sugerencia? Ingrese S o N");
		            String respuesta = scanner.next();
		            
		            if (respuesta.equalsIgnoreCase("S")) {
		                resumenUsuario.agregarPromocion(promocion);
		                respuestaValida = true;
		            } else if (respuesta.equalsIgnoreCase("N")) {
		                respuestaValida = true;
		            } else {
		                System.out.println("Por favor, ingrese una respuesta válida.");
		            }
		        } while (!respuestaValida);
			}

		}

	}
	
	private static void atraccionesIterator(AtraccionesIteratorInterface atraccionesIterator, SugerenciaInterface sugerencia, ResumenUsuario resumenUsuario, Scanner scanner) {
		
		
		while (atraccionesIterator.hasNext()) {

			Atraccion atraccion = atraccionesIterator.getNext();

			if (atraccion != null) {

				System.out.println(atraccion.toString() + "\n\n");

				boolean respuestaValida = false;
				do {
		            System.out.println("Acepta sugerencia? Ingrese S o N");
		            String respuesta = scanner.next();
		            
		            if (respuesta.equalsIgnoreCase("S")) {
		                resumenUsuario.agregarAtraccion(atraccion);
		                respuestaValida = true;
		            } else if (respuesta.equalsIgnoreCase("N")) {
		                respuestaValida = true;
		            } else {
		                System.out.println("Por favor, ingrese una respuesta válida.");
		            }
		        } while (!respuestaValida);
			}

		}
		
	}
	

	private static void guardarResumenUsuario(final ResumenUsuario resumenUsuario) {
		
		Archivo archivoResumen = new Archivo("resumenUsuarios");
		archivoResumen.escribirResumenUsuario(resumenUsuario);		
	}
}
