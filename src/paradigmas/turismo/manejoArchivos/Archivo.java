package paradigmas.turismo.manejoArchivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
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
		
		//formato de usuario en el codigo:
		//nombreUsuario|tiempoDisponible|presupuesto|atraccionPreferida
		
		String[] partes = lineaLeida.split("\\|");

		String nombreUsuario = partes[0];
		double tiempoDisponible = Double.parseDouble(partes[1]);
		int presupuesto = Integer.parseInt(partes[2]);
		String atraccionPreferida = partes[3];

		return new Usuario(nombreUsuario, tiempoDisponible, presupuesto, atraccionPreferida);
	}
	
	public void escribirResumenUsuario(final ResumenUsuario resumenUsuario) {

		resumenUsuario.crearResumenUsuario();

        String rutaArchivo = "archivos/out/" + this.nombreArchivo + ".out";

        // Elimina el archivo existente para que no se pise
        File archivoExistente = new File(rutaArchivo);
        if (archivoExistente.exists()) {
        	archivoExistente.delete();
        }
	        
		FileWriter fileWriter = null;
		PrintWriter printerWriter = null;
		
		String linea = "RESUMEN DE COMPRA \n";
		
		try {
			
			if(resumenUsuario.getAtraccionesCompradas().size() > 0 || 
			   resumenUsuario.getPromocionesCompradas().size() > 0) {
				
				String promoAux = "";
				String atraccionAux = "";
				
				for(Promocion promocion : resumenUsuario.getPromocionesCompradas()) {
					promoAux = promoAux + "\n" + promocion.toString() + "\n";
				}
				
				if(promoAux == "") {
					promoAux = "No se compraron Promociones.\n" ;
				}
				
				for(Atraccion atraccion : resumenUsuario.getAtraccionesCompradas()) {
					atraccionAux = atraccionAux + "\n" + atraccion.toString() + "\n";
				}
				
				if(atraccionAux == "") {
					atraccionAux = "No se compraron Atracciones.\n" ;
				}

				 linea +=  "USUARIO: " + resumenUsuario.getUsuario().getNombreUsuario() +  "\n\n" 
								+ "Atracciones compradas:\n" + atraccionAux + "\n" 
								+ "Promociones compradas:\n" + promoAux + "\n" 
								+ "Gasto Total: " + resumenUsuario.getGastoTotal() + "\n"
								+ "Tiempo Invertido: " + resumenUsuario.getTiempoTotal() + "\n\n\n";
				
			} else {
				linea +=  "USUARIO: " + resumenUsuario.getUsuario().getNombreUsuario() +  "\n\n" 
						+ "No fue posible realizar la compra.\n\n" 
						+ "Gasto Total: " + resumenUsuario.getGastoTotal() + "\n"
						+ "Tiempo Invertido: " + resumenUsuario.getTiempoTotal() + "\n\n\n";
			}
			
			

			fileWriter = new FileWriter(rutaArchivo, true);
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
		//Formato atraccion
		//nombreAtraccion|costoVisita|promedioTiempo|cupo|tipoAtraccion
		
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

		//formato Promocion AxB
		//atraccion1;atraccion2;atraccionN|atraccionGratis(Atraccion2xej)|TipoDeAtracciones
		
		//formato Promocion Porcentual
		//atraccion1;atraccion2;atraccionN|porcentajeDescuento|TipoDeAtracciones
		
		//formato Promocion Absoluta
		//atraccion1;atraccion2;atraccionN|menosPrecio|TipoDeAtracciones
		
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
