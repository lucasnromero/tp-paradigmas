package unlam.turismo.models;

import java.util.ArrayList;
import java.util.List;

public class Promocion extends Resumen {

	private int id;
	private List<Integer> idAtracciones= new ArrayList<Integer>();
	private TipoDePromocion tipoDePromocion;
	
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
	
	public void leerPromocion() {
		
			System.out.println("ID: " + getId() + "\n" 
			+ "Costo: $" + getCosto()  + "\n"
			+ "Tiempo: " + getTiempo()  + "\n"
			+ "Tipo de promoción: " + getTipoDePromocion()  + "\n"
			+ "IDs atracciones: " + getIdAtracciones()  + "\n");
			
	}

	
}
