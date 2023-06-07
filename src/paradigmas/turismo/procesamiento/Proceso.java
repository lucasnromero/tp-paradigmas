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
			SugerenciaInterface sugerencia = new Sugerencia(listaAtracciones, listaPromociones, usuario,
					resumenUsuario);

			promocionesPreferidas(sugerencia, resumenUsuario, scanner);
			atraccionesPreferidas(sugerencia, resumenUsuario, scanner);
			promocionesNoPreferidas(sugerencia, resumenUsuario, scanner);
			atraccionesNoPreferidas(sugerencia, resumenUsuario, scanner);
			

			Proceso.guardarResumenUsuario(resumenUsuario);
		}

		scanner.close();

	}

	private static void mensajeDeBienvenida() {

		System.out.println("Bievenido/a al Turismo En La Tierra Media");
		System.out.println("-----------------------------------------");
	}
	
	private static void promocionesPreferidas(SugerenciaInterface sugerencia, ResumenUsuario resumenUsuario, Scanner scanner) {
		PromocionesIteratorInterface promocionesPreferidasIterator = sugerencia
				.crearPromocionesPreferidasIterator();
		
		while (promocionesPreferidasIterator.hasNext()) {

			Promocion promocion = promocionesPreferidasIterator.getNext();

			if (promocion != null) {

				System.out.println(promocion.toString() + "\n\n");

				System.out.println("Acepta sugerencia? Ingrese S o N");
				String respuesta = scanner.next();

				if (respuesta.compareToIgnoreCase("S") == 0)
					resumenUsuario.agregarPromocion(promocion);
			}

		}

	}
	
	private static void atraccionesPreferidas(SugerenciaInterface sugerencia, ResumenUsuario resumenUsuario, Scanner scanner) {
		AtraccionesIteratorInterface atraccionesPreferidasIterator = sugerencia
				.crearAtraccionesPreferidasIterator();
		
		while (atraccionesPreferidasIterator.hasNext()) {

			Atraccion atraccion = atraccionesPreferidasIterator.getNext();

			if (atraccion != null) {

				System.out.println(atraccion.toString() + "\n\n");

				System.out.println("Acepta sugerencia? Ingrese S o N");
				String respuesta = scanner.next();

				if (respuesta.compareToIgnoreCase("S") == 0)
					resumenUsuario.agregarAtraccion(atraccion);
			}

		}
		
	}
	
	private static void promocionesNoPreferidas(SugerenciaInterface sugerencia, ResumenUsuario resumenUsuario, Scanner scanner) {
		
		PromocionesIteratorInterface promocionesNoPreferidasIterator = sugerencia
				.crearPromocionesNoPreferidasIterator();
		
		while (promocionesNoPreferidasIterator.hasNext()) {

			Promocion promocion = promocionesNoPreferidasIterator.getNext();

			if (promocion != null) {

				System.out.println(promocion.toString() + "\n\n");

				System.out.println("Acepta sugerencia? Ingrese S o N");
				String respuesta = scanner.next();

				if (respuesta.compareToIgnoreCase("S") == 0)
					resumenUsuario.agregarPromocion(promocion);
			}

		}
		
	}
	
	private static void atraccionesNoPreferidas(SugerenciaInterface sugerencia, ResumenUsuario resumenUsuario, Scanner scanner) {
		AtraccionesIteratorInterface atraccionesNoPreferidasIterator = sugerencia
				.crearAtraccionesNoPreferidasIterator();
		
		while (atraccionesNoPreferidasIterator.hasNext()) {

			Atraccion atraccion = atraccionesNoPreferidasIterator.getNext();

			if (atraccion != null) {

				System.out.println(atraccion.toString() + "\n\n");

				System.out.println("Acepta sugerencia? Ingrese S o N");
				String respuesta = scanner.next();

				if (respuesta.compareToIgnoreCase("S") == 0)
					resumenUsuario.agregarAtraccion(atraccion);
			}

		}
		
	}
	

	private static void guardarResumenUsuario(final ResumenUsuario resumenUsuario) {
		
		Archivo archivoResumen = new Archivo("resumenUsuarios");
		archivoResumen.escribirResumenUsuario(resumenUsuario);		
	}
}
