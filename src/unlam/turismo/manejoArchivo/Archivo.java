package unlam.turismo.manejoArchivo;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import unlam.turismo.models.Atraccion;
import unlam.turismo.models.Promocion;
import unlam.turismo.models.TipoDeAtraccion;
import unlam.turismo.models.TipoDePromocion;
import unlam.turismo.models.Usuario;

public class Archivo {

	private String nombreArchivo;

	public Archivo(final String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

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

		int idAtraccion = Integer.parseInt(partes[0]);
		String nombreAtraccion = partes[1];
		TipoDeAtraccion tipoAtraccion = TipoDeAtraccion.valueOf(partes[2]);
		double costo = Double.parseDouble(partes[3]);
		double tiempo = Double.parseDouble(partes[4]);
		int cupo = Integer.parseInt(partes[5]);

		return new Atraccion(nombreAtraccion, costo, tiempo, cupo, idAtraccion, tipoAtraccion);
	}
	
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

		//id|nombre|tipoDeAtraccion|presupuesto|tiempo
		String[] partes = lineaLeida.split("\\|");

		int idUsuario = Integer.parseInt(partes[0]);
		String nombreUsuario = partes[1];
		TipoDeAtraccion tipoAtraccion = TipoDeAtraccion.valueOf(partes[2]);
		double presupuesto = Double.parseDouble(partes[3]);
		double tiempo = Double.parseDouble(partes[4]);

		return new Usuario(idUsuario, nombreUsuario, presupuesto, tiempo, tipoAtraccion, null);
	}
	
	public List<Promocion> leerArchivoPromociones() {

		//id|nombre|costo|tiempo|2;1;4|tipodepromocion
		List<Promocion> listaPromociones = new ArrayList<Promocion>();

		BufferedReader bufferedReader = null;

		try {

			File archivo = new File("archivos/in/" + this.nombreArchivo + ".in");
			
			// Validar si el archivo no existe
	        if (!archivo.exists()) {
	            System.out.println("El archivo no existe."); //debería ser una excepcion
	            return listaPromociones;
	        }

	        // Validar si el archivo está vacío
	        if (archivo.length() == 0) {
	            System.out.println("El archivo está vacío."); //debería ser una excepcion
	            return listaPromociones;
	        }
	        
	        FileReader fileReader = new FileReader(archivo);
			bufferedReader = new BufferedReader(fileReader);

			String linea;

			while ((linea = bufferedReader.readLine()) != null) {

				Promocion promocion = this.getPromocionLeida(linea);
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
	
	private Promocion getPromocionLeida(String lineaLeida) {

		//id|nombre|costo|tiempo|2;1;4|tipodepromocion
		
		String[] partes = lineaLeida.split("\\|");

		int idPromocion = Integer.parseInt(partes[0]);
		String nombrePromocion = partes[1];
		double costo = Double.parseDouble(partes[2]);
		String atributos = partes[3];
		TipoDePromocion tipoPromocion = TipoDePromocion.valueOf(partes[4]);

		String[] listaAtributos = atributos.split(";");

		List<Integer> idAtracciones= new ArrayList<Integer>();

		for (int i = 0; i < listaAtributos.length; i++) {
			idAtracciones.add(Integer.parseInt(listaAtributos[i]));
		}

		return new Promocion(nombrePromocion, costo, 0, 0, idPromocion, idAtracciones, tipoPromocion);
	}
}
