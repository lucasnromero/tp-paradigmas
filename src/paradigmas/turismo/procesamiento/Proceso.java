package paradigmas.turismo.procesamiento;

import java.util.List;
import java.util.Scanner;

import paradigmas.turismo.iterator.AtraccionesNoPreferidasIteratorInterface;
import paradigmas.turismo.iterator.AtraccionesPreferidasIteratorInterface;
import paradigmas.turismo.iterator.PromocionesNoPreferidasIteratorInterface;
import paradigmas.turismo.iterator.PromocionesPreferidasIteratorInterface;
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
		List<Promocion> listaPromociones = archivoPromociones.leerArchivoPromociones();

		for (Usuario usuario : listaUsuarios) {

			System.out.println("Nombre del usuario: " + usuario.getNombreUsuario());

			ResumenUsuario resumenUsuario = new ResumenUsuario(usuario);
			SugerenciaInterface sugerencia = new Sugerencia(listaAtracciones, listaPromociones, usuario,
					resumenUsuario);

			AtraccionesPreferidasIteratorInterface atraccionesPreferidasIterator = sugerencia
					.crearAtraccionesPreferidasIterator();

			AtraccionesNoPreferidasIteratorInterface atraccionesNoPreferidasIterator = sugerencia
					.crearAtraccionesNoPreferidasIterator();

			PromocionesPreferidasIteratorInterface promocionesPreferidasIterator = sugerencia
					.crearPromocionesPreferidasIterator();

			PromocionesNoPreferidasIteratorInterface promocionesNoPreferidasIterator = sugerencia
					.crearPromocionesNoPreferidasIterator();

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

			Proceso.guardarResumenUsuario(resumenUsuario);
		}

		scanner.close();

	}

	private static void mensajeDeBienvenida() {

		System.out.println("Bievenido/a al Turismo En La Tierra Media");
		System.out.println("-----------------------------------------");
	}

	private static void guardarResumenUsuario(final ResumenUsuario resumenUsuario) {
		
		Archivo archivoResumen = new Archivo("resumenUsuarios");
		archivoResumen.escribirResumenUsuario(resumenUsuario);		
	}
}
