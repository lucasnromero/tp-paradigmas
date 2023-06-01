package unlam.turismo.models;

import java.util.ArrayList;
import java.util.List;

public class Promocion extends Resumen {

	private int id;
	private List<Integer> idAtracciones= new ArrayList<Integer>();
	private TipoDePromocion tipoDePromocion;
	
	//DEFINIR COMO TRATAMOS LOS TIPOS DE PROMOCIONES Y EL COSTO
	
	public Promocion(String nombre, double costo, double tiempo, int cupo, int id, List<Integer> idAtracciones,
			TipoDePromocion tipoDePromocion) {

		super(nombre, costo, tiempo, cupo);

		this.id = id;
		this.setIdAtracciones(idAtracciones);
		this.setTipoDePromocion(tipoDePromocion);
	}

	public int getId() {
		return this.id;
	}
	public TipoDePromocion getTipoDePromocion() {
		return tipoDePromocion;
	}

	public void setTipoDePromocion(TipoDePromocion tipoDePromocion) {
		this.tipoDePromocion = tipoDePromocion;
	}

	public List<Integer> getIdAtracciones() {
		return idAtracciones;
	}

	public void setIdAtracciones(List<Integer> idAtracciones) {
		this.idAtracciones = idAtracciones;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getCosto() {
		return this.costo;
	}
	
	public double getTiempo() {
		return this.tiempo;
	}
	
	public void leerPromocion(List<Atraccion> listaAtracciones) {
		
		double precioOriginal = 0;
		double tiempoTotal = 0;
		List<String> nombres = new ArrayList<String>();
		
		System.out.println("Promocion: " + getNombre());
				
		// Itera sobre los IDs
		for (int id : this.idAtracciones) {
		    // Busca la atracción con el ID correspondiente en la lista de atracciones
		    for (Atraccion atraccion : listaAtracciones ) {
		        if (atraccion.getId() == id) {
		           nombres.add(atraccion.getNombre());
		           precioOriginal += atraccion.getCosto();
		           tiempoTotal += atraccion.getTiempo();
		        }
		    }
		}
		
		System.out.println("- Atracciones incluidas: " + nombres);
		System.out.println("- Duracion: " + tiempoTotal);
		System.out.println("- Precio original: " + precioOriginal);
		System.out.println("- Precio promocional: " + this.costo);

			
	}

	
}
