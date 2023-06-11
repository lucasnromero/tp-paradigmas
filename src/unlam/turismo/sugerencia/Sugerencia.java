package unlam.turismo.sugerencia;

import java.util.ArrayList;
import java.util.List;

import unlam.turismo.models.Atraccion;
import unlam.turismo.models.Promocion;

public class Sugerencia {
	
	private List<Promocion> listaPromociones = new ArrayList<Promocion>();
	private List<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
	
	public Sugerencia(List<Promocion> listaPromociones, List<Atraccion> listaAtracciones) {
		
		super();
		
		this.listaPromociones = listaPromociones;
		this.listaAtracciones = listaAtracciones;
		
	}	
	
	public void addListaPromociones(Promocion promocion) {
		this.listaPromociones.add(promocion);
	}
	
	public void addListaAtracciones(Atraccion atraccion) {
		this.listaAtracciones.add(atraccion);
	}
}
