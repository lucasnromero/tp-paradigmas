package paradigmas.turismo.manejoArchivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import paradigmas.turismo.models.Atraccion;
import paradigmas.turismo.models.Promocion;
import paradigmas.turismo.models.PromocionAbsoluta;
import paradigmas.turismo.models.PromocionAxB;
import paradigmas.turismo.models.PromocionPorcentual;
import paradigmas.turismo.models.Usuario;
import paradigmas.turismo.resumenUsuario.ResumenUsuario;

public class Archivo {

	private String nombreArchivo;

	public Archivo(final String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	//REGION Usuario
	public List<Usuario> leerArchivoUsuarios() {

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();

		BufferedReader bufferedReader = null;

		try {

			FileReader fileReader = new FileReader("archivos/in/" + this.nombreArchivo + ".in");
			bufferedReader = new BufferedReader(fileReader);

			String linea;

			while ((linea = bufferedReader.readLine()) != null) {

				Usuario usuario = this.getUsuarioLeido(linea);
				listaUsuarios.add(usuario);
			}

		} catch (FileNotFoundException fileNotFoundException) {

			fileNotFoundException.printStackTrace();

		} catch (IOException ioException) {

			ioException.printStackTrace();
		}

		finally {

			try {
				bufferedReader.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}

		return listaUsuarios;
	}

	private Usuario getUsuarioLeido(String lineaLeida) {

		String[] partes = lineaLeida.split("\\|");

		String nombreUsuario = partes[0];
		double tiempoDisponible = Double.parseDouble(partes[1]);
		int presupuesto = Integer.parseInt(partes[2]);
		String atraccionPreferida = partes[3];

		return new Usuario(nombreUsuario, tiempoDisponible, presupuesto, atraccionPreferida);
	}
	
	public void escribirResumenUsuario(final ResumenUsuario resumenUsuario) {

		resumenUsuario.crearResumenUsuario();

		FileWriter fileWriter = null;
		PrintWriter printerWriter = null;

		try {

			String nombreUsuario = resumenUsuario.getUsuario().getNombreUsuario();
			int gastoTotal = resumenUsuario.getGastoTotal();
			double tiempoInvertido = resumenUsuario.getTiempoTotal();
			String[] nombresAtracciones = this.atraccionesCompradas(resumenUsuario.getAtraccionesCompradas());
			//String[] nombresPromociones = this.promocionesCompradas(resumenUsuario.getPromocionesCompradas());
			
			String promos = "";
			for(Promocion promocion : resumenUsuario.getPromocionesCompradas()) {
				promos = promos + "\n*" + promocion.toString() + "\n";
			}

			/*String linea = "Nombre: " + nombreUsuario + "\n" + "Gasto Total: " + gastoTotal + "\n"
					+ "Tiempo Invertido: " + tiempoInvertido + "\n" + "Atracciones compradas: "
					+ Arrays.toString(nombresAtracciones) + "\n" + "Promociones compradas:"
					+ Arrays.toString(nombresPromociones) + "\n\n\n";*/
			
			String linea = "Nombre: " + nombreUsuario +  "\n\n" + "Atracciones compradas: "
					+ Arrays.toString(nombresAtracciones) + "\n\n" + "Promociones compradas:"
					+ promos + "\nGasto Total: " + gastoTotal + "\n"
							+ "Tiempo Invertido: " + tiempoInvertido + "\n\n\n";

			fileWriter = new FileWriter("archivos/out/" + this.nombreArchivo + ".out", true);
			printerWriter = new PrintWriter(fileWriter);

			printerWriter.print(linea);

		} catch (IOException ioException) {

			ioException.printStackTrace();

		} finally {

			printerWriter.close();

			try {
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private String[] atraccionesCompradas(final List<Atraccion> atracciones) {

		String[] nombresAtraccionesCompradas = new String[atracciones.size()];

		int i = 0;

		for (Atraccion atraccion : atracciones) {
			nombresAtraccionesCompradas[i] = atraccion.getNombreAtraccion();
			i++;
		}

		return nombresAtraccionesCompradas;
	}

	private String[] promocionesCompradas(final List<Promocion> promociones) { //quedó obsoleta en base a mi solucion CORO

		String[] nombresPromocionesCompradas = null;

		for (Promocion promocion : promociones) {

			List<Atraccion> atraccionesDeLaPromocion = promocion.getAtracciones();
			nombresPromocionesCompradas = new String[atraccionesDeLaPromocion.size()];
			int i = 0;

			for (Atraccion atraccion : atraccionesDeLaPromocion) {

				nombresPromocionesCompradas[i] = atraccion.getNombreAtraccion();
				i++;
			}

		}

		return nombresPromocionesCompradas;
	}
	
	//ENDREGION Usuario
	
	public List<Atraccion> leerArchivoAtracciones() {

		List<Atraccion> listaAtracciones = new ArrayList<Atraccion>();

		BufferedReader bufferedReader = null;

		try {

			FileReader fileReader = new FileReader("archivos/in/" + this.nombreArchivo + ".in");
			bufferedReader = new BufferedReader(fileReader);

			String linea;

			while ((linea = bufferedReader.readLine()) != null) {

				Atraccion atraccion = this.getAtraccionLeida(linea);
				listaAtracciones.add(atraccion);
			}

		} catch (FileNotFoundException fileNotFoundException) {

			fileNotFoundException.printStackTrace();

		} catch (IOException ioException) {

			ioException.printStackTrace();
		}

		finally {

			try {
				bufferedReader.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}

		return listaAtracciones;
	}

	private Atraccion getAtraccionLeida(String lineaLeida) {

		String[] partes = lineaLeida.split("\\|");

		String nombreAtraccion = partes[0];
		int costoVisita = Integer.parseInt(partes[1]);
		double promedioTiempo = Double.parseDouble(partes[2]);
		int cupo = Integer.parseInt(partes[3]);
		String tipoAtraccion = partes[4];

		return new Atraccion(nombreAtraccion, costoVisita, promedioTiempo, cupo, tipoAtraccion);
	}
	
	public List<Promocion> leerArchivoPromociones(List<Atraccion> atraccionesLeidas) {

		List<Promocion> listaPromociones = new ArrayList<Promocion>();

		BufferedReader bufferedReader = null;

		try {

			FileReader fileReader = new FileReader("archivos/in/" + this.nombreArchivo + ".in");
			bufferedReader = new BufferedReader(fileReader);

			String linea;

			while ((linea = bufferedReader.readLine()) != null) {

				Promocion promocion = this.getPromocionLeida(linea, atraccionesLeidas);
				listaPromociones.add(promocion);
			}

		} catch (FileNotFoundException fileNotFoundException) {

			fileNotFoundException.printStackTrace();

		} catch (IOException ioException) {

			ioException.printStackTrace();
		}

		finally {

			try {
				bufferedReader.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}

		return listaPromociones;
	}

	private Promocion getPromocionLeida(String lineaLeida, List<Atraccion> atraccionesLeidas) {

		String[] partes = lineaLeida.split("\\|");

		String[] atraccionesDelPaquete = partes[0].split(";");
		
		List<Atraccion> listaAtraccionesDeLaPromocion = new ArrayList<Atraccion>();

		//mapeo
		for(String atraccion: atraccionesDelPaquete) {
			listaAtraccionesDeLaPromocion.add(buscarAtraccionPorNombre(atraccionesLeidas,atraccion));
		}	
		
		if(partes[2].equals("AxB")) {
			return new PromocionAxB(listaAtraccionesDeLaPromocion, buscarAtraccionPorNombre(atraccionesLeidas, partes[1]));
		} else if(partes[2].equals("Porcentual")) {
			return new PromocionPorcentual(listaAtraccionesDeLaPromocion, Double.parseDouble(partes[1]));
		} else if(partes[2].equals("Absoluta")) {
			return new PromocionAbsoluta(listaAtraccionesDeLaPromocion, Integer.parseInt(partes[1]));
		}

		//si retorna null, algo está mal en el archivo
		return null;
	}

	private static Atraccion buscarAtraccionPorNombre(List<Atraccion> listaAtracciones, String nombre) {
        for (Atraccion atraccion : listaAtracciones) {
            if (atraccion.getNombreAtraccion().equals(nombre)) {
                return atraccion;
            }
        }
        return null; // Si no se encuentra la atracción, se retorna null
    }
	

	
}
