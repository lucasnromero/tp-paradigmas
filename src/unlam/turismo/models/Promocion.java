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
		this.idAtracciones = idAtracciones;
		this.tipoDePromocion = tipoDePromocion;
	}

	
}
