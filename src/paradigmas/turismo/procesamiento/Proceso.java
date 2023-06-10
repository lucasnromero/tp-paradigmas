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

			usuario.mostrarUsuarioInicio();

			ResumenUsuario resumenUsuario = new ResumenUsuario(usuario);
			SugerenciaInterface sugerencia = new Sugerencia(listaAtracciones, listaPromociones, usuario,
					resumenUsuario);

			PromocionesIteratorInterface promocionesPreferidasIterator = sugerencia
					.crearPromocionesPreferidasIterator();
			AtraccionesIteratorInterface atraccionesPreferidasIterator = sugerencia
					.crearAtraccionesPreferidasIterator();
			PromocionesIteratorInterface promocionesNoPreferidasIterator = sugerencia
					.crearPromocionesNoPreferidasIterator();
			AtraccionesIteratorInterface atraccionesNoPreferidasIterator = sugerencia
					.crearAtraccionesNoPreferidasIterator();

			Proceso.promocionesIterator(promocionesPreferidasIterator, sugerencia, resumenUsuario, scanner);
			Proceso.atraccionesIterator(atraccionesPreferidasIterator, sugerencia, resumenUsuario, scanner);
			Proceso.promocionesIterator(promocionesNoPreferidasIterator, sugerencia, resumenUsuario, scanner);
			Proceso.atraccionesIterator(atraccionesNoPreferidasIterator, sugerencia, resumenUsuario, scanner);

			Proceso.guardarYMostrarResumenUsuarioValido(resumenUsuario);

		}

		System.out.println("\u001B[1m\n¡GRACIAS POR UTILIZAR NUESTRO SISTEMA!\u001B[0m \n ");
		scanner.close();

	}

	private static void guardarYMostrarResumenUsuarioValido(final ResumenUsuario resumenUsuario) {
		if (resumenUsuario.sugerenciaDisponible()) {
			resumenUsuario.mostrarResumen();
		}

		String nombreArchivo = resumenUsuario.getUsuario().getNombreUsuario() + "ResumenUsuario";

		Archivo archivoResumen = new Archivo(nombreArchivo);
		archivoResumen.escribirResumenUsuario(resumenUsuario);
	}

	private static void promocionesIterator(PromocionesIteratorInterface promocionesIterator,
			SugerenciaInterface sugerencia, ResumenUsuario resumenUsuario, Scanner scanner) {

		while (promocionesIterator.hasNext()) {

			Promocion promocion = promocionesIterator.getNext();

			if (promocion != null) {

				System.out.println("\n" + promocion.toStringUI() + "\n\n");

				boolean respuestaValida = false;
				do {
					System.out.println("¿Acepta sugerencia? Ingrese \u001B[1mS\u001B[0m o \u001B[1mN\u001B[0m");
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

	private static void atraccionesIterator(AtraccionesIteratorInterface atraccionesIterator,
			SugerenciaInterface sugerencia, ResumenUsuario resumenUsuario, Scanner scanner) {

		while (atraccionesIterator.hasNext()) {

			Atraccion atraccion = atraccionesIterator.getNext();

			if (atraccion != null) {

				System.out.println();
				System.out.println("\n" + atraccion.toStringUI() + "\n\n");

				boolean respuestaValida = false;
				do {
					System.out.println("¿Acepta sugerencia? Ingrese \u001B[1mS\u001B[0m o \u001B[1mN\u001B[0m");
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

	private static void mensajeDeBienvenida() {
		System.out.println(
				"\n******************************************************************************************");

		System.out.println(" \t____   _____  ______  _   _ __      __ ______  _   _  _____  _____    ____  \r\n"
				+ "\t|  _ \\ |_   _||  ____|| \\ | |\\ \\    / /|  ____|| \\ | ||_   _||  __ \\  / __ \\ \r\n"
				+ "\t| |_) |  | |  | |__   |  \\| | \\ \\  / / | |__   |  \\| |  | |  | |  | || |  | |\r\n"
				+ "\t|  _ <   | |  |  __|  | . ` |  \\ \\/ /  |  __|  | . ` |  | |  | |  | || |  | |\r\n"
				+ "\t| |_) | _| |_ | |____ | |\\  |   \\  /   | |____ | |\\  | _| |_ | |__| || |__| |\r\n"
				+ "\t|____/ |_____||______||_| \\_|    \\/    |______||_| \\_||_____||_____/  \\____/ \r\n"

				+ "");
		System.out.println("\t\t\t\t          \r\n" + "\t\t\t\t\t    /\\    \r\n" + "\t\t\t\t\t   /  \\   \r\n"
				+ "\t\t\t\t\t  / /\\ \\  \r\n" + "\t\t\t\t\t / ____ \\ \r\n" + "\t\t\t\t\t/_/    \\_\\\r\n" + "");
		System.out.println("\t\t _______  _    _  _____   _____   _____  __  __   ____  \r\n"
				+ "\t\t|__   __|| |  | ||  __ \\ |_   _| / ____||  \\/  | / __ \\ \r\n"
				+ "\t\t   | |   | |  | || |__) |  | |  | (___  | \\  / || |  | |\r\n"
				+ "\t\t   | |   | |  | ||  _  /   | |   \\___ \\ | |\\/| || |  | |\r\n"
				+ "\t\t   | |   | |__| || | \\ \\  _| |_  ____) || |  | || |__| |\r\n"
				+ "\t\t   |_|    \\____/ |_|  \\_\\|_____||_____/ |_|  |_| \\____/ \r\n" + "");
		System.out.println("\t\t ______  _   _   ______  _        __  __   _____  _    _ \r\n"
				+ "\t\t|  ____|| \\ | | |  ____|| |      |  \\/  | / ____|| |  | |\r\n"
				+ "\t\t| |__   |  \\| | | |__   | |      | \\  / || |     | |  | |\r\n"
				+ "\t\t|  __|  | . ` | |  __|  | |      | |\\/| || |     | |  | |\r\n"
				+ "\t\t| |____ | |\\  | | |____ | |____  | |  | || |____ | |__| |\r\n"
				+ "\t\t|______||_| \\_| |______||______| |_|  |_| \\_____| \\____/ \r\n"

				+ "");
		System.out.println();
		System.out.println(
				"******************************************************************************************\n");
	}

}
